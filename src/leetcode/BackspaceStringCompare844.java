package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 844. Backspace String Compare
 * algorithm: Stack, Two Pointers
 * time complexity: O(N + M)
 * space complexity: O(N + M)
 * Runtime: 1 ms, faster than 70.75% of Java online submissions
 * Memory Usage: 34.8 MB, less than 100.00% of Java online submissions
 */
public class BackspaceStringCompare844 {

  public static void main(String[] args) {
    BackspaceStringCompare844 problem = new BackspaceStringCompare844();
    problem.test();
  }

  private void test() {
    System.out.println(backspaceCompare("ab#c", "ad#c"));//true
    System.out.println(backspaceCompare("ab##", "c#d#"));//true
    System.out.println(backspaceCompare("a##c", "#a#c"));//true
    System.out.println(backspaceCompare("a#c", "b"));//false
    System.out.println(backspaceCompare("gcf#cd##", "e#gf#ck#"));//true
    System.out.println(backspaceCompare("gcf#cd##", "pe#gf#ck#"));//false
  }

  public boolean backspaceCompare(String s, String t) {
    return build(s).equals(build(t));
  }

  private String build(String s) {
    char[] chs = s.toCharArray();

    Deque<Character> stack = new ArrayDeque<>();

    for (char ch : chs) {
      if (ch != '#') {
        stack.push(ch);
      } else if (!stack.isEmpty()) {
        stack.pop();
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.toString();
  }

  private static class V2 {
    public boolean backspaceCompare(String s, String t) {
      char[] chs1 = s.toCharArray();
      char[] chs2 = t.toCharArray();

      int i = chs1.length - 1;
      int j = chs2.length - 1;

      while (i >= 0 || j >= 0) {
        for (int b = 0; i >= 0; i--) {
          if (chs1[i] == '#') {
            b++;
          } else if (b > 0) {
            b--;
          } else {
            break;
          }
        }

        for (int b = 0; j >= 0; j--) {
          if (chs2[j] == '#') {
            b++;
          } else if (b > 0) {
            b--;
          } else {
            break;
          }
        }

        if ((i >= 0 && j >= 0 && chs1[i] != chs2[j]) ||
            (i >= 0 && j < 0) || (i < 0 && j >= 0)) {
          return false;
        }

        i--;
        j--;
      }

      return true;
    }
  }

}

package leetcode.p0017;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 1047. Remove All Adjacent Duplicates In String
 * algorithm: Stack
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 13 ms, faster than 70.08% of Java online submissions
 * Memory Usage: 40.3 MB, less than 100.00% of Java online submissions
 */
public class RemoveAllAdjacentDuplicatesInString1047 {

  public static void main(String[] args) {
    RemoveAllAdjacentDuplicatesInString1047 problem = new RemoveAllAdjacentDuplicatesInString1047();
    problem.test();
  }

  private void test() {
    System.out.println(removeDuplicates("abbaca"));
    System.out.println(removeDuplicates("aaa"));
  }

  public String removeDuplicates(String s) {
    Deque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (stack.isEmpty() || stack.peek() != ch) {
        stack.push(ch);
      } else {
        stack.poll();
      }
    }

    StringBuilder sb = new StringBuilder();

    for (char ch : stack) {
      sb.append(ch);
    }

    sb.reverse();

    return sb.toString();
  }

}
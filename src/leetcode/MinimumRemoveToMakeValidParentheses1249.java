package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 1249. Minimum Remove to Make Valid Parentheses
 * algorithm: String, Stack
 * time complexity: O(n)
 * space complexity: O(n)
 * Runtime: 15 ms, faster than 80.88% of Java online submissions for Minimum Remove to Make Valid Parentheses.
 * Memory Usage: 37.9 MB, less than 100.00% of Java online submissions for Minimum Remove to Make Valid Parentheses.
 */
public class MinimumRemoveToMakeValidParentheses1249 {

  public static void main(String[] args) {
    MinimumRemoveToMakeValidParentheses1249 problem = new MinimumRemoveToMakeValidParentheses1249();
    problem.test();
  }

  private void test() {
    System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    System.out.println(minRemoveToMakeValid("a)b(c)d"));
    System.out.println(minRemoveToMakeValid("))(("));
    System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
  }

  public String minRemoveToMakeValid(String s) {
    boolean[] chars = new boolean[s.length()];

    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch == '(') {
        stack.push(i);
      } else if (ch == ')') {
        if (stack.isEmpty()) {
          chars[i] = false;
        } else {
          chars[stack.pop()] = true;
          chars[i] = true;
        }
      } else {
        chars[i] = true;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if (chars[i]) {
        sb.append(s.charAt(i));
      }
    }

    return sb.toString();
  }

}

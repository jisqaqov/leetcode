package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 301. Remove Invalid Parentheses
 */
public class RemoveInvalidParentheses301 {

  public static void main(String[] args) {
    RemoveInvalidParentheses301 problem = new RemoveInvalidParentheses301();
    problem.test();
    problem.test2();
  }

  private void test() {
    System.out.println("v1:");
    System.out.println(removeInvalidParentheses("()())()"));
    System.out.println(removeInvalidParentheses("(a)())()"));
    System.out.println(removeInvalidParentheses(")("));
    System.out.println(removeInvalidParentheses("("));
    System.out.println(removeInvalidParentheses("(a(b(c)d)"));
  }

  private void test2() {
    V2 problem = new V2();

    System.out.println("v2:");
    System.out.println(problem.removeInvalidParentheses("()())()"));
    System.out.println(problem.removeInvalidParentheses("(a)())()"));
    System.out.println(problem.removeInvalidParentheses(")("));
    System.out.println(problem.removeInvalidParentheses("("));
    System.out.println(problem.removeInvalidParentheses("(a(b(c)d)"));
  }

  /**
   * algorithm: DFS
   * time complexity: O(2^N)
   * space complexity: O(N)
   * Runtime: 15 ms, faster than 48.12% of Java online submissions
   * Memory Usage: 48.5 MB, less than 6.52% of Java online submissions
   */
  public List<String> removeInvalidParentheses(String s) {
    Set<String> output = new HashSet<>();

    int remOpen = 0;
    int remClose = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        remOpen++;
      } else if (s.charAt(i) == ')') {
        if (remOpen > 0) {
          remOpen--;
        } else {
          remClose++;
        }
      }
    }

    int ops = remOpen + remClose;

    gen(s.toCharArray(), new StringBuilder(), ops, 0, 0, output);

    if (!output.isEmpty()) {
      return new ArrayList<>(output);
    }

    return new ArrayList<>(output);
  }

  private void gen(char[] s, StringBuilder sb, int ops, int bal, int index, Set<String> output) {
    if (ops < 0 || bal < 0) {
      return;
    }

    if (index == s.length) {
      if (bal == 0) {
        output.add(sb.toString());
      }

      return;
    }

    int len = sb.length();

    if (s[index] == '(') {
      gen(s, sb, ops - 1, bal, index + 1, output);
      gen(s, sb.append(s[index]), ops, bal + 1, index + 1, output);
    } else if (s[index] == ')') {
      gen(s, sb, ops - 1, bal, index + 1, output);
      gen(s, sb.append(s[index]), ops, bal - 1, index + 1, output);
    } else {
      gen(s, sb.append(s[index]), ops, bal, index + 1, output);
    }

    sb.setLength(len);
  }

  private static class V2 {

    /**
     * https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/Share-my-Java-BFS-solution
     * algorithm: BFS
     * time complexity: O(n*2^(n-1))
     * space complexity: O(N)
     * Runtime: 49 ms, faster than 39.11% of Java online submissions for Remove Invalid Parentheses.
     * Memory Usage: 40.1 MB, less than 80.43% of Java online submissions for Remove Invalid Parentheses.
     */
    public List<String> removeInvalidParentheses(String s) {
      List<String> output = new ArrayList<>();

      Set<String> visited = new HashSet<>();
      Queue<String> queue = new LinkedList<>();

      queue.add(s);
      visited.add(s);

      boolean isValid = false;

      while (!queue.isEmpty()) {
        String b = queue.poll();

        if (isValid(b)) {
          output.add(b);
          isValid = true;
        }

        if (isValid) {
          continue;
        }

        for (int i = 0; i < b.length(); i++) {
          char ch = b.charAt(i);
          if (ch != '(' && ch != ')') {
            continue;
          }

          String t = b.substring(0, i) + b.substring(i + 1);

          if (!visited.contains(t)) {
            visited.add(t);
            queue.add(t);
          }
        }
      }

      return output;
    }

    private boolean isValid(String s) {
      int counter = 0;

      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
          counter++;
        } else if (s.charAt(i) == ')') {
          counter--;
        }

        if (counter < 0) {
          return false;
        }
      }

      return counter == 0;
    }

  }

}

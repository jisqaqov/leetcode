package leetcode;

import java.util.ArrayList;
import java.util.Collections;
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
  }

  private void test() {
    System.out.println("bfs:");
    System.out.println(removeInvalidParentheses("()())()"));
    System.out.println(removeInvalidParentheses("(a)())()"));
    System.out.println(removeInvalidParentheses(")("));
    System.out.println(removeInvalidParentheses("("));
    System.out.println(removeInvalidParentheses("(a(b(c)d)"));

    System.out.println("dfs:");
    SolutionOnDFS dfsSol = new SolutionOnDFS();
    System.out.println(dfsSol.removeInvalidParentheses("()())()"));
    System.out.println(dfsSol.removeInvalidParentheses("(a)())()"));
    System.out.println(dfsSol.removeInvalidParentheses(")("));
    System.out.println(dfsSol.removeInvalidParentheses("("));
    System.out.println(dfsSol.removeInvalidParentheses("(a(b(c)d)"));
  }

  /**
   * https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/Share-my-Java-BFS-solution
   * algorithm: BFS
   * time complexity: O(n*2^(n-1))
   * space complexity: O(N)
   * Runtime: 49 ms, faster than 39.11% of Java online submissions for Remove Invalid Parentheses.
   * Memory Usage: 40.1 MB, less than 80.43% of Java online submissions for Remove Invalid Parentheses.
   */
  public List<String> removeInvalidParentheses(String s) {
    List<String> sol = new ArrayList<>();

    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();

    queue.add(s);
    visited.add(s);

    boolean isValid = false;

    while (!queue.isEmpty()) {
      String b = queue.poll();

      if (isValid(b)) {
        sol.add(b);
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

    return sol;
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

  /**
   * algorithm: DFS
   * time complexity: O(2^N)
   * space complexity: O(N)
   * Runtime: 49 ms, faster than 39.11% of Java online submissions for Remove Invalid Parentheses.
   * Memory Usage: 40.1 MB, less than 80.43% of Java online submissions for Remove Invalid Parentheses.
   */
  private static class SolutionOnDFS {
    public List<String> removeInvalidParentheses(String s) {
      if (s == null || s.length() == 0) {
        return new ArrayList<>(Collections.singleton(""));
      }

      int[] temp = calc(0, 0, s.charAt(0));
      int la = temp[0];
      int ra = temp[1];

      for (int i = 1; i < s.length(); i++) {
        temp = calc(la, ra, s.charAt(i));
        la = temp[0];
        ra = temp[1];
      }

      Set<String> sol = new HashSet<>();

      generate(s, "", true, -1, 0, 0, 0, 0, la, ra, sol);

      if (!sol.isEmpty()) {
        return new ArrayList<>(sol);
      }

      return new ArrayList<>(Collections.singleton(""));
    }

    private void generate(String s, String t, boolean remove, int index, int l, int r,
      int lm, int rm, int la, int ra, Set<String> sol) {

      if (index >= 0) {
        char currChar = s.charAt(index);
        boolean isBracket = isBracket(currChar);

        if (!isBracket && remove) {
          return;
        }

        if (!remove) {
          if (currChar == '(') {
            l++;
          } else if (currChar == ')') {
            r++;
          }
        }

        if (isBracket) {
          if (!remove) {
            int[] temp = calc(lm, rm, currChar);
            lm = temp[0];
            rm = temp[1];
            t = t + currChar;
          } else if (currChar == '(') {
            lm++;
          } else if (currChar == ')') {
            rm++;
          }
        } else {
          t = t + currChar;
        }

        if (r > l) {
          return;
        }

        if (index == s.length() - 1) {
          if (l == r && lm == la && rm == ra) {
            sol.add(t);
          }

          return;
        }
      }

      generate(s, t, false, index + 1, l, r, lm, rm, la, ra, sol);
      generate(s, t, true, index + 1, l, r, lm, rm, la, ra, sol);
    }

    private boolean isBracket(char ch) {
      return ch == '(' || ch == ')';
    }

    private int[] calc(int l, int r, char ch) {
      if (ch == ')') {
        if (l == 0) {
          r++;
        } else {
          l--;
        }
      } else if (ch == '(') {
        l++;
      }

      return new int[]{l, r};
    }
  }

}

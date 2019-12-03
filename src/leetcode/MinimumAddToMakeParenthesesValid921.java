package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 921. Minimum Add to Make Parentheses Valid
 * algorithm: Greedy
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
 * Memory Usage: 34.1 MB, less than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
 */
public class MinimumAddToMakeParenthesesValid921 {

  public static void main(String[] args) {
    MinimumAddToMakeParenthesesValid921 problem = new MinimumAddToMakeParenthesesValid921();
    problem.test();
  }

  private void test() {
    System.out.println(minAddToMakeValid("())"));//1
    System.out.println(minAddToMakeValid("((("));//3
    System.out.println(minAddToMakeValid("()"));//0
    System.out.println(minAddToMakeValid("()))(("));//4
  }

  public int minAddToMakeValid(String s) {
    int left = 0;
    int right = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        left++;
      } else if (s.charAt(i) == ')') {
        if (left == 0) {
          right++;
        } else {
          left--;
        }
      }
    }

    return left + right;
  }

}

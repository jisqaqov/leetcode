package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 678. Valid Parenthesis String
 * time complexity: O(n)
 * space complexity: O(1)
 * algorithm:
 * pending........
 */
public class ValidParenthesisString678 {

  public static void main(String[] args) {
    ValidParenthesisString678 solution = new ValidParenthesisString678();
    solution.test();
  }

  public void test() {
//    System.out.println(checkValidString(
//        "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
//    System.out.println(checkValidString("()"));
    System.out.println(checkValidString("((*()"));
//    System.out.println(checkValidString("(*))"));
  }

  public boolean checkValidString(String s) {
    if (s.length() == 0) {
      return true;
    }

    int open = 0, close = 0;

    int[][] brs = new int[s.length()][2];
    List<Integer> stars = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch == '(') {
        open++;
      } else if (ch == ')') {
        close++;
      } else {
        stars.add(i);
      }

      brs[i][0] = open;
      brs[i][1] = close;
    }

    int[] stars2 = stars.stream()
        .mapToInt(i -> i)
        .toArray();

    return checkValidString(s, 0, 1, 0, brs, stars2) ||
        checkValidString(s, 0, 0, 1, brs, stars2) ||
        checkValidString(s, 0, 0, 0, brs, stars2);
  }

  private boolean checkValidString(String s, int k, int open, int close, int[][] brs, int[] stars) {
    if (k > stars.length) {
        return true;
    }

    int index = k == stars.length? s.length() - 1: stars[k];

    int balance = open + brs[index][0] - close - brs[index][1];

    if (checkValidString(s, k + 1, open + 1, close, brs, stars) ||
        checkValidString(s, k + 1, open, close + 1, brs, stars) ||
        checkValidString(s, k + 1, open, close, brs, stars)) {
      return true;
    }

    return balance == 0;
  }

}


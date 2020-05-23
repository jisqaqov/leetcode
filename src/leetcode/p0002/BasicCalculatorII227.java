package leetcode.p0002;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 227. Basic Calculator II
 * algorithm: String, Stack
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 8 ms, faster than 81.05% of Java online submissions
 * Memory Usage: 41.8 MB, less than 5.97% of Java online submissions
 */
public class BasicCalculatorII227 {

  public static void main(String[] args) {
    BasicCalculatorII227 problem = new BasicCalculatorII227();
    problem.test();
  }

  private void test() {
    System.out.println(calculate("3+2*2"));
    System.out.println(calculate(" 3/2 "));
    System.out.println(calculate(" 3+5 / 2 "));
  }

  public int calculate(String s) {
    Deque<Integer> stack = new ArrayDeque<>();

    int number = 0;
    char oper = '+';
    int n = s.length();

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);

      if (Character.isDigit(ch)) {
        number = number * 10 + Character.getNumericValue(ch);
      }

      if ((ch == '+' || ch == '-' || ch == '*' || ch == '/') || i == n - 1) {
        if (oper == '+') {
          stack.push(number);
        } else if (oper == '-') {
          stack.push(-number);
        } else if (oper == '*') {
          int a = stack.pop();
          int c = a * number;
          stack.push(c);
        } else if (oper == '/') {
          int a = stack.pop();
          int c = a / number;
          stack.push(c);
        }

        number = 0;
        oper = ch;
      }
    }

    int res = 0;
    while (!stack.isEmpty()) {
      res += stack.pop();
    }

    return res;
  }

}

package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 227. Basic Calculator II
 * algorithm: String, Stack
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class BasicCalculatorII227 {
  private static final Set<Character> opers = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

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
    if (s == null || s.length() == 0) {
      return 0;
    }

    Deque<Integer> deque = new ArrayDeque<>();

    int number = 0;
    char oper = '+';
    int n = s.length();

    for (int i = 0; i< s.length(); i++) {
      char ch = s.charAt(i);

      if (Character.isDigit(ch)) {
        number = number * 10 + Character.getNumericValue(ch);
      }

      if (opers.contains(ch) || i == n - 1) {
        if (oper == '+') {
          deque.push(number);
        } else if (oper == '-') {
          deque.push(-number);
        } else if (oper == '*') {
          int a = deque.pop();
          int c = a * number;
          deque.push(c);
        } else if (oper == '/') {
          int a = deque.pop();
          int c = a / number;
          deque.push(c);
        }

        number = 0;
        oper = ch;
      }
    }

    int res = 0;
    while (!deque.isEmpty()) {
      res += deque.pollLast();
    }

    return res;
  }

}

package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 224. Basic Calculator
 * algorithm: Math, Stack
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 7 ms, faster than 65.65% of Java online submissions
 * Memory Usage: 42.1 MB, less than 43.08% of Java online submissions
 */
public class BasicCalculator224 {

  public static void main(String[] args) {
    BasicCalculator224 problem = new BasicCalculator224();
    problem.test();
  }

  private void test() {
    System.out.println(calculate("1 + 1"));//2
    System.out.println(calculate(" 2-1 + 2 "));//3
    System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));//23
  }

  public int calculate(String s) {
    int[] pos = new int[s.length()];
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch == '(') {
        stack.push(i);
      } else if (ch == ')') {
        pos[stack.pop()] = i;
      }
    }

    return calculate(s, 0, s.length() - 1, pos);
  }

  private int calculate(String s, int l, int r, int[] pos) {
    Deque<Integer> stack = new ArrayDeque<>();

    int num = 0;
    char oper = '+';

    for (int i = l; i <= r; i++) {
      char ch = s.charAt(i);

      if (Character.isDigit(ch)) {
        num = num * 10 + (ch - '0');
      }

      if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == r || ch == ')') {
        if (oper == '+') {
          stack.push(num);
        } else if (oper == '-') {
          stack.push(-num);
        }

        if (ch != ')') {
          oper = ch;
        }

        num = 0;
      } else if (ch == '(') {
        num = calculate(s, i + 1, pos[i] - 1, pos);
        i = pos[i] - 1;
      }
    }

    int output = 0;
    while (!stack.isEmpty()) {
      output += stack.poll();
    }

    return output;
  }

}
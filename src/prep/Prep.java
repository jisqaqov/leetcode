package prep;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(calculate("3+5/2"));
  }

  public int calculate(String s) {
    Deque<Integer> stack = new ArrayDeque<>();

    char oper = '+';
    int num = 0;

    stack.push(0);

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch == '+' || ch == '-') {
        stack.push(calculate(stack, num, oper));

        num = 0;
        oper = ch;
      } else if (ch == '*' || ch == '/') {
        int val = 0;
        if (oper == '*' || oper == '/') {
          val = calculate(stack, num, oper);
        } else {
          if (oper == '-') {
            num = -num;
          }

          val = num;
        }

        stack.push(val);

        num = 0;
        oper = ch;
      } else if (ch != ' ') {
        num = num * 10 + (ch - '0');
      }
    }

    stack.push(calculate(stack, num, oper));

    int output = 0;
    while (!stack.isEmpty()) {
      output += stack.pop();
    }

    return output;
  }

  private int calculate(Deque<Integer> stack, int num, char oper) {
    int val = 0;

    switch (oper) {
      case '+':
        val = stack.pop() + num;
        break;
      case '-':
        val = stack.pop() - num;
        break;
      case '*':
        val = stack.pop() * num;
        break;
      case '/':
        val = stack.pop() / num;
        break;
    }

    return val;
  }

}
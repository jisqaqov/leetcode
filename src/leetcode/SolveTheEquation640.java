package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 640. Solve the Equation
 * algorithm: String, Math
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 2 ms, faster than 90.85% of Java online submissions
 * Memory Usage: 37.7 MB, less than 12.50% of Java online submissions
 */
public class SolveTheEquation640 {

  public static void main(String[] args) {
    SolveTheEquation640 problem = new SolveTheEquation640();
    problem.test();
  }

  private void test() {
    System.out.println(solveEquation("x+5-3+x=6+x-2"));//x = 2
    System.out.println(solveEquation("x=x"));//Infinite solutions
    System.out.println(solveEquation("2x=x"));//x=0
    System.out.println(solveEquation("2x+3x-6x=x+2"));//x=-1
    System.out.println(solveEquation("x=x+2"));//No solution
    System.out.println(solveEquation("0x=0"));//Infinite solutions
  }

  public String solveEquation(String equation) {
    int index = equation.indexOf('=');

    String p = equation.substring(0, index);
    String q = equation.substring(index + 1);

    int[] vals1 = calculate(p);
    int[] vals2 = calculate(q);

    int a = vals1[0] - vals2[0];
    int b = vals2[1] - vals1[1];

    if (a == 0 && b == 0) {
      return "Infinite solutions";
    }

    if (a == 0) {
      return "No solution";
    }

    return "x=" + (b / a);
  }

  private int[] calculate(String expression) {
    int a = 0, b = 0;

    char oper = '+';
    int num = 0;

    int n = expression.length();

    char[] chs = expression.toCharArray();

    for (int i = 0; i < n; i++) {

      if (chs[i] >= '0' && chs[i] <= '9') {
        int val = chs[i] - '0';
        num = num * 10 + val;
      }

      if (chs[i] == 'x') {
        if (i == 0 || chs[i - 1] == '+' || chs[i - 1] == '-') {
          num = 1;
        }
      }

      if (chs[i] == '+' || chs[i] == '-' || i == n - 1) {
        if (chs[i] == 'x' || (i > 0 && chs[i - 1] == 'x')) {
          if (oper == '+') {
            a += num;
          } else {
            a -= num;
          }
        } else {
          if (oper == '+') {
            b += num;
          } else {
            b -= num;
          }
        }

        num = 0;
        oper = chs[i];
      }
    }

    return new int[] {a, b};
  }

}
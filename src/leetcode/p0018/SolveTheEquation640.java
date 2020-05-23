package leetcode.p0018;

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
    char[] chs = equation.toCharArray();

    int[] vals1 = calculate(chs, 0, index - 1);
    int[] vals2 = calculate(chs, index + 1, chs.length - 1);

    int a = vals1[0] - vals2[0];
    int b = vals2[1] - vals1[1];

    if (a == 0 && b == 0) {
      return "Infinite solutions";
    }

    if (a == 0 && b != 0) {
      return "No solution";
    }

    return "x=" + (b / a);
  }

  private int[] calculate(char[] str, int start, int end) {
    int a = 0, b = 0;

    char oper = '+';
    int num = 0;

    for (int i = start; i <= end; i++) {
      if (str[i] >= '0' && str[i] <= '9') {
        num = num * 10 + str[i] - '0';
      }

      if (str[i] == 'x') {
        if (i == start || str[i - 1] == '+' || str[i - 1] == '-') {
          num = 1;
        }

        a = oper == '+'? a + num: a - num;
        num = 0;
      } else if (str[i] == '+' || str[i] == '-' || i == end) {
        if (i == start || str[i - 1] != 'x') {
          b = oper == '+'? b + num: b - num;
        }

        num = 0;
        oper = str[i];
      }
    }

    return new int[] {a, b};
  }

}
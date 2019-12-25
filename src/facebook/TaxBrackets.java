package facebook;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem:
 * Calculate tax if Salary and Tax Brackets are given as:
 * calculateTax(double salary, Double[][] brackets)
 * e.g. Salary = 35000
 * Brackets = [ [10000, 0.1],[20000, 0.2], [10000, 0.3], [null, .4]]
 * null being rest of the salary
 * algorithm: Sort
 * time complexity: O(N)
 * space complexity: O(1)
 */
public class TaxBrackets {

  public static void main(String[] args) {
    TaxBrackets problem = new TaxBrackets();
    problem.test();
  }

  private void test() {
    double[][] tc1a = new double[][]{{5070, 0.1}, {8660, 0.14}, {14070, 0.23}, {21240, 0.3}, {40230, 0.33}, {0, 0.45}};

    System.out.println(calculateTax(5000, tc1a));//500
    System.out.println(calculateTax(5800, tc1a));//609.2
    System.out.println(calculateTax(9000, tc1a));//1087.8
    System.out.println(calculateTax(15000, tc1a));//2532.9
    System.out.println(calculateTax(50000, tc1a));//15068.1
  }

  private double calculateTax(int salary, double[][] brackets) {
    double tax = 0;

    Arrays.sort(brackets, (t1, t2) -> {
      if (t1[0] == 0 || t2[0] == 0) {
        return t1[0] == 0 ? 1 : -1;
      }

      return Double.compare(t1[0], t2[0]);
    });

    double lowBound = 0;

    for (int i = 0; i < brackets.length; i++) {
      double taxable = 0;

      if (salary < brackets[i][0] || brackets[i][0] == 0) {
        taxable = salary - lowBound;
      } else {
        taxable = brackets[i][0] - lowBound;
      }

      tax += taxable * brackets[i][1];

      if (salary < brackets[i][0]) {
        break;
      }

      lowBound = brackets[i][0];
    }

    return tax;
  }

}
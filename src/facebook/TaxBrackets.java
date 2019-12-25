package facebook;

import java.util.Arrays;

public class TaxBrackets {

  public static void main(String[] args) {
    TaxBrackets problem = new TaxBrackets();
    problem.test();
  }

  private void test() {
    System.out.println(calculateTax(17000,
      new double[][]{{0, 0.1}, {10000, 0.3}, {23000, 0.2}, {31000, 0.1}}));//4400
    System.out.println(calculateTax(25000,
      new double[][]{{12000, 0.3}, {23000, 0.2}, {31000, 0.1}, {0, 0.1}}));//6000
    System.out.println(calculateTax(35000,
      new double[][]{{12000, 0.3}, {31000, 0.1}, {23000, 0.2}, {0, 0.1}}));//7000
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
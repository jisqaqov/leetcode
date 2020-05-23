package leetcode.p0006;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 166. Fraction to Recurring Decimal
 * algorithm: Math, Hash Table
 * time complexity: O(1)
 * space complexity: O(D)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 37 MB, less than 9.52% of Java online submissions
 */
public class FractionToRecurringDecimal166 {

  public static void main(String[] args) {
    FractionToRecurringDecimal166 problem = new FractionToRecurringDecimal166();
    problem.test();
  }

  private void test() {
    System.out.println(fractionToDecimal(0, 3));//0
    System.out.println(fractionToDecimal(1, 2));//0.5
    System.out.println(fractionToDecimal(2, 1));//2
    System.out.println(fractionToDecimal(2, 3));//0.(6)
    System.out.println(fractionToDecimal(4, 333));//0.(012)
    System.out.println(fractionToDecimal(1, 6));//0.1(6)
    System.out.println(fractionToDecimal(22, 7));//3.(142857)
    System.out.println(fractionToDecimal(-50, 8));//-6.25
    System.out.println(fractionToDecimal(-22, -2));//11
    System.out.println(fractionToDecimal(-1, -2147483648));//0.0000000004656612873077392578125
  }

  public String fractionToDecimal(int numerator, int denominator) {
    boolean negative = (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0);

    long p = Math.abs((long) numerator);
    long q = Math.abs((long) denominator);

    if (p == 0) {
      return "0";
    }

    StringBuilder output = new StringBuilder();

    if (negative) {
      output.append('-');
    }

    output.append(p / q);
    p %= q;

    if (p == 0) {
      return output.toString();
    }

    output.append('.');

    Map<Long, Integer> map = new HashMap<>();

    while (p != 0) {
      map.put(p, output.length());

      p *= 10;

      output.append(p / q);

      p %= q;

      if (map.containsKey(p)) {
        output.insert(map.get(p), "(");
        output.append(")");

        break;
      }
    }

    return output.toString();
  }

}
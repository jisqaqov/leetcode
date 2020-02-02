package leetcode;

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
    System.out.println(fractionToDecimal(22, 7));//30.(142857)
    System.out.println(fractionToDecimal(-50, 8));//-6.25
    System.out.println(fractionToDecimal(-22, -2));//11
    System.out.println(fractionToDecimal(-1, -2147483648));//0.0000000004656612873077392578125
  }

  public String fractionToDecimal(int num1, int num2) {
    long p = num1;
    long q = num2;

    if (p == 0) {
      return "0";
    }

    boolean negative = false;
    if ((p < 0 && q > 0) || (p > 0 && q < 0)) {
      negative = true;
    }

    p = Math.abs(p);
    q = Math.abs(q);

    Map<Long, Integer> map = new HashMap<>();

    boolean decimal = false;
    StringBuilder output = new StringBuilder();

    while (true) {
      if (p >= q) {
        long div = p / q;
        long rem = p - div * q;

        output.append(div);

        if (map.containsKey(rem)) {
          output.insert(map.get(rem), "(");
          output.append(")");

          break;
        }

        p = rem;
        map.put(rem, output.length());

        if (rem == 0) {
          break;
        }
      } else {
        if (!decimal) {
          if (output.length() == 0) {
            output.append("0.");
          } else {
            output.append(".");
          }

          map.put(p, output.length());

          decimal = true;
        }

        p *= 10;

        while (p < q) {
          p *= 10;
          output.append('0');
        }
      }
    }

    if (negative) {
      output.insert(0, '-');
    }

    return output.toString();
  }

}
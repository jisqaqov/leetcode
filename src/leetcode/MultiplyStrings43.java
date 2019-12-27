package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 43. Multiply Strings
 * algorithm: Math, String
 * time complexity: O(N*M)
 * space complexity: O(1)
 * Runtime: 4 ms, faster than 86.37% of Java online submissions
 * Memory Usage: 36 MB, less than 100.00% of Java online submissions
 */
public class MultiplyStrings43 {

  public static void main(String[] args) {
    MultiplyStrings43 problem = new MultiplyStrings43();
    problem.test();
  }

  private void test() {
    System.out.println(multiply("712", "92"));//65504
    System.out.println(multiply("2", "3"));//6
    System.out.println(multiply("123", "456"));//56088
    System.out.println(multiply("1", "12331"));//12331
    System.out.println(multiply("30259", "916875"));//27743720625
    System.out.println(multiply("9133", "0"));//0
  }

  public String multiply(String num1, String num2) {
    int n = num1.length();
    int m = num2.length();

    int[] nums = new int[n + m];

    int pos = nums.length - 1;

    for (int i = n - 1; i >= 0; i--) {
      int index = pos;

      for (int j = m - 1; j >= 0; j--) {
        int a = num1.charAt(i) - '0';
        int b = num2.charAt(j) - '0';

        int p = a * b + nums[index];

        nums[index] = p % 10;
        nums[index - 1] += p / 10;

        index--;
      }

      pos--;
    }

    StringBuilder output = new StringBuilder();

    for (int num : nums) {
      if (output.length() != 0 || num != 0) {
        output.append(num);
      }
    }

    return output.length() == 0? "0": output.toString();
  }

  private static class V2 {

    public String multiply(String num1, String num2) {
      if (num1.equals("0") || num2.equals("0")) {
        return "0";
      }

      List<Integer> list = new ArrayList<>();

      int carry = 0;
      int index = 0;

      for (int i = num1.length() - 1; i >= 0; i--) {
        int k = index;

        for (int j = num2.length() - 1; j >= 0; j--) {
          int a = Character.getNumericValue(num1.charAt(i));
          int b = Character.getNumericValue(num2.charAt(j));

          if (k >= list.size()) {
            list.add(0);
          }

          int c = a * b + carry + list.get(k);

          carry = c / 10;
          c = c % 10;

          list.set(k, c);

          k++;
        }

        if (carry > 0) {

          if (k >= list.size()) {
            list.add(0);
          }

          list.set(k, carry);

          carry = 0;
        }

        index++;
      }

      StringBuilder output = new StringBuilder();
      for (int i = list.size() - 1; i >= 0; i--) {
        output.append(list.get(i));
      }

      return output.toString();
    }
  }

}

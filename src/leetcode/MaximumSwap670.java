package leetcode;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 670. Maximum Swap
 * algorithm: Array, Math
 * time complexity: O(D^2)
 * space complexity: O(D)
 * Runtime: 1 ms, faster than 51.46% of Java online submissions
 * Memory Usage: 41.5 MB, less than 25.00% of Java online submissions
 */
public class MaximumSwap670 {

  public static void main(String[] args) {
    MaximumSwap670 problem = new MaximumSwap670();
    problem.test();
  }

  private void test() {
    System.out.println(maximumSwap(2736));//7236
    System.out.println(maximumSwap(27376));//77326
    System.out.println(maximumSwap(67376));//77366
    System.out.println(maximumSwap(98368));//98863
  }

  public int maximumSwap(int num) {
    char[] digits = String.valueOf(num).toCharArray();

    int[] index = {-1, -1};
    int maxIndex = digits.length - 1;

    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] > digits[maxIndex]) {
        maxIndex = i;
      } else if (digits[i] < digits[maxIndex]) {
        index[0] = i;
        index[1] = maxIndex;
      }
    }

    if (index[0] != -1) {
      char temp = digits[index[0]];
      digits[index[0]] = digits[index[1]];
      digits[index[1]] = temp;
    }

    return Integer.parseInt(String.valueOf(digits));
  }

  private static class V2 {
    public int maximumSwap(int num) {
      int[] digits = new int[10];

      int k = digits.length - 1;
      while (num > 0) {
        digits[k--] = num % 10;
        num /= 10;
      }

      digits = Arrays.copyOfRange(digits, k + 1, digits.length);

      for (int i = 0; i < digits.length; i++) {
        int maxIndex = i;
        for (int j = i + 1; j < digits.length; j++) {
          if (digits[j] > digits[i] && digits[j] >= digits[maxIndex]) {
            maxIndex = j;
          }
        }

        if (maxIndex > i) {
          int temp = digits[maxIndex];
          digits[maxIndex] = digits[i];
          digits[i] = temp;

          break;
        }
      }

      int output = 0;
      for (int digit : digits) {
        output = output * 10 + digit;
      }

      return output;
    }
  }

  private static class V3 {
    public int maximumSwap(int num) {
      int[] digits = new int[10];

      int k = digits.length - 1;
      while (num > 0) {
        digits[k--] = num % 10;
        num /= 10;
      }

      digits = Arrays.copyOfRange(digits, k + 1, digits.length);

      int[] p = new int[digits.length];
      p[p.length - 1] = p.length - 1;

      for (int i = p.length - 2; i >= 0; i--) {
        p[i] = i;
        if (digits[p[i]] <= digits[p[i + 1]]) {
          p[i] = p[i + 1];
        }
      }

      for (int i = 0; i < digits.length; i++) {
        if (digits[i] < digits[p[i]]) {
          int temp = digits[p[i]];
          digits[p[i]] = digits[i];
          digits[i] = temp;

          break;
        }
      }

      int output = 0;
      for (int digit : digits) {
        output = output * 10 + digit;
      }

      return output;
    }
  }

}
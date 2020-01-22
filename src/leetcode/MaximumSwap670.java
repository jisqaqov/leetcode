package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 670. Maximum Swap
 * algorithm: Array, Math
 * time complexity: O(|D^2|)
 * space complexity: O(|D|)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 39.2 MB, less than 25.00% of Java online submissions
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
    List<Integer> list = new ArrayList<>();

    while (num > 0) {
      list.add(num % 10);
      num /= 10;
    }

    int[] digits = new int[list.size()];
    for (int i = list.size() - 1; i >= 0; i--) {
      digits[list.size() - i - 1] = list.get(i);
    }

    for (int i = 0; i < digits.length; i++) {
      int maxIndex = i;
      for (int j = i + 1; j < digits.length; j++) {
        if (digits[j] > digits[i] && digits[j] >= digits[maxIndex]) {
          maxIndex = j;
        }
      }

      if (maxIndex > i) {
        swap(maxIndex, i, digits);
        break;
      }
    }

    int output = 0;
    for (int digit : digits) {
      output = output * 10 + digit;
    }

    return output;
  }

  private void swap(int i, int j, int[] a) {
    int temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }

}
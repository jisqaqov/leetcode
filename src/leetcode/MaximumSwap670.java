package leetcode;

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
    int[] digits = new int[10];

    int k = digits.length - 1;
    while (num > 0) {
      digits[k--] = num % 10;
      num /= 10;
    }

    int start = k + 1;

    for (int i = start; i < digits.length; i++) {
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
    for (int i = start; i < digits.length; i++) {
      output = output * 10 + digits[i];
    }

    return output;
  }

}
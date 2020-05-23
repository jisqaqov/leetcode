package leetcode.p0014;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 556. Next Greater Element III
 * algorithm: Array
 * time complexity: O(K)
 * space complexity: O(K)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 36.1 MB, less than 10.00% of Java online submissions
 */
public class NextGreaterElementIII556 {

  public static void main(String[] args) {
    NextGreaterElementIII556 problem = new NextGreaterElementIII556();
    problem.test();
  }

  private void test() {
    System.out.println(nextGreaterElement(1999999999));
    System.out.println(nextGreaterElement(5));
    System.out.println(nextGreaterElement(7654321));
    System.out.println(nextGreaterElement(1234567));
    System.out.println(nextGreaterElement(7459821));
  }

  public int nextGreaterElement(int n) {
    int[] digits = numberToDigits(n);

    int i = digits.length - 2;
    while (i >= 0 && digits[i] >= digits[i + 1]) {
      i--;
    }

    if (i == -1) {
      return -1;
    }

    int maxIndex = i + 1;
    for (int j = maxIndex; j < digits.length; j++) {
      if (digits[j] > digits[i] && digits[maxIndex] >= digits[j]) {
        maxIndex = j;
      }
    }

    swap(digits, maxIndex, i);

    for (int p = i + 1, q = digits.length - 1; p < q;) {
      swap(digits, p++, q--);
    }

    return digitsToNumber(digits);
  }

  private void swap(int[] vals, int i, int j) {
    int temp = vals[j];
    vals[j] = vals[i];
    vals[i] = temp;
  }

  private int digitsToNumber(int[] digits) {
    int n = 0;
    for (int digit : digits) {
      if ((Integer.MAX_VALUE - digit) / 10 < n) {
        return -1;
      }

      n = n * 10 + digit;
    }

    return n;
  }

  private int[] numberToDigits(int n) {
    List<Integer> digits = new ArrayList<>();

    while (n > 0) {
      int digit = n % 10;

      digits.add(digit);
      n /= 10;
    }

    Collections.reverse(digits);

    int[] output = new int[digits.size()];
    for (int i = 0; i < digits.size(); i++) {
      output[i] = digits.get(i);
    }

    return output;
  }

}
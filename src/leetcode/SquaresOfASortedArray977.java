package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 977. Squares of a Sorted Array
 * algorithm: Two Pointers
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 40.7 MB, less than 96.34% of Java online submissions
 */
public class SquaresOfASortedArray977 {

  public int[] sortedSquares(int[] a) {
    int n = a.length;

    int i = 0, j = n - 1;

    int[] output = new int[n];

    for (int p = n - 1; p >= 0; p--) {
      if (Math.abs(a[j]) > Math.abs(a[i])) {
        output[p] = a[j] * a[j];
        j--;
      } else {
        output[p] = a[i] * a[i];
        i++;
      }
    }

    return output;
  }

}
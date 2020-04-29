package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 1053. Previous Permutation With One Swap
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissionsx
 * Memory Usage: 40.4 MB, less than 100.00% of Java online submissionsx
 */
public class PreviousPermutationWithOneSwap1053 {

  public int[] prevPermOpt1(int[] a) {
    int i = a.length - 1;
    while (i > 0 && a[i] >= a[i - 1]) {
      i--;
    }

    if (i == 0) {
      return a;
    }

    int maxIndex = i;
    int j = i - 1;

    for (int k = i; k < a.length; k++) {
      if (a[k] < a[j] && a[k] > a[maxIndex]) {
        maxIndex = k;
      }
    }

    swap(a, j, maxIndex);

    return a;
  }

  private void swap(int[] a, int i, int j) {
    int temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }

}
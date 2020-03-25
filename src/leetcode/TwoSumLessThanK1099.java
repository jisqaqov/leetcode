package leetcode;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 1099. Two Sum Less Than K
 * algorithm: Array, Two Pointers
 * time complexity: O(nlog(n))
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 38.1 MB, less than 33.33% of Java online submissions
 */
public class TwoSumLessThanK1099 {

  public static void main(String[] args) {
    TwoSumLessThanK1099 problem = new TwoSumLessThanK1099();
    problem.test();
  }

  private void test() {
    System.out.println(twoSumLessThanK(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60));
  }

  public int twoSumLessThanK(int[] a, int k) {
    Arrays.sort(a);

    int i = 0;
    int j = a.length - 1;

    int max = -1;

    while (i < j) {
      int s = a[i] + a[j];
      if (s >= k) {
        j--;
      } else {
        max = Math.max(max, s);
        i++;
      }
    }

    return max;
  }

}
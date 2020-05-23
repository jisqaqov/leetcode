package leetcode.p0019;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 259. 3Sum Smaller
 * algorithm: Two Pointers
 * time complexity: O(N^2)
 * space complexity: O(1)
 * Runtime: 2 ms, faster than 100.00%
 * Memory Usage: 38.9 MB, less than 47.06%
 */
public class ThreeSumSmaller259 {

  public int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);

    int count = 0;

    for (int i = 0; i < nums.length - 2; i++) {
      int j = i + 1;
      int k = nums.length - 1;

      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];

        if (sum >= target) {
          k--;
        } else {
          count += k - j;
          j++;
        }
      }
    }

    return count;
  }

}
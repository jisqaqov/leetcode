package leetcode.p0019;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 16. 3Sum Closest
 * algorithm: Two Pointers
 * time complexity: O(N^2)
 * space complexity: O(1)
 * Runtime: 4 ms, faster than 79.64%
 * Memory Usage: 39.4 MB, less than 6.67%
 */
public class ThreeSumClosest16 {

  public int threeSumClosest(int[] nums, int target) {
    if (nums.length < 3) {
      return 0;
    }

    Arrays.sort(nums);

    int closest = nums[0] + nums[1] + nums[2];

    for (int i = 0; i < nums.length; i++) {
      int j = i + 1;
      int k = nums.length - 1;

      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (Math.abs(target - sum) < Math.abs(target - closest)) {
          closest = sum;
        }

        if (sum == target) {
          return sum;
        } else if (sum < target) {
          j++;
        } else {
          k--;
        }
      }
    }

    return closest;
  }

}
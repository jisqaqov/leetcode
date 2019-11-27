package leetcode;


/**
 * @author Jandos Iskakov
 * problem: 53. Maximum Subarray
 * algorithm: DP
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 83.31% of Java online submissions for Maximum Subarray.
 * Memory Usage: 37.3 MB, less than 99.53% of Java online submissions for Maximum Subarray.
 */
public class MaximumSubarray53 {

  public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int sum = nums[0];
    int max = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > sum + nums[i]) {
        sum = nums[i];
      } else {
        sum += nums[i];
      }

      max = Math.max(max, sum);
    }

    return max;
  }

}

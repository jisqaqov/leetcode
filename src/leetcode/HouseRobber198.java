package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 198. House Robber
 * algorithm: DP
 * time complexity: O(n)
 * space complexity: O(n)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 37.1 MB, less than 5.26% of Java online submissions
 */
public class HouseRobber198 {

  public static void main(String[] args) {
    HouseRobber198 solution = new HouseRobber198();
    solution.test();
  }

  public void test() {
    System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    System.out.println(rob(new int[]{1, 2, 3, 1}));
  }

  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int dp0 = 0;
    int dp1 = nums[0];

    int amount = dp1;
    for (int i = 2; i <= nums.length; i++) {
      amount = Math.max(dp1, dp0 + nums[i - 1]);

      dp0 = dp1;
      dp1 = amount;
    }

    return amount;
  }

  private static class V2 {

    public int rob(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }

      int[] dp = new int[nums.length + 1];

      dp[0] = 0;
      dp[1] = nums[0];

      for (int i = 2; i <= nums.length; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
      }

      return dp[nums.length];
    }
  }

  private static class V3 {

    public int rob(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }

      Map<Integer, Integer> memo = new HashMap<>();
      return rob(nums, nums.length - 1, memo);
    }

    public int rob(int[] nums, int n, Map<Integer, Integer> memo) {
      if (n < 0) {
        return 0;
      } else if (n == 0) {
        return nums[n];
      }

      if (memo.containsKey(n)) {
        return memo.get(n);
      }

      int max = Math.max(rob(nums, n - 1, memo), rob(nums, n - 2, memo) + nums[n]);
      memo.put(n, max);

      return max;
    }

  }

}

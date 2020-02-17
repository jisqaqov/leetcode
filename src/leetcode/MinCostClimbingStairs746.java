package leetcode;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 746. Min Cost Climbing Stairs
 * algorithm: DP
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 97.42% of Java online submissions
 * Memory Usage: 39.6 MB, less than 39.29% of Java online submissions
 */
public class MinCostClimbingStairs746 {

  public static void main(String[] args) {
    MinCostClimbingStairs746 problem = new MinCostClimbingStairs746();
    problem.test();
  }

  private void test() {
    System.out.println(new V2().minCostClimbingStairs(new int[]{10, 15, 20}));//15
    System.out.println(new V2().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));//6
  }

  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    if (n == 0) {
      return 0;
    }

    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = cost[0];

    for (int i = 2; i <= cost.length; i++) {
      dp[i] = cost[i - 1] + Math.min(dp[i - 2], dp[i - 1]);
    }

    return Math.min(dp[n - 1], dp[n]);
  }

  private static class V3 {

    public int minCostClimbingStairs(int[] cost) {
      if (cost.length == 0) {
        return 0;
      }

      int climb2 = 0;
      int climb1 = cost[0];

      for (int i = 2; i <= cost.length; i++) {
        int climb = cost[i - 1] + Math.min(climb1, climb2);
        climb2 = climb1;
        climb1 = climb;
      }

      return Math.min(climb1, climb2);
    }

  }

  private static class V2 {

    public int minCostClimbingStairs(int[] cost) {
      if (cost.length == 0) {
        return 0;
      }

      int[] dp = new int[cost.length + 2];
      Arrays.fill(dp, -1);

      return helper(cost, cost.length + 1, dp);
    }

    private int helper(int[] cost, int n, int[] dp) {
      if (n <= 0) {
        return 0;
      }

      if (dp[n] != -1) {
        return dp[n];
      }

      dp[n] = 0;
      if (n <= cost.length) {
        dp[n] = cost[n - 1];
      }

      dp[n] += Math.min(helper(cost, n - 1, dp), helper(cost, n - 2, dp));

      return dp[n];
    }

  }

}
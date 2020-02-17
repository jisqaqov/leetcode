package prep;

import java.util.Arrays;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));//15
    System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));//6
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

  private static class V2 {

    public int minCostClimbingStairs(int[] cost) {
      if (cost.length == 0) {
        return 0;
      }

      int[] dp = new int[cost.length + 1];
      Arrays.fill(dp, -1);

      dp[0] = 0;

      return helper(cost, cost.length + 1, dp);
    }

    private int helper(int[] cost, int n, int[] dp) {
      if (n <= 0) {
        return 0;
      }

      if (dp[n] != -1) {
        return dp[n];
      }

      int c = n == cost.length + 1 ? 0 : cost[n - 1];

      dp[n] = c + Math.min(helper(cost, n - 1, dp), helper(cost, n - 2, dp));

      return dp[n];
    }

  }

}
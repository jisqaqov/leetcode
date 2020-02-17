package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 746. Min Cost Climbing Stairs
 * algorithm: DP
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 97.42% of Java online submissions
 * Memory Usage: 39.1 MB, less than 62.50% of Java online submissions
 */
public class MinCostClimbingStairs746 {

  public static void main(String[] args) {
    MinCostClimbingStairs746 problem = new MinCostClimbingStairs746();
    problem.test();
  }

  private void test() {
    System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));//15
    System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));//6
  }

  public int minCostClimbingStairs(int[] cost) {
    int cost0 = cost[0];
    int cost1 = cost[1];

    for (int i = 2; i < cost.length; i++) {
      int currCost = cost[i] + Math.min(cost1, cost0);
      cost0 = cost1;
      cost1 = currCost;
    }

    return Math.min(cost1, cost0);
  }

  private static class V3 {

    public int minCostClimbingStairs(int[] cost) {
      int n = cost.length;

      int[] dp = new int[n];
      dp[0] = cost[0];
      dp[1] = cost[1];

      for (int i = 2; i < cost.length; i++) {
        dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
      }

      return Math.min(dp[n - 1], dp[n - 2]);
    }

  }

}
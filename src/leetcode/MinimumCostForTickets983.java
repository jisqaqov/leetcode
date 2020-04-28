package leetcode;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 983. Minimum Cost For Tickets
 * algorithm: DP
 * time complexity: O(365)
 * space complexity: O(365)
 * Runtime: 3 ms, faster than 17.22% of Java online submissions
 * Memory Usage: 37.3 MB, less than 21.43% of Java online submissions
 */
public class MinimumCostForTickets983 {

  public static void main(String[] args) {
    MinimumCostForTickets983 problem = new MinimumCostForTickets983();
    problem.test();
  }

  private void test() {
    System.out.println(mincostTickets(new int[] {1,4,6,7,8,20}, new int[] {2,7,15}));
  }

  public int mincostTickets(int[] days, int[] costs) {
    int[] dp = new int[366];
    Arrays.fill(dp, Integer.MAX_VALUE);

    dp[0] = 0;

    boolean[] plan = new boolean[366];
    for (int day : days) {
      plan[day] = true;
    }

    for (int i = 1; i <= 365; i++) {
      if (!plan[i]) {
        dp[i] = dp[i - 1];
      }

      dp[i] = Math.min(dp[i], dp[Math.max(0, i - 1)]  + costs[0]);
      dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)]  + costs[1]);
      dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
    }

    return dp[365];
  }

}
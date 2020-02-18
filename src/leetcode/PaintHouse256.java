package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 256. Paint House
 * algorithm: DP
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 57.74% of Java online submissions
 * Memory Usage: 39.1 MB, less than 94.12% of Java online submissions
 */
public class PaintHouse256 {

  public static void main(String[] args) {
    PaintHouse256 problem = new PaintHouse256();
    problem.test();
  }

  private void test() {
    System.out.println(
      minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));//10
    System.out.println(
      minCost(new int[][]{{5, 8, 6}, {19, 14, 13}, {7, 5, 12}, {14, 15, 17}, {3, 20, 10}}));//43
  }

  public int minCost(int[][] costs) {
    int n = costs.length;
    if (n == 0) {
      return 0;
    }

    int[][] dp = new int[n][3];

    dp[0][0] = costs[0][0];
    dp[0][1] = costs[0][1];
    dp[0][2] = costs[0][2];

    int[][] colors = {{1, 2}, {0, 2}, {0, 1}};

    for (int i = 1; i < costs.length; i++) {
      dp[i][0] = costs[i][0] + Math.min(dp[i - 1][colors[0][0]], dp[i - 1][colors[0][1]]);
      dp[i][1] = costs[i][1] + Math.min(dp[i - 1][colors[1][0]], dp[i - 1][colors[1][1]]);
      dp[i][2] = costs[i][2] + Math.min(dp[i - 1][colors[2][0]], dp[i - 1][colors[2][1]]);
    }

    return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
  }


}
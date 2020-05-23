package leetcode.p0012;

/**
 * @author Jandos Iskakov
 * problem: 329. Longest Increasing Path in a Matrix
 * algorithm: DFS, DP
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 * Runtime: 8 ms, faster than 74.17% of Java online submissions
 * Memory Usage: 42.3 MB, less than 8.16% of Java online submissions
 */
public class LongestIncreasingPathInMatrix329 {

  private static int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

  public static void main(String[] args) {
    LongestIncreasingPathInMatrix329 problem =
      new LongestIncreasingPathInMatrix329();
    problem.test();
  }

  private void test() {
    System.out.println(longestIncreasingPath(new int[][]{
      {9, 9, 4},
      {6, 6, 8},
      {2, 1, 1}
    }));//4

    System.out.println(longestIncreasingPath(new int[][]{
      {3, 4, 5},
      {3, 2, 6},
      {2, 2, 1}
    }));//4
  }

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }

    int n = matrix.length;
    int m = matrix[0].length;

    int[][] dp = new int[n][m];

    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        max = Math.max(max, dfs(matrix, dp, i, j));
      }
    }

    return max;
  }

  private int dfs(int[][] matrix, int[][] dp, int i, int j) {
    if (dp[i][j] != 0) {
      return dp[i][j];
    }

    dp[i][j] = 1;

    for (int[] dir : DIRS) {
      int x = i + dir[0];
      int y = j + dir[1];

      if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
        continue;
      }

      if (matrix[i][j] < matrix[x][y]) {
        dp[i][j] = Math.max(dp[i][j], dfs(matrix, dp, x, y) + 1);
      }
    }

    return dp[i][j];
  }

}
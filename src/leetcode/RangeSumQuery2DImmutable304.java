package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 304. Range Sum Query 2D - Immutable
 * algorithm: DP
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 * Runtime: 13 ms, faster than 99.98% of Java online submissions for Range Sum Query 2D - Immutable.
 * Memory Usage: 42.7 MB, less than 100.00% of Java online submissions for Range Sum Query 2D - Immutable.
 */
public class RangeSumQuery2DImmutable304 {

  public static void main(String[] args) {
    RangeSumQuery2DImmutable304 problem = new RangeSumQuery2DImmutable304();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{3, 0, 1, 4, 2},
      {5, 6, 3, 2, 1},
      {1, 2, 0, 1, 5},
      {4, 1, 0, 1, 7},
      {1, 0, 3, 0, 5}};

    NumMatrix numMatrix = new NumMatrix(tc1a);
    System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
    System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
  }

  class NumMatrix {

    int[][] dp;

    public NumMatrix(int[][] matrix) {
      if (matrix.length == 0 || matrix[0].length == 0) {
        return;
      }

      int n = matrix.length;
      int m = matrix[0].length;

      this.dp = new int[n + 1][m + 1];

      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
        }
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      int r1 = row1 + 1;
      int r2 = row2 + 1;
      int c1 = col1 + 1;
      int c2 = col2 + 1;

      return dp[r2][c2] - dp[r2][c1 - 1] - dp[r1 - 1][c2] + dp[r1 - 1][c1 - 1];
    }
  }

}

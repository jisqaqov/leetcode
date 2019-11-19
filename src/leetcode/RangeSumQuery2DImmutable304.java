package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 304. Range Sum Query 2D - Immutable
 * algorithm: DP
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 * Runtime: 15 ms, faster than 92.00% of Java online submissions for Range Sum Query 2D - Immutable.
 * Memory Usage: 42.3 MB, less than 100.00% of Java online submissions for Range Sum Query 2D - Immutable.
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

      this.dp = new int[n][m];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          dp[i][j] = getValue(i - 1, j, dp) + getValue(i, j - 1, dp) - getValue(i - 1, j - 1, dp)
            + matrix[i][j];
        }
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      return dp[row2][col2] - getValue(row2, col1 - 1, dp) - getValue(row1 - 1, col2, dp)
        + getValue(row1 - 1, col1 - 1, dp);
    }

    private int getValue(int i, int j, int[][] dp) {
      if (i < 0 || j < 0) {
        return 0;
      }

      return dp[i][j];
    }
  }

}

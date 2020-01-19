package leetcode;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 73. Set Matrix Zeroes
 * algorithm: Array
 * time complexity: O(N*M)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 50.1 MB, less than 7.14% of Java online submissions
 */
public class SetMatrixZeros73 {

  public static void main(String[] args) {
    SetMatrixZeros73 problem = new SetMatrixZeros73();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    setZeroes(tc1a);
    TestUtils.printArray(tc1a);

    int[][] tc2a = {{1, 1, 1}, {0, 1, 2}};
    setZeroes(tc2a);
    TestUtils.printArray(tc2a);//[[0,1,1],[0,0,0]]

    int[][] tc3a = {{1, 0}};
    setZeroes(tc3a);
    TestUtils.printArray(tc3a);//[[0],[0]]
  }

  public void setZeroes(int[][] matrix) {
    if (matrix.length == 0) {
      return;
    }

    int n = matrix.length;
    int m = matrix[0].length;

    boolean zeroCol = false;
    boolean zeroRow = false;

    for (int i = 0; i < n; i++) {
      if (matrix[i][0] == 0) {
        zeroCol = true;
      }
    }

    for (int j = 0; j < m; j++) {
      if (matrix[0][j] == 0) {
        zeroRow = true;
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (matrix[0][j] == 0 || matrix[i][0] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (zeroCol) {
      for (int i = 0; i < n; i++) {
        matrix[i][0] = 0;
      }
    }

    if (zeroRow) {
      for (int j = 0; j < m; j++) {
        matrix[0][j] = 0;
      }
    }
  }

  private static class V2 {
    public void setZeroes(int[][] matrix) {
      if (matrix.length == 0) {
        return;
      }

      int n = matrix.length;
      int m = matrix[0].length;

      boolean[] rows = new boolean[n];
      boolean[] cols = new boolean[m];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (matrix[i][j] == 0) {
            rows[i] = true;
            cols[j] = true;
          }
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (rows[i] || cols[j]) {
            matrix[i][j] = 0;
          }
        }
      }
    }
  }

}
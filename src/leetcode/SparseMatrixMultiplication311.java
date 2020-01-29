package leetcode;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 311. Sparse Matrix Multiplication
 * algorithm: Array
 * time complexity: O(N*M*P)
 * space complexity: O(N*P)
 * Runtime: 3 ms, faster than 35.54% of Java online submissions
 * Memory Usage: 41.3 MB, less than 7.14% of Java online submissions
 */
public class SparseMatrixMultiplication311 {

  public static void main(String[] args) {
    SparseMatrixMultiplication311 problem = new SparseMatrixMultiplication311();
    problem.test();
  }

  private void test() {
    TestUtils.printArray(multiply(
      new int[][]{{1, 0, 0}, {-1, 0, 3}},
      new int[][]{{7, 0, 0}, {0, 0, 0}, {0, 0, 1}}));

    TestUtils.printArray(multiply(
      new int[][]{{1, -5}},
      new int[][]{{12}, {-1}}));
  }

  public int[][] multiply(int[][] a, int[][] b) {
    int n = a.length;
    int p = b[0].length;
    int m = a[0].length;

    int[][] c = new int[n][b[0].length];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < p; j++) {
        c[i][j] = 0;
        for (int k = 0; k < m; k++) {
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }

    return c;
  }


}
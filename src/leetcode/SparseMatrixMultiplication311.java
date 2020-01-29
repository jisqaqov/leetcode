package leetcode;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 311. Sparse Matrix Multiplication
 * algorithm: Array
 * time complexity: O(N*M*P)
 * space complexity: O(N*P)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 41.9 MB, less than 7.14% of Java online submissions
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
    int[][] c = new int[a.length][b[0].length];

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        c[i][j] = 0;
        for (int k = 0; k < a[0].length; k++) {
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }

    return c;
  }

  private static class V2 {

    public int[][] multiply(int[][] a, int[][] b) {
      int[][] c = new int[a.length][b[0].length];

      for (int i = 0; i < a.length; i++) {
        for (int k = 0; k < a[0].length; k++) {
          if (a[i][k] != 0) {
            for (int j = 0; j < b[0].length; j++) {
              c[i][j] += a[i][k] * b[k][j];
            }
          }
        }
      }

      return c;
    }

  }

  private static class V3 {
    //TODO:

  }


}
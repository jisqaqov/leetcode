package leetcode;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 311. Sparse Matrix Multiplication
 * algorithm: Array
 * time complexity: O(N*M*K)
 * space complexity: O(N*K)
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
    int[][] mult = new int[a.length][b[0].length];

    for (int i = 0; i < mult.length; i++) {
      for (int j = 0; j < mult[i].length; j++) {
        int p = 0;

        for (int c = 0; c < a[i].length; c++) {
          p += a[i][c] * b[c][j];
        }

        mult[i][j] = p;
      }
    }

    return mult;
  }


}
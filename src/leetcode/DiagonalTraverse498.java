package leetcode;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 498. Diagonal Traverse
 * algorithm: Array
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 * Runtime: 2 ms, faster than 95.74% of Java online submissions
 * Memory Usage: 38.8 MB, less than 100.00% of Java online submissions
 */
public class DiagonalTraverse498 {

  public static void main(String[] args) {
    DiagonalTraverse498 problem = new DiagonalTraverse498();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };

    int[][] tc2a = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };

    System.out.println(Arrays.toString(findDiagonalOrder(tc1a)));
    System.out.println(Arrays.toString(findDiagonalOrder(tc2a)));
  }

  public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix.length == 0) {
      return new int[0];
    }

    int n = matrix.length;
    int m = matrix[0].length;

    int[] output = new int[n * m];

    int r = 0, c = 0;
    int d = 1;

    for (int i = 0; i < n * m; i++) {
      output[i] = matrix[r][c];

      r += d;
      c -= d;

      if (r >= n) {
        r = n - 1;
        c += 2;
        d = -d;
      }

      if (c >= m) {
        c = m - 1;
        r += 2;
        d = -d;
      }

      if (r < 0) {
        r = 0;
        d = -d;
      }

      if (c < 0) {
        c = 0;
        d = -d;
      }
    }

    return output;
  }



  private static class V2 {

    public int[] findDiagonalOrder(int[][] matrix) {
      if (matrix.length == 0) {
        return new int[0];
      }

      int n = matrix.length;
      int m = matrix[0].length;

      int[] output = new int[n * m];

      int i = 0, j = 0, k = 0;
      int d = -1;

      while (i < n && j < m) {
        while (i < n && j < m && i >= 0 && j >= 0) {
          output[k++] = matrix[i][j];

          i += d;
          j -= d;
        }

        i -= d;
        j += d;

        if ((i == 0 || i == n - 1) && j < m - 1) {
          j++;
        } else {
          i++;
        }

        d *= -1;
      }

      return output;
    }

  }


}
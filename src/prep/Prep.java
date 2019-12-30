package prep;

import java.util.Arrays;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };

    System.out.println(Arrays.toString(findDiagonalOrder(tc1a)));
  }

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
package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    int r = 0, c = 0;
    int d = 1;

    int k = 0;

    while (r < n && c < m) {
      int i = r;
      int j = c;

      if (c < m - 1) {
        c++;
      } else {
        r++;
      }

      d *= -1;

      List<Integer> list = new ArrayList<>();

      while (i < n && j >= 0) {
        list.add(matrix[i][j]);

        i++;
        j--;
      }

      if (d == -1) {
        Collections.reverse(list);
      }

      for (int num : list) {
        output[k++] = num;
      }
    }

    return output;
  }


}
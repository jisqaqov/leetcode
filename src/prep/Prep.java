package prep;

import java.util.ArrayList;
import java.util.List;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{12, 7, 21, 31, 11},
      {45, -2, 14, 27, 19},
      {-3, 15, 36, 71, 26},
      {4, -13, 55, 34, 15}};

    System.out.println(antiDiagonalTraverse(tc1a));

    int[][] tc2a = {{1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}};

    System.out.println(antiDiagonalTraverse(tc2a));
  }

  public List<List<Integer>> antiDiagonalTraverse(int[][] matrix) {
    List<List<Integer>> output = new ArrayList<>();

    int n = matrix.length;
    int m = matrix[0].length;

    int r = 0, c = 0;

    for (int k = 0; k < n + m - 1; k++) {
      int i = r;
      int j = c;

      List<Integer> list = new ArrayList<>();

      while (i < n && j >= 0) {
        list.add(matrix[i][j]);

        i++;
        j--;
      }

      if (k < m - 1) {
        c++;
      } else {
        r++;
      }

      output.add(list);
    }

    return output;
  }


}
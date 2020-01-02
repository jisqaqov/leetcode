package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * algorithm: Array
 * https://leetcode.com/discuss/interview-question/346342/Facebook-or-Onsite-or-Matrix-Antidiagonal-Traverse
 * Given a matrix, return all elements of the matrix in antidiagonal order as shown in the below image.
 * Example 1:
 *
 * Input:
 * [[12, 7, 21, 31, 11],
 *  [45, -2, 14, 27, 19],
 *  [-3, 15, 36, 71, 26],
 *  [4, -13, 55, 34, 15]]
 *
 * Output:
 * [
 * [12],
 * [7, 45],
 * [21, -2, -3],
 * [31, 14, 15, 4],
 * [11, 27, 36, -13],
 * [19, 71, 55],
 * [26, 34],
 * [15]
 * ]
 * Example 2:
 *
 * Input:
 * [[1, 2, 3],
 *  [4, 5, 6],
 *  [7, 8, 9]]
 *
 * Output:
 * [
 * [1],
 * [2, 4],
 * [3, 5, 7],
 * [6, 8],
 * [9]
 * ]
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 */
public class MatrixAntidiagonalTraverse {

  public static void main(String[] args) {
    MatrixAntidiagonalTraverse problem = new MatrixAntidiagonalTraverse();
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

      List<Integer> vals = new ArrayList<>();

      while (i < n && j >= 0) {
        vals.add(matrix[i][j]);

        i++;
        j--;
      }

      output.add(vals);

      if (c == m - 1) {
        r++;
      } else {
        c++;
      }
    }

    return output;
  }


}

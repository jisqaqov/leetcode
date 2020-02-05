package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 54. Spiral Matrix
 * algorithm: Array
 * time complexity: O(N*M)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 37.7 MB, less than 5.21% of Java online submissions
 */
public class SpiralOrder54 {

  public static void main(String[] args) {
    SpiralOrder54 problem = new SpiralOrder54();
    problem.test();
  }

  private void test() {
    System.out.println(spiralOrder(new int[][]{
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}}));

    System.out.println(spiralOrder(new int[][]{
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12}}));
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> output = new ArrayList<>();

    int n = matrix.length;
    if (n == 0) {
      return output;
    }

    int m = matrix[0].length;

    int cnt = n * m;
    int i = 0, j = 0;

    int k = 0;
    while (output.size() < n * m) {
      for (; output.size() < cnt && j < m - k; j++) {
        output.add(matrix[i][j]);
      }

      j--;
      i++;

      for (; output.size() < cnt && i < n - k; i++) {
        output.add(matrix[i][j]);
      }

      i--;
      j--;

      for (; output.size() < cnt && j >= k; j--) {
        output.add(matrix[i][j]);
      }

      j++;
      i--;

      k++;

      for (; output.size() < cnt && i >= k; i--) {
        output.add(matrix[i][j]);
      }

      i++;
      j++;
    }

    return output;
  }

}
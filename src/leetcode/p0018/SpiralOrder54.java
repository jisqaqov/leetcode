package leetcode.p0018;

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
      {7, 8, 9}}));//[1, 2, 3, 6, 9, 8, 7, 4, 5]

    System.out.println(spiralOrder(new int[][]{
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12}}));//[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> output = new ArrayList<>();

    if (matrix.length == 0) {
      return output;
    }

    int startRow = 0;
    int endRow = matrix.length - 1;
    int startCol = 0;
    int endCol = matrix[0].length - 1;

    while (startRow <= endRow && startCol <= endCol) {
      for (int j = startCol; j <= endCol; j++) {
        output.add(matrix[startRow][j]);
      }

      startRow++;

      for (int i = startRow; i <= endRow; i++) {
        output.add(matrix[i][endCol]);
      }

      endCol--;

      if (startRow <= endRow) {
        for (int j = endCol; j >= startCol; j--) {
          output.add(matrix[endRow][j]);
        }
      }

      endRow--;

      if (startCol <= endCol) {
        for (int i = endRow; i >= startRow; i--) {
          output.add(matrix[i][startCol]);
        }
      }

      startCol++;
    }

    return output;
  }


  private static class V2 {

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

}
package leetcode.p0017;

/**
 * @author Jandos Iskakov
 * problem: 48. Rotate Image
 * algorithm: Array
 * time complexity: O(N^2)
 * space complexity: O(N^2)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 39.3 MB, less than 5.77% of Java online submissions
 */
public class RotateImage48 {

  public void rotate(int[][] matrix) {
    int n = matrix.length;

    // transpose matrix row to column
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        swap(matrix, i, j, j, i);
      }
    }

    // reverse row values
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        swap(matrix, i, j, i, n - j - 1);
      }
    }
  }

  private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
    int temp = matrix[i1][j1];
    matrix[i1][j1] = matrix[i2][j2];
    matrix[i2][j2] = temp;
  }

}
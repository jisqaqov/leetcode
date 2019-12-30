package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 766. Toeplitz Matrix
 * algorithm: Array
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 42.9 MB, less than 87.10% of Java online submissions
 */
public class ToeplitzMatrix766 {

  public static void main(String[] args) {
    ToeplitzMatrix766 problem = new ToeplitzMatrix766();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {
      {1, 2, 3, 4},
      {5, 1, 2, 3},
      {9, 5, 1, 2}
    };

    System.out.println(isToeplitzMatrix(tc1a));
  }

  public boolean isToeplitzMatrix(int[][] matrix) {
    if (matrix.length == 0) {
      return true;
    }

    int n = matrix.length;
    int m = matrix[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i > 0 && j > 0 && matrix[i][j] != matrix[i - 1][j - 1]) {
          return false;
        }
      }
    }

    return true;
  }

}

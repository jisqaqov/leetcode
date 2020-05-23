package leetcode.p0018;

/**
 * @author Jandos Iskakov
 * problem: 240. Search a 2D Matrix II
 * algorithm: Array
 * time complexity: O(N + M)
 * space complexity: O(1)
 * Runtime: 5 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 42.7 MB, less than 100.00% of Java online submissions
 */
public class Search2DMatrixII240 {

  public static void main(String[] args) {
    Search2DMatrixII240 problem = new Search2DMatrixII240();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {
      {1, 4, 7, 11, 15},
      {2, 5, 8, 12, 19},
      {3, 6, 9, 16, 22},
      {10, 13, 14, 17, 24},
      {18, 21, 23, 26, 30}
    };

    System.out.println(searchMatrix(tc1a, 5));
    System.out.println(searchMatrix(tc1a, 20));
    System.out.println(searchMatrix(tc1a, 14));
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) {
      return false;
    }

    int n = matrix.length;
    int m = matrix[0].length;

    int i = 0, j = m - 1;

    while (i < n && j >= 0) {
      if (matrix[i][j] == target) {
        return true;
      } else if (matrix[i][j] < target) {
        i++;
      } else {
        j--;
      }
    }

    return false;
  }

}

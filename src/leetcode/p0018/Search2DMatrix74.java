package leetcode.p0018;

/**
 * @author Jandos Iskakov
 * problem: 74. Search a 2D Matrix
 * algorithm: Binary Search
 * time complexity: O(log(N*M))
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 42.3 MB, less than 6.06% of Java online submissions
 */
public class Search2DMatrix74 {

  public static void main(String[] args) {
    Search2DMatrix74 problem = new Search2DMatrix74();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{1, 3, 5, 7},
      {10, 11, 16, 20},
      {23, 30, 34, 50}};

    System.out.println(searchMatrix(tc1a, 3));
    System.out.println(searchMatrix(tc1a, 13));
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) {
      return false;
    }

    int n = matrix.length;
    int m = matrix[0].length;

    int l = 0, r = n * m - 1;

    while (l <= r) {
      int mid = l + (r - l) / 2;

      int i = mid / m;
      int j = mid % m;

      if (matrix[i][j] < target) {
        l = mid + 1;
      } else if (matrix[i][j] > target) {
        r = mid - 1;
      } else {
        return true;
      }
    }

    return false;
  }

}
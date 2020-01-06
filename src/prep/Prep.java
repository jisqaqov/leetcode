package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
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

      if (matrix[i][j] == target) {
        return true;
      } else if (matrix[i][j] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }

    return false;
  }


}
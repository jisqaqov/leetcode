package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
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
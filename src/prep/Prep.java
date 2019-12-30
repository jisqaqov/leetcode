package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
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

    for (int k = 0; k < m; k++) {
      int i = 1;
      int j = k + 1;

      while (i < n && j < m) {
        if (matrix[i][j] != matrix[i - 1][j - 1]) {
          return false;
        }

        i++;
        j++;
      }
    }

    for (int k = 1; k < n; k++) {
      int i = k + 1;
      int j = 1;

      while (i < n && j < m) {
        if (matrix[i][j] != matrix[i - 1][j - 1]) {
          return false;
        }

        i++;
        j++;
      }
    }

    return true;
  }


}
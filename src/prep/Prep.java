package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{0, 0, 0, 1},
      {0, 0, 1, 1},
      {0, 1, 1, 1},
      {0, 0, 0, 0}};

    System.out.println(leftMostIndex(tc1a));//1

    int[][] tc2a = {{0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0}};

    System.out.println(leftMostIndex(tc2a));//-1

    int[][] tc3a = {{0, 1, 1, 1},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {1, 1, 1, 1}};

    System.out.println(leftMostIndex(tc3a));//0
  }

  public int leftMostIndex(int[][] matrix) {
    int index = -1;

    int n = matrix.length;
    int m = matrix[0].length;

    int i = 0;
    int j = m - 1;

    while (i < n && j >= 0) {
      if (matrix[i][j] == 0) {
        i++;
      } else {
        index = j;
        j--;
      }
    }

    return index;
  }

  private static class V2 {

    public int leftMostIndex(int[][] matrix) {
      int index = -1;

      int n = matrix.length;
      int m = matrix[0].length;

      for (int i = 0, j = m - 1; i < n && j >= 0; ) {
        if (matrix[i][j] == 0) {
          i++;
        } else {
          index = j;
          j--;
        }
      }

      return index;
    }
  }


}
package leetcode;

public final class TestUtils {

  public static void printArray(int[][] array) {
    int n = array.length, m = array[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(array[i][j] + " ");
      }

      System.out.println();
    }
  }

}

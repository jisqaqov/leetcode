package utils;

public final class TestUtils {

  public static void printArray(int[][] array) {
    System.out.println("------------------------");

    int n = array.length, m = array[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(array[i][j] + " ");
      }

      System.out.println();
    }
  }

  public static void printArray(char[][] array) {
    System.out.println("------------------------");

    int n = array.length, m = array[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(array[i][j] + " ");
      }

      System.out.println();
    }
  }

  public static void printArray(int[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }

    System.out.println();
  }


}

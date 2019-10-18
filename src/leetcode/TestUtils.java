package leetcode;

public class TestUtils {

  public static void printArray(int[][] array) {
    for (int[] anArray : array) {
      for (int j = 0; j < anArray.length; j++) {
        System.out.print(anArray[j] + " ");
      }

      System.out.println();
    }
  }

}

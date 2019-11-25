package prep;

import java.util.Arrays;
import utils.TestUtils;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
    int[][] tc1b = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

    TestUtils.printArray(intervalIntersection(tc1a, tc1b));
  }

  public int[][] intervalIntersection(int[][] a, int[][] b) {
    int i = 0;
    int j = 0;

    int[][] list = new int[a.length + b.length][2];

    int k = 0;

    while (i < a.length && j < b.length) {
      if (isOverlaps(a[i], b[j])) {
        list[k][0] = Math.max(a[i][0], b[j][0]);
        list[k][1] = Math.min(a[i][1], b[j][1]);

        k++;
      }

      if (a[i][1] < b[j][1]) {
        i++;
      } else if (b[j][1] < a[i][1]) {
        j++;
      } else {
        i++;
        j++;
      }
    }

    return Arrays.copyOf(list, k);
  }

  private boolean isOverlaps(int[] a, int[] b) {
    return (a[0] <= b[0] && a[1] >= b[0]) ||
      (b[0] <= a[0] && b[1] >= a[0]);
  }


}

package leetcode.p0009;

import java.util.Arrays;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 986. Interval List Intersections
 * algorithm: Two Pointers
 * time complexity: O(N + M)
 * space complexity: O(N + M)
 * Runtime: 2 ms, faster than 99.77% of Java online submissions for Interval List Intersections.
 * Memory Usage: 47.8 MB, less than 21.62% of Java online submissions for Interval List Intersections.
 */
public class IntervalListIntersections986 {

  public static void main(String[] args) {
    IntervalListIntersections986 problem = new IntervalListIntersections986();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{0,2},{5,10},{13,23},{24,25}};
    int[][] tc1b = {{1,5},{8,12},{15,24},{25,26}};

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
    return (a[0] >= b[0] && a[0] <= b[1]) || (b[0] >= a[0] && b[0] <= a[1]);
  }

}

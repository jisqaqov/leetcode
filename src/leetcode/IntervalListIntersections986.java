package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 986. Interval List Intersections
 * algorithm: Two Pointers
 * time complexity: O(N + M)
 * space complexity: O(N + M)
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
    List<int[]> list = new ArrayList<>();

    int i = 0;
    int j = 0;

    while (i < a.length && j < b.length) {
      int[] intA = a[i];
      int[] intB = b[j];

      if (isOverlaps(intA, intB)) {
        list.add(new int[] {Math.max(intA[0], intB[0]),
          Math.min(intA[1], intB[1])});
      }

      if (intA[1] == intB[1]) {
        i++;
        j++;
      } else if (intA[1] < intB[1]) {
        i++;
      } else {
        j++;
      }
    }

    int[][] result = new int[list.size()][2];
    for (int t = 0; t < result.length; t++) {
      result[t] = list.get(t);
    }

    return result;
  }

  private boolean isOverlaps(int[] a, int[] b) {
    return (a[0] >= b[0] && a[0] <= b[1]) || (b[0] >= a[0] && b[0] <= a[1]);
  }

}

package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jandos Iskakov
 * problem: 56. Merge Intervals
 * algorithm: Sort, Array
 * time complexity: O(nlog(n))
 * space complexity: O(n)
 */
public class MergeIntervals56 {

  public static void main(String[] args) {
    MergeIntervals56 problem = new MergeIntervals56();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    printArray(merge(tc1a));
  }

  private void printArray(int[][] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }
  }

  public int[][] merge(int[][] intervals) {
    int n = intervals.length;
    if (n == 0) {
      return intervals;
    }

    int[][] solution = new int[n][2];

    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

    solution[0][0] = intervals[0][0];
    solution[0][1] = intervals[0][1];

    int j = 0;

    for (int i = 1; i < n; i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];

      if (start >= solution[j][0] && start <= solution[j][1]) {
        solution[j][1] = Math.max(end, solution[j][1]);
      } else {
        j++;

        solution[j][0] = start;
        solution[j][1] = end;
      }
    }

    return Arrays.copyOfRange(solution, 0, j + 1);
  }


}

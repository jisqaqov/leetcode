package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 56. Merge Intervals
 * algorithm: Sort, Array
 * time complexity: O(nlog(n))
 * space complexity: O(n)
 * Runtime: 9 ms, faster than 56.10% of Java online submissions for Merge Intervals.
 * Memory Usage: 38.8 MB, less than 91.30% of Java online submissions for Merge Intervals.
 */
public class MergeIntervals56 {

  public static void main(String[] args) {
    MergeIntervals56 problem = new MergeIntervals56();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    TestUtils.printArray(merge(tc1a));

    int[][] tc2a = {{1, 4}, {4, 5}};
    TestUtils.printArray(merge(tc2a));

    int[][] tc3a = {{1, 4}, {0, 4}};
    TestUtils.printArray(merge(tc3a));
  }

  public int[][] merge(int[][] intervals) {
    int[][] output = new int[intervals.length][2];

    if (intervals.length == 0) {
      return output;
    }

    Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

    int k = 0;
    output[0][0] = intervals[0][0];
    output[0][1] = intervals[0][1];

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= output[k][0] && intervals[i][0] <= output[k][1]) {
        output[k][1] = Math.max(output[k][1], intervals[i][1]);
      } else {
        k++;
        output[k][0] = intervals[i][0];
        output[k][1] = intervals[i][1];
      }
    }

    int len = k + 1;
    return Arrays.copyOf(output, len);
  }


}

package leetcode;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 435. Non-overlapping Intervals
 * algorithm: Greedy
 * time complexity: O(Nlog(N))
 * space complexity: O(1)
 * Runtime: 3 ms, faster than 71.74% of Java online submissions
 * Memory Usage: 48.9 MB, less than 6.25% of Java online submissions
 */
public class NonOverlappingIntervals435 {

  public static void main(String[] args) {
    NonOverlappingIntervals435 problem = new NonOverlappingIntervals435();
    problem.test();
  }

  private void test() {
    System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));//1
    System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));//2
    System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));//0
  }

  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) {
      return 0;
    }

    Arrays.sort(intervals, (i1, i2) -> i2[1] - i1[1]);

    int count = 0;
    int start = intervals[0][0];

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= start || intervals[i][1] > start) {
        start = Math.max(start, intervals[i][0]);
        count++;
      } else {
        start = intervals[i][0];
      }
    }

    return count;
  }


}
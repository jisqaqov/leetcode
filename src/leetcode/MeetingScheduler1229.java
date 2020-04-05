package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 1229. Meeting Scheduler
 * algorithm: Sort, Two Pointers
 * time complexity: O(nlog(n) + mlog(m))
 * space complexity: O(1)
 * Runtime: 27 ms, faster than 49.82% of Java online submissions
 * Memory Usage: 48.9 MB, less than 100.00% of Java online submissions
 */
public class MeetingScheduler1229 {

  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
    Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));

    int i = 0, j = 0;

    List<Integer> output = new ArrayList<>();

    while (i < slots1.length && j < slots2.length) {
      if (isOverlap(slots1[i], slots2[j])) {
        int start = Math.max(slots1[i][0], slots2[j][0]);
        int end = Math.min(slots1[i][1], slots2[j][1]);

        int len = end - start;

        if (len >= duration) {
          output.add(start);
          output.add(start + duration);

          break;
        }
      }

      if (slots1[i][1] < slots2[j][1]) {
        i++;
      } else {
        j++;
      }
    }

    return output;
  }

  private boolean isOverlap(int[] slots1, int[] slots2) {
    return (slots2[0] >= slots1[0] && slots2[0] <= slots1[1]) ||
      (slots1[0] >= slots2[0] && slots1[0] <= slots2[1]);
  }

}
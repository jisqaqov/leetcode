package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 1229. Meeting Scheduler
 * algorithm: Sort, Two Pointers
 * time complexity: O(nlog(n) + mlog(m))
 * space complexity: O(1)
 * Runtime: 38 ms, faster than 11.14% of Java online submissions
 * Memory Usage: 48.6 MB, less than 100.00% of Java online submissions
 */
public class MeetingScheduler1229 {

  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
    Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));

    int i = 0, j = 0;

    while (i < slots1.length && j < slots2.length) {
      int start = Math.max(slots1[i][0], slots2[j][0]);
      int end = Math.min(slots1[i][1], slots2[j][1]);

      if (start + duration <= end) {
        return Arrays.asList(start, start + duration);
      }

      if (slots1[i][1] < slots2[j][1]) {
        i++;
      } else {
        j++;
      }
    }

    return new ArrayList<>();
  }

  private static class V2 {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
      PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

      for (int[] slot : slots1) {
        if (slot[1] - slot[0] >= duration) {
          pq.add(slot);
        }
      }

      for (int[] slot : slots2) {
        if (slot[1] - slot[0] >= duration) {
          pq.add(slot);
        }
      }

      while (pq.size() > 1) {
        int[] prev = pq.poll();
        int[] current = pq.peek();

        if (current[0] + duration <= prev[1]) {
          return Arrays.asList(current[0], current[0] + duration);
        }
      }

      return new ArrayList<>();
    }

  }

}
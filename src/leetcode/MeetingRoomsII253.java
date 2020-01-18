package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 253. Meeting Rooms II
 * algorithm: Sort, Heap
 * time complexity: O(n*log(n))
 * space complexity: O(n)
 * Runtime: 2 ms, faster than 100.00% of Java online submissions for Meeting Rooms II.
 * Memory Usage: 37.5 MB, less than 70.51% of Java online submissions for Meeting Rooms II.
 */
public class MeetingRoomsII253 {

  public static void main(String[] args) {
    MeetingRoomsII253 solution = new MeetingRoomsII253();
    solution.test();
  }

  public void test() {
    System.out.println(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));//2
    System.out.println(minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));//1
    System.out.println(minMeetingRooms(new int[][]{{13, 15}, {1, 13}}));//1
    System.out.println(minMeetingRooms(
      new int[][]{{1293, 2986}, {848, 3846}, {4284, 5907}, {4466, 4781}, {518, 2918},
        {300, 5870}}));//4
    System.out.println(minMeetingRooms(new int[][]{{1, 5}, {8, 9}, {8, 9}}));//2
  }

  public int minMeetingRooms(int[][] intervals) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

    int max = 0;

    for (int[] interval : intervals) {
      while (!pq.isEmpty() && pq.peek() <= interval[0]) {
        pq.poll();
      }

      pq.offer(interval[1]);

      max = Math.max(pq.size(), max);
    }

    return max;
  }

  private static class V2 {
    public int minMeetingRooms(int[][] intervals) {
      int n = intervals.length;

      Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

      int[] ends = new int[n];
      for (int i = 0; i < intervals.length; i++) {
        ends[i] = intervals[i][1];
      }

      Arrays.sort(ends);

      int i = 0, j = 0;

      int max = 0;
      int rooms = 0;

      while (i < n) {
        if (ends[j] <= intervals[i][0]) {
          rooms--;
          j++;
        } else {
          rooms++;
          i++;
        }

        max = Math.max(rooms, max);
      }

      return max;
    }
  }

}

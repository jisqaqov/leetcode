package leetcode;

import java.util.Arrays;

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
    int[][] tc1intervals = {{0, 30}, {5, 10}, {15, 20}};
    int[][] tc2intervals = {{7, 10}, {2, 4}};
    int[][] tc3intervals = {{13, 15}, {1, 13}};
    int[][] tc4intervals = {{1293, 2986}, {848, 3846}, {4284, 5907}, {4466, 4781}, {518, 2918},
      {300, 5870}};
    int[][] tc5intervals = {{1, 5}, {8, 9}, {8, 9}};

    System.out.println(minMeetingRooms(tc1intervals));
    System.out.println(minMeetingRooms(tc2intervals));
    System.out.println(minMeetingRooms(tc3intervals));
    System.out.println(minMeetingRooms(tc4intervals));
    System.out.println(minMeetingRooms(tc5intervals));
  }

  public int minMeetingRooms(int[][] intervals) {
    int n = intervals.length;

    int[] starts = new int[n];
    int[] ends = new int[n];

    for (int i = 0; i < intervals.length; i++) {
      starts[i] = intervals[i][0];
      ends[i] = intervals[i][1];
    }

    Arrays.sort(starts);
    Arrays.sort(ends);

    int i = 0;
    int j = 0;

    int rooms = 0;
    int max = 0;

    while (i < n) {
      if (ends[j] <= starts[i]) {
        rooms--;
        j++;
      } else {
        rooms++;
        i++;

        max = Math.max(rooms, max);
      }
    }

    return max;
  }

  private static class V2 {

    public int minMeetingRooms(int[][] intervals) {
      int n = intervals.length;

      int[][] starts = new int[2 * n][2];

      for (int i = 0, j = 0; i < n; i++, j += 2) {
        starts[j][0] = intervals[i][0];
        starts[j][1] = 2;//start

        starts[j + 1][0] = intervals[i][1];
        starts[j + 1][1] = 1;//end
      }

      Arrays.sort(starts, (a1, a2) -> {
        if (a1[0] == a2[0]) {
          return a1[1] - a2[1];
        }

        return a1[0] - a2[0];
      });

      int rooms = 0;
      int max = 0;

      for (int i = 0; i < starts.length; i++) {
        if (starts[i][1] == 2) {
          rooms++;
          max = Math.max(rooms, max);
        } else {
          rooms--;
        }
      }

      return max;
    }
  }


}

package prep;

import java.util.Arrays;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    V2 v2 = new V2();

    int[][] tc1a = {{0, 30}, {5, 10}, {15, 20}};
    System.out.println(minMeetingRooms(tc1a));

    int[][] tc2a = {{7, 10}, {2, 4}};
    System.out.println(minMeetingRooms(tc2a));

    int[][] tc3a = {{13, 15}, {1, 13}};
    System.out.println(minMeetingRooms(tc3a));

    System.out.println("v2:");
    System.out.println(v2.minMeetingRooms(tc1a));
    System.out.println(v2.minMeetingRooms(tc2a));
    System.out.println(v2.minMeetingRooms(tc3a));
  }

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

  private static class V2 {

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

  }

}

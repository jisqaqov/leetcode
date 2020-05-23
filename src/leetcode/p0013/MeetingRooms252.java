package leetcode.p0013;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jandos Iskakov
 * problem: 252. Meeting Rooms
 * algorithm: Sort
 * time complexity: O(n*log(n))
 * space complexity: O(n)
 * Runtime: 12 ms, faster than 11.08% of Java online submissions
 * Memory Usage: 41.6 MB, less than 5.13% of Java online submissions
 */
public class MeetingRooms252 {

  public static void main(String[] args) {
    MeetingRooms252 solution = new MeetingRooms252();
    solution.test();
  }

  public void test() {
    System.out.println(canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}})); //false
    System.out.println(canAttendMeetings(new int[][]{{7, 10}, {2, 4}})); //true
    System.out.println(canAttendMeetings(new int[][]{{13, 15}, {1, 13}}));//true
  }

  public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i][1] > intervals[i + 1][0]) {
        return false;
      }
    }

    return true;
  }

}

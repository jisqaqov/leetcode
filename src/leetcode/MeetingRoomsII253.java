package leetcode;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 252. Meeting Rooms
 * algorithm: Sort
 * time complexity: O(n*log(n))
 * space complexity: O(n)
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

        System.out.println(minMeetingRooms(tc1intervals));
        System.out.println(minMeetingRooms(tc2intervals));
        System.out.println(minMeetingRooms(tc3intervals));
    }

    public int minMeetingRooms(int[][] intervals) {
        Time[] times = new Time[intervals.length * 2];

        for (int i = 0; i < intervals.length; i++) {
            times[i * 2] = new Time(intervals[i][0], 2);
            times[i * 2 + 1] = new Time(intervals[i][1], 1);
        }

        Arrays.sort(times, (t1, t2) -> t1.val == t2.val ? t1.type - t2.type : t1.val - t2.val);

        int meetings = 0;
        int max = 0;

        for (int i = 0; i < times.length; i++) {
            if (times[i].type == 2) {
                meetings++;
            } else {
                meetings--;
            }

            max = Math.max(max, meetings);
        }

        return max;
    }

    private static class Time {
        int val;
        int type;

        Time(int val, int type) {
            this.val = val;
            this.type = type;
        }
    }


}

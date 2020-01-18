package prep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    //TODO:
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



}
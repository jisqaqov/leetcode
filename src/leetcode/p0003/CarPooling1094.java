package leetcode.p0003;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 1094. Car Pooling
 * algorithm: Sort, Two Pointers
 * time complexity: O(nlog(n))
 * space complexity: O(nlog(n))
 * Runtime: 8 ms, faster than 16.76% of Java online submissions
 * Memory Usage: 42 MB, less than 100.00% of Java online submissions
 */
public class CarPooling1094 {

  public static void main(String[] args) {
    CarPooling1094 problem = new CarPooling1094();
    problem.test();
  }

  private void test() {
    System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));//false
    System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));//true
    System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3));//true
    System.out.println(carPooling(new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11));//true
    System.out.println(carPooling(new int[][]{{3, 5, 9}, {4, 2, 5},
        {3, 4, 6}, {9, 1, 4}, {5, 6, 8}, {5, 4, 6}}, 14));//true
  }

  public boolean carPooling(int[][] trips, int capacity) {
    Arrays.sort(trips, Comparator.comparingInt(t -> t[1]));
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t[2]));

    for (int[] trip : trips) {
      while (!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
        capacity += pq.poll()[0];
      }

      capacity -= trip[0];

      if (capacity < 0) {
        return false;
      }

      pq.add(trip);
    }

    return true;
  }

  private static class V2 {
    public boolean carPooling(int[][] trips, int capacity) {
      int n = trips.length;

      int[][] end = new int[n][2];

      for (int i = 0; i < n; i++) {
        end[i][0] = trips[i][2];
        end[i][1] = trips[i][0];
      }

      Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
      Arrays.sort(end, Comparator.comparingInt(a -> a[0]));

      int i = 0;
      int j = 0;

      while (i < n && j < n) {
        if (trips[i][1] < end[j][0]) {
          capacity -= trips[i][0];
          i++;
        } else {
          capacity += end[j][1];
          j++;
        }

        if (capacity < 0) {
          return false;
        }
      }

      return true;
    }
  }

}
package leetcode.p0003;

/**
 * @author Jandos Iskakov
 * problem: 1011. Capacity To Ship Packages Within D Days
 * algorithm: Binary Search
 * time complexity: O(nlog(size)), size = max(weights) - sum(weights)
 * space complexity: O(1)
 * Runtime: 8 ms, faster than 93.28% of Java online submissions
 * Memory Usage: 42.9 MB, less than 69.23% of Java online submissions
 */
public class CapacityToShipPackagesWithinDDays1011 {

  public static void main(String[] args) {
    CapacityToShipPackagesWithinDDays1011 problem = new CapacityToShipPackagesWithinDDays1011();
    problem.test();
  }

  private void test() {
    System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
  }

  public int shipWithinDays(int[] weights, int d) {
    int max = -1;
    int sum = 0;

    for (int weight : weights) {
      sum += weight;
      max = Math.max(weight, max);
    }

    int left = max;
    int right = sum;

    while (left < right) {
      int capacity = left + (right - left) / 2;

      int days = getDaysToShip(weights, capacity);
      if (days > d) {
        left = capacity + 1;
      } else {
        right = capacity;
      }
    }

    return left;
  }

  private int getDaysToShip(int[] weights, int capacity) {
    int days = 1;

    int curr = 0;
    for (int w : weights) {
      if (curr + w > capacity) {
        days++;
        curr = 0;
      }

      curr += w;
    }

    return days;
  }


}
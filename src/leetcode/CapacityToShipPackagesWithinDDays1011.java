package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 1011. Capacity To Ship Packages Within D Days
 * algorithm: Binary Search
 * time complexity: O(nlog(sum))
 * space complexity: O(nlog(sum))
 * Runtime: 14 ms, faster than 13.72% of Java online submissions
 * Memory Usage: 52.3 MB, less than 7.69% of Java online submissions
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
    int sum = 0;
    for (int weight : weights) {
      sum += weight;
    }

    int l = 1, r = sum;

    int min = 0;

    while (l <= r) {
      int capacity = l + (r - l) / 2;

      boolean canShip = canShip(weights, sum, capacity, d);
      if (canShip) {
        min = capacity;
        r = capacity - 1;
      } else {
        l = capacity + 1;
      }
    }

    return min;
  }

  private boolean canShip(int[] weights, int sum, int capacity, int d) {
    int i = 0;

    while (d > 0) {

      int k = 0;
      while (i < weights.length && k + weights[i] <= capacity) {
        sum -= weights[i];
        k += weights[i++];
      }

      d--;
    }

    return i == weights.length && d >= 0 && sum == 0;
  }


}
package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 849. Maximize Distance to Closest Person
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 2 ms, faster than 78.63% of Java online submissions
 * Memory Usage: 44 MB, less than 8.33% of Java online submissions
 */
public class MaximizeDistanceToClosestPerson849 {

  public static void main(String[] args) {
    MaximizeDistanceToClosestPerson849 problem = new MaximizeDistanceToClosestPerson849();
    problem.test();
  }

  private void test() {
    System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));//2
  }

  public int maxDistToClosest(int[] seats) {
    int last = -1;
    int dis = 0;

    for (int i = 0; i < seats.length; i++) {
      if (seats[i] == 1) {
          dis = last < 0? i: Math.max(dis, (i - last)/2);
          last = i;
      }
    }

    return Math.max(dis, seats.length - last - 1);
  }

  private static class V2 {

    public int maxDistToClosest(int[] seats) {
      int n = seats.length;

      int[] r = new int[n];
      r[n - 1] = n;

      for (int i = n - 1; i >= 0; i--) {
        if (seats[i] == 1) {
          r[i] = 0;
        } else if (i < n - 1) {
          r[i] = r[i + 1] + 1;
        }
      }

      int l = n;
      int dis = 0;

      for (int i = 0; i < n; i++) {
        l = seats[i] == 1? 0: l + 1;
        dis = Math.max(dis, Math.min(l, r[i]));
      }

      return dis;
    }

  }

}
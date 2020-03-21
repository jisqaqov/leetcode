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
    int p = -1;
    int dis = 0;

    for (int i = 0; i < seats.length; i++) {
      if (seats[i] == 1) {
        if (p == -1) {
          dis = Math.max(dis, i);
        } else {
          dis = Math.max(dis, Math.max((i - p) / 2, 1));
        }

        p = i;
      } else if (i == seats.length - 1) {
        if (seats[i] == 0) {
          dis = Math.max(dis, i - p);
        }
      }
    }

    return dis;
  }

  private static class V2 {

    public int maxDistToClosest(int[] seats) {
      int p = -1;
      int dis = 0;

      for (int i = 0; i < seats.length; i++) {
        if (seats[i] == 0) {
          continue;
        }

        if (p == -1) {
          dis = Math.max(dis, i);
        }

        int k = i - p;
        dis = Math.max(dis, Math.max(k / 2, 1));

        p = i;
      }

      return dis;
    }

  }

}
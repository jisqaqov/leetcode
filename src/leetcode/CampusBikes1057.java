package leetcode;

import java.util.Arrays;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 1057. Campus Bikes
 * algorithm: Graph, Topological Sort
 * time complexity: O(nmlog(nm))
 * space complexity: O(1)
 * Runtime: 803 ms, faster than 26.06% of Java online submissions
 * Memory Usage: 140.9 MB, less than 100.00% of Java online submissions
 */
public class CampusBikes1057 {

  public static void main(String[] args) {
    CampusBikes1057 problem = new CampusBikes1057();
    problem.test();
  }

  private void test() {
    // [0, 2, 1]
    TestUtils.printArray(
      assignBikes(new int[][]{{0, 0}, {1, 1}, {2, 0}}, new int[][]{{1, 0}, {2, 2}, {2, 1}}));
  }

  public int[] assignBikes(int[][] workers, int[][] bikes) {
    int n = workers.length;
    int m = bikes.length;

    int k = 0;
    int[][] pairs = new int[n * m][3];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int dis = Math.abs(workers[i][0] - bikes[j][0]) +
          Math.abs(workers[i][1] - bikes[j][1]);

        pairs[k++] = new int[]{i, j, dis};
      }
    }

    Arrays.sort(pairs, (p1, p2) -> {
      if (p1[2] != p2[2]) {
        return Integer.compare(p1[2], p2[2]);
      }

      if (p1[0] != p2[0]) {
        return Integer.compare(p1[0], p2[0]);
      }

      return Integer.compare(p1[1], p2[1]);
    });

    int[] output = new int[n];

    boolean[] usedWorkers = new boolean[n];
    boolean[] usedBikes = new boolean[m];

    for (int i = 0; i < pairs.length; i++) {
      int worker = pairs[i][0];
      int bike = pairs[i][1];

      if (!usedWorkers[worker] && !usedBikes[bike]) {
        output[worker] = bike;

        usedWorkers[worker] = true;
        usedBikes[bike] = true;
      }
    }

    return output;
  }

}
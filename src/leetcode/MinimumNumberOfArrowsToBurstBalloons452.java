package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jandos Iskakov
 * problem: 452. Minimum Number of Arrows to Burst Balloons
 * algorithm: Greedy, Sort
 * time complexity: O(Nlog(N))
 * space complexity: O(1)
 * Runtime: 32 ms, faster than 10.25% of Java online submissions
 * Memory Usage: 58.2 MB, less than 14.29% of Java online submissions
 */
public class MinimumNumberOfArrowsToBurstBalloons452 {

  public static void main(String[] args) {
    MinimumNumberOfArrowsToBurstBalloons452 problem =
      new MinimumNumberOfArrowsToBurstBalloons452();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
    System.out.println(findMinArrowShots(tc1a));//2
  }

  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) {
      return 0;
    }

    Arrays.sort(points, Comparator.comparingInt(p -> p[1]));

    int end = points[0][1];
    int arrows = 1;

    for (int i = 1; i < points.length; i++) {
      if (points[i][0] > end) {
        arrows++;
        end = points[i][1];
      }
    }

    return arrows;
  }


}
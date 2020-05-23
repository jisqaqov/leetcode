package leetcode.p0017;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 994. Rotting Oranges
 * algorithm: BFS
 * time complexity: O(n*m)
 * space complexity: O(n*m)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 39.1 MB, less than 81.25% of Java online submissions
 */
public class RottingOranges994 {

  private static int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) {
    RottingOranges994 solution = new RottingOranges994();
    solution.test();
  }

  public void test() {
    System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
    System.out.println(orangesRotting(new int[][]{{0, 2}}));
  }

  public int orangesRotting(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();

    int freshes = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 2) {
          queue.add(new int[]{i, j});
        } else if (grid[i][j] == 1) {
          freshes++;
        }
      }
    }

    if (freshes == 0) {
      return 0;
    }

    for (int mins = 1; !queue.isEmpty(); mins++) {
      for (int s = queue.size(); s > 0; s--) {
        int[] node = queue.poll();

        for (int[] dir : DIRS) {
          int i = dir[0] + node[0];
          int j = dir[1] + node[1];

          if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 1) {
            continue;
          }

          freshes--;

          if (freshes == 0) {
            return mins;
          }

          grid[i][j] = 2;
          queue.add(new int[]{i, j});
        }
      }
    }

    return -1;
  }

}

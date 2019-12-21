package amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * Given a 2D grid, each cell is either a zombie 1 or a human 0.
 * Zombies can turn adjacent (up/down/left/right) human beings into
 * zombies every hour. Find out how many hours does it take to infect all humans?
 *
 * Example:
 *
 * Input:
 * [[0, 1, 1, 0, 1],
 *  [0, 1, 0, 1, 0],
 *  [0, 0, 0, 0, 1],
 *  [0, 1, 0, 0, 0]]
 *
 * Output: 2
 *
 * Explanation:
 * At the end of the 1st hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 *  [1, 1, 1, 1, 1],
 *  [0, 1, 0, 1, 1],
 *  [1, 1, 1, 0, 1]]
 *
 * At the end of the 2nd hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 *  [1, 1, 1, 1, 1],
 *  [1, 1, 1, 1, 1],
 *  [1, 1, 1, 1, 1]]
 *
 *
 * algorithm: BFS
 * time complexity: O(n*m)
 * space complexity: O(n*m)
 */
public class ZombieInMatrix {

  private static int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) {
    ZombieInMatrix solution = new ZombieInMatrix();
    solution.test();
  }

  public void test() {
    System.out.println(minHours(
      new int[][]{{0, 1, 1, 0, 1},
        {0, 1, 0, 1, 0},
        {0, 0, 0, 0, 1},
        {0, 1, 0, 0, 0}}));//2
  }

  public int minHours(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();

    int humans = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          queue.add(new int[]{i, j});
        } else if (grid[i][j] == 0) {
          humans++;
        }
      }
    }

    if (humans == 0) {
      return 0;
    }

    for (int hours = 1; !queue.isEmpty(); hours++) {
      for (int k = queue.size(); k > 0; k--) {
        int[] node = queue.poll();

        for (int[] dir : DIRS) {
          int i = dir[0] + node[0];
          int j = dir[1] + node[1];

          if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 0) {
            continue;
          }

          humans--;
          if (humans == 0) {
            return hours;
          }

          grid[i][j] = 1;
          queue.add(new int[]{i, j});
        }
      }
    }

    return -1;
  }

}

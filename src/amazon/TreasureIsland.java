package amazon;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 *
 * problem: You have a map that marks the location of a treasure island. Some of the map area has
 * jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers
 * trying to find the treasure. So you must figure out a shortest route to the treasure island.
 *
 * Assume the map area is a two dimensional grid, represented by a matrix of characters. You must
 * start from the top-left corner of the map and can move one block up, down, left or right at a
 * time. The treasure island is marked as X in a block of the matrix. X will not be at the top-left
 * corner. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous
 * blocks. You cannot leave the map area. Other areas O are safe to sail in. The top-left corner is
 * always safe. Output the minimum number of steps to get to the treasure.
 *
 * Example:
 *
 * Input: [['O', 'O', 'O', 'O'], ['D', 'O', 'D', 'O'], ['O', 'O', 'O', 'O'], ['X', 'D', 'D', 'O']]
 *
 * Output: 5 Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route
 * takes 5 steps.
 *
 *
 * algorithm: BFS
 *
 * time complexity: O(n*m)
 *
 * space complexity: O(n*m)
 */
public class TreasureIsland {

  private static int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

  public static void main(String[] args) {
    TreasureIsland problem = new TreasureIsland();
    problem.test();
  }

  private void test() {
    char[][] tc1a = {{'O', 'O', 'O', 'O'},
      {'D', 'O', 'D', 'O'},
      {'O', 'O', 'O', 'O'},
      {'X', 'D', 'D', 'O'}};

    System.out.println(minNumberSteps(tc1a));
    System.out.println("v2: " + new V2().minNumberSteps(tc1a));
  }

  public int minNumberSteps(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{0, 0});

    boolean[][] visited = new boolean[n][m];
    visited[0][0] = true;

    for (int steps = 0; !queue.isEmpty(); steps++) {
      int size = queue.size();

      for (int k = 0; k < size; k++) {
        int[] node = queue.poll();

        for (int[] dir : DIRS) {
          int i = dir[0] + node[0];
          int j = dir[1] + node[1];

          if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 'D' || visited[i][j]) {
            continue;
          }

          if (grid[i][j] == 'X') {
            return steps + 1;
          }

          visited[i][j] = true;
          queue.add(new int[]{i, j});
        }
      }
    }

    return 0;
  }

  private static class V2 {

    public int minNumberSteps(char[][] grid) {
      int n = grid.length;
      int m = grid[0].length;

      Queue<int[]> queue = new ArrayDeque<>();
      queue.add(new int[]{0, 0});

      boolean[][] visited = new boolean[n][m];
      visited[0][0] = true;

      int[][] dis = new int[n][m];

      while (!queue.isEmpty()) {
        int[] node = queue.poll();

        if (grid[node[0]][node[1]] == 'X') {
          return dis[node[0]][node[1]];
        }

        for (int[] dir : DIRS) {
          int i = dir[0] + node[0];
          int j = dir[1] + node[1];

          if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 'D' || visited[i][j]) {
            continue;
          }

          visited[i][j] = true;
          queue.add(new int[]{i, j});
          dis[i][j] = dis[node[0]][node[1]] + 1;
        }
      }

      return 0;
    }
  }

}

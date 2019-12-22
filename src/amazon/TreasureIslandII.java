package amazon;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 *
 * You have a map that marks the locations of treasure islands. Some of the map area has jagged
 * rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers trying to
 * find the treasure. So you must figure out a shortest route to one of the treasure islands.
 *
 * Assume the map area is a two dimensional grid, represented by a matrix of characters. You must
 * start from one of the starting point (marked as S) of the map and can move one block up, down,
 * left or right at a time. The treasure island is marked as X. Any block with dangerous rocks or
 * reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area.
 * Other areas O are safe to sail in. Output the minimum number of steps to get to any of the
 * treasure islands.
 *
 * Example:
 *
 * Input:
 * [['S', 'O', 'O', 'S', 'S'],
 *  ['D', 'O', 'D', 'O', 'D'],
 *  ['O', 'O', 'O', 'O', 'X'],
 *  ['X', 'D', 'D', 'O', 'O'],
 *  ['X', 'D', 'D', 'D', 'O']]
 *
 * Output: 3
 * Explanation:
 * You can start from (0,0), (0, 3) or (0, 4).
 * The treasure locations are (2, 4) (3, 0) and (4, 0).
 * Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).
 *
 * algorithm: BFS
 * time complexity: O(n*m)
 * space complexity: O(n*m)
 */
public class TreasureIslandII {

  private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) {
    TreasureIslandII problem = new TreasureIslandII();
    problem.test();
  }

  private void test() {
    char[][] tc1a = {{'S', 'O', 'O', 'S', 'S'},
      {'D', 'O', 'D', 'O', 'D'},
      {'O', 'O', 'O', 'O', 'X'},
      {'X', 'D', 'D', 'O', 'O'},
      {'X', 'D', 'D', 'D', 'O'}};

    System.out.println(minSteps(tc1a));
  }

  public int minSteps(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    Queue<int[]> queue = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 'X') {
          queue.add(new int[]{i, j});
        }
      }
    }

    boolean[][] visited = new boolean[n][m];

    for (int steps = 1; !queue.isEmpty(); steps++) {
      for (int sz = queue.size(); sz > 0; sz--) {
        int[] node = queue.poll();

        for (int[] dir : DIRS) {
          int i = node[0] + dir[0];
          int j = node[1] + dir[1];

          if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 'D' || visited[i][j]) {
            continue;
          }

          if (grid[i][j] == 'S') {
            return steps;
          }

          visited[i][j] = true;
          queue.add(new int[]{i, j});
        }
      }
    }

    return -1;
  }


}

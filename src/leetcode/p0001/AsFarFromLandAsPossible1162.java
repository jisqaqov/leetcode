package leetcode.p0001;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 1162. As Far from Land as Possible
 * algorithm: BFS, Graph
 * time complexity: O(N^2)
 * space complexity: O(N^2)
 */
public class AsFarFromLandAsPossible1162 {

  private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public int maxDistance(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          queue.add(new int[] {i, j});
        }
      }
    }

    if (queue.size() == n * n || queue.isEmpty()) {
      return -1;
    }

    boolean[][] visited = new boolean[n][m];

    int dis = -1;
    while (!queue.isEmpty()) {
      int size = queue.size();

      dis++;

      for (int i = 0; i < size; i++) {
        int[] node = queue.poll();

        for (int[] dir : DIRS) {
          int x2 = node[0] + dir[0];
          int y2 = node[1] + dir[1];

          if (x2 >= 0 && y2 >= 0 && x2 < n && y2 < m && grid[x2][y2] == 0 && !visited[x2][y2]) {
            visited[x2][y2] = true;
            queue.add(new int[] {x2, y2});
          }
        }
      }
    }

    return dis;
  }

}
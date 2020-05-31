package leetcode.p0014;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 1020. Number of Enclaves
 * algorithm: DFS, BFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 9 ms, faster than 21.78%
 * Memory Usage: 47.2 MB, less than 71.43%
 */
public class NumberOfEnclaves1020 {

  private static final int[] DIRS = {0, 1, 0, -1, 0};

  public int numEnclaves(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    boolean[][] used = new boolean[n][m];

    Queue<int[]> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1 && !used[i][j] && (i == 0 || j == 0 || i == n - 1 || j == m - 1)) {
          used[i][j] = true;
          queue.add(new int[] {i, j});
        }
      }
    }

    while (!queue.isEmpty()) {
      int[] node = queue.poll();

      for (int i = 0; i < DIRS.length - 1; i++) {
        int r2 = node[0] + DIRS[i];
        int c2 = node[1] + DIRS[i + 1];

        if (r2 >= 0 && c2 >= 0 && r2 < n && c2 < m && grid[r2][c2] == 1 && !used[r2][c2]) {
          used[r2][c2] = true;
          queue.add(new int[] {r2, c2});
        }
      }
    }

    int count = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1 && !used[i][j]) {
          count++;
        }
      }
    }

    return count;
  }

  private class DfsVersion {
    
    public int numEnclaves(int[][] grid) {
      if (grid.length == 0) {
        return 0;
      }

      int n = grid.length;
      int m = grid[0].length;

      boolean[][] used = new boolean[n][m];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 1 && (i == 0 || j == 0 || i == n - 1 || j == m - 1)) {
            dfs(i, j, grid, used);
          }
        }
      }

      int count = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 1 && !used[i][j]) {
            count++;
          }
        }
      }

      return count;
    }

    private void dfs(int r, int c, int[][] grid, boolean[][] used) {
      int n = grid.length;
      int m = grid[0].length;

      if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == 0 || used[r][c]) {
        return;
      }

      used[r][c] = true;

      dfs(r - 1, c, grid, used);
      dfs(r + 1, c, grid, used);
      dfs(r, c - 1, grid, used);
      dfs(r, c + 1, grid, used);
    }

  }

}
package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 200. Number of Islands
 * algorithm: DFS
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Number of Islands.
 * Memory Usage: 41.3 MB, less than 58.14% of Java online submissions for Number of Islands.
 */
public class NumberOfIslands200 {

  public static void main(String[] args) {
    NumberOfIslands200 solution = new NumberOfIslands200();
    solution.test();
  }

  public void test() {
    char[][] tc1grid = {{'1', '1', '1', '1', '0'},
      {'1', '1', '0', '1', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '0', '1', '0'}};

    System.out.println(numIslands(tc1grid));
  }

  public int numIslands(char[][] grid) {
    if (grid.length == 0) {
      return 0;
    }

    int n = grid.length, m = grid[0].length;

    boolean[][] visited = new boolean[n][m];

    int islands = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (visited[i][j] || grid[i][j] == '0') {
          continue;
        }

        dfs(visited, grid, i, j);
        islands++;
      }
    }

    return islands;
  }

  private void dfs(boolean[][] visited, char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0'
      || visited[i][j]) {
      return;
    }

    visited[i][j] = true;

    dfs(visited, grid, i - 1, j);
    dfs(visited, grid, i + 1, j);
    dfs(visited, grid, i, j - 1);
    dfs(visited, grid, i, j + 1);
  }

  /**
   * Given M x N ocean (matrix), returnan array of areas of islands surrounded by water.
   * Variation: An island is considered to be connected in all 8 directions
   * (top, bottom, left, right, top-left, top-right, bottom-left, bottom-right)
   * 1 1 0 0 1
   * 0 1 0 1 1
   * 1 0 0 1 1
   * 1 0 0 0 0
   * int[] findAreaOfIslands(int[][] ocean) should return int array [5, 5]
   */
  private static class FacebookInterview {
    public int[] findAreaOfIslands(int[][] ocean) {
      boolean[][] visited = new boolean[ocean.length][ocean[0].length];
      Set<Integer> islands = new HashSet<>();

      for (int i = 0; i < ocean.length; i++) {
        for (int j = 0; j < ocean[i].length; j++) {
          if (visited[i][j] || ocean[i][j] == 0) {
            continue;
          }
          
          islands.add(getAreaOfIsland(i, j, ocean));
        }
      }
    }

    private int getAreaOfIsland(int i, int j, int[][] ocean) {

    }
  }

}

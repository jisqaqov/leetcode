package leetcode.p0014;

import java.util.Arrays;
import utils.TestUtils;

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

    solution.interview();
  }

  public void test() {
    char[][] tc1grid = {{'1', '1', '1', '1', '0'},
      {'1', '1', '0', '1', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '0', '1', '0'}};

    System.out.println(numIslands(tc1grid));
  }

  public void interview() {
    System.out.println("facebook interview:");

    FacebookInterview interview = new FacebookInterview();

    int[][] tc1a = {{1, 1, 0, 0, 1},
      { 0, 1, 0, 1, 1},
      { 1, 0, 0, 1, 1},
        { 1, 0, 0, 0, 0}};

    TestUtils.printArray(interview.findAreaOfIslands(tc1a));
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
   * Given M x N ocean (matrix), return an array of areas of islands surrounded by water.
   * Variation: An island is considered to be connected in all 8 directions
   * (top, bottom, left, right, top-left, top-right, bottom-left, bottom-right)
   * 1 1 0 0 1
   * 0 1 0 1 1
   * 1 0 0 1 1
   * 1 0 0 0 0
   * int[] findAreaOfIslands(int[][] ocean) should return int array [5, 5]
   */
  private static class FacebookInterview {
    private int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1},
      {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public int[] findAreaOfIslands(int[][] ocean) {
      boolean[][] visited = new boolean[ocean.length][ocean[0].length];
      int[] islands = new int[ocean.length * ocean[0].length];

      int k = 0;

      for (int i = 0; i < ocean.length; i++) {
        for (int j = 0; j < ocean[i].length; j++) {
          if (visited[i][j] || ocean[i][j] == 0) {
            continue;
          }

          islands[k++] = getAreaOfIsland(i, j, ocean, visited);
        }
      }

      return Arrays.copyOf(islands, k);
    }

    private int getAreaOfIsland(int i, int j, int[][] ocean, boolean[][] visited) {
      if (i < 0 || j < 0 || i >= ocean.length || j >= ocean[0].length ||
        ocean[i][j] == 0 || visited[i][j]) {
        return 0;
      }

      visited[i][j] = true;

      int area = 1;
      for (int[] dir :  DIRS) {
        area += getAreaOfIsland(i + dir[0], j + dir[1], ocean, visited);
      }

      return area;
    }
  }

}

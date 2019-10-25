package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 695. Max Area of Island
 * algorithm: DFS
 * time complexity: O(n*m)
 * space complexity: O(n*m)
 * Runtime: 3 ms, faster than 52.43% of Java online submissions for Max Area of Island.
 * Memory Usage: 39.5 MB, less than 96.30% of Java online submissions for Max Area of Island.
 */
public class MaxAreaOfIsland695 {

  public static void main(String[] args) {
    MaxAreaOfIsland695 solution = new MaxAreaOfIsland695();
    solution.test();
  }

  public void test() {
    int[][] tc1grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

    System.out.println(maxAreaOfIsland(tc1grid));
  }

  public int maxAreaOfIsland(int[][] grid) {
    if (grid.length == 0) {
      return 0;
    }

    int n = grid.length;
    int m = grid[0].length;

    boolean[][] visited = new boolean[n][m];

    int max = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && grid[i][j] == 1) {
          int area = calcArea(visited, grid, i, j);
          max = Math.max(area, max);
        }
      }
    }

    return max;
  }

  private int calcArea(boolean[][] visited, int[][] grid, int i, int j) {
    int n = grid.length;
    int m = grid[0].length;

    if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || grid[i][j] == 0) {
      return 0;
    }

    visited[i][j] = true;

    return 1 + calcArea(visited, grid, i - 1, j) +
      calcArea(visited, grid, i + 1, j) +
      calcArea(visited, grid, i, j - 1) +
      calcArea(visited, grid, i, j + 1);
  }

}

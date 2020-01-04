package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 490. The Maze
 * algorithm: DFS
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 * Runtime: 2 ms, faster than 96.64% of Java online submissions
 * Memory Usage: 45.9 MB, less than 91.67% of Java online submissions
 */
public class TheMaze490 {

  public static void main(String[] args) {
    TheMaze490 problem = new TheMaze490();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {
      {0, 0, 1, 0, 0},
      {0, 0, 0, 0, 0},
      {0, 0, 0, 1, 0},
      {1, 1, 0, 1, 1},
      {0, 0, 0, 0, 0}};

    System.out.println(hasPath(tc1a, new int[]{0, 4}, new int[]{4, 4}));
    System.out.println(hasPath(tc1a, new int[]{0, 4}, new int[]{3, 2}));
    System.out.println(hasPath(tc1a, new int[]{0, 4}, new int[]{1, 2}));
  }

  public boolean hasPath(int[][] maze, int[] start, int[] dst) {
    boolean[][] visited = new boolean[maze.length][maze[0].length];

    return hasPath(start[0], start[1], 0, 0, maze, dst, visited);
  }

  private boolean hasPath(int row, int col, int dirRow, int dirCol,
    int[][] grid, int[] dst, boolean[][] visited) {

    int n = grid.length;
    int m = grid[0].length;

    if (row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == 1) {
      return false;
    }

    if (dirCol != dirRow) {
      while (row >= 0 && col >= 0 && row < n && col < m && grid[row][col] == 0) {
        row += dirRow;
        col += dirCol;
      }

      row -= dirRow;
      col -= dirCol;
    }

    if (visited[row][col]) {
      return false;
    }

    if (dst[0] == row && dst[1] == col) {
      return true;
    }

    visited[row][col] = true;

    return hasPath(row, col, -1, 0, grid, dst, visited) ||
      hasPath(row, col, 1, 0, grid, dst, visited) ||
      hasPath(row, col, 0, -1, grid, dst, visited) ||
      hasPath(row, col, 0, 1, grid, dst, visited);
  }

}

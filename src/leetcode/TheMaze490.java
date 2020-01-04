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
  private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

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

  public boolean hasPath(int[][] maze, int[] start, int[] dest) {
    boolean[][] visited = new boolean[maze.length][maze[0].length];

    return hasPath(start, maze, dest, visited);
  }

  private boolean hasPath(int[] start, int[][] grid, int[] dest, boolean[][] visited) {
    int n = grid.length;
    int m = grid[0].length;

    if (visited[start[0]][start[1]]) {
      return false;
    }

    if (start[0] == dest[0] && start[1] == dest[1]) {
      return true;
    }

    visited[start[0]][start[1]] = true;

    for (int[] dir : DIRS) {
      int i = start[0], j = start[1];

      while (i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == 0) {
        i += dir[0];
        j += dir[1];
      }

      int[] adj = {i - dir[0], j - dir[1]};

      if (hasPath(adj, grid, dest, visited)) {
        return true;
      }
    }

    return false;
  }

}

package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 1219. Path with Maximum Gold
 * algorithm: Backtraking
 * time complexity: O(N^2*M^2)
 * space complexity: O(N*M)
 * Runtime: 21 ms, faster than 53.44% of Java online submissions
 * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions.
 */
public class PathWithMaximumGold1219 {

  private static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public static void main(String[] args) {
    PathWithMaximumGold1219 problem = new PathWithMaximumGold1219();
    problem.test();
  }

  private void test() {
    System.out.println(getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));//24
    System.out.println(
      getMaximumGold(new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}}));//28
  }

  public int getMaximumGold(int[][] grid) {
    if (grid.length == 0) {
      return 0;
    }

    int max = 0;

    boolean[][] visited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] > 0) {
          int temp = helper(grid, visited, i, j);
          max = Math.max(max, temp);
        }
      }
    }

    return max;
  }

  private int helper(int[][] grid, boolean[][] visited, int r, int c) {
    visited[r][c] = true;

    int max = 0;

    for (int[] dir : DIRS) {
      int r2 = r + dir[0];
      int c2 = c + dir[1];

      if (r2 < 0 || c2 < 0 || r2 >= grid.length || c2 >= grid[r2].length || grid[r2][c2] == 0
        || visited[r2][c2]) {
        continue;
      }

      int temp = helper(grid, visited, r2, c2);
      max = Math.max(max, temp);
    }

    visited[r][c] = false;

    return max + grid[r][c];
  }

}
package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 980. Unique Paths III
 * algorithm: Backtracking
 * time complexity: O(N*M^(N*M))
 * space complexity: O(N*M)
 * Runtime: 1 ms, faster than 79.16% of Java online submissions for Unique Paths III.
 * Memory Usage: 34.1 MB, less than 100.00% of Java online submissions for Unique Paths III.
 */
public class UniquePathsIII980 {

  public static void main(String[] args) {
    UniquePathsIII980 problem = new UniquePathsIII980();
    problem.test();
  }

  private void test() {
    int[][] tc1grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
    int[][] tc2grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
    int[][] tc3grid = {{0,0,0,0,0,0,2,0,0,0},{0,0,0,0,0,0,0,0,1,0}};

    System.out.println(uniquePathsIII(tc1grid));
    System.out.println(uniquePathsIII(tc2grid));
    System.out.println(uniquePathsIII(tc3grid));
  }

  public int uniquePathsIII(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    int[] coords = new int[2];

    int squares = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          coords[0] = i;
          coords[1] = j;
        } else if (grid[i][j] == 0) {
          squares++;
        }
      }
    }

    boolean[][] used = new boolean[n][m];

    return count(grid, coords[0], coords[1], squares, used);
  }

  private int count(int[][] grid, int i, int j, int k, boolean[][] used) {
    int n = grid.length;
    int m = grid[0].length;

    if (i < 0 || j < 0 || i >= n || j >= m) {
      return 0;
    }

    if (used[i][j] || grid[i][j] == -1) {
      return 0;
    }

    if (grid[i][j] == 2 && k == -1) {
      return 1;
    } else if (grid[i][j] == 2 && k >= 0) {
      return 0;
    }

    used[i][j] = true;

    int count = count(grid, i - 1, j, k - 1, used) +
      count(grid, i + 1, j, k - 1, used) +
      count(grid, i, j - 1, k - 1, used) +
      count(grid, i, j + 1, k - 1, used);

    used[i][j] = false;

    return count;
  }

}

package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 361. Bomb Enemy
 * algorithm: DP
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 * Runtime: 7 ms, faster than 38.47% of Java online submissions
 * Memory Usage: 46 MB, less than 14.29% of Java online submissions
 */
public class BombEnemy361 {

  public int maxKilledEnemies(char[][] grid) {
    if (grid.length == 0) {
      return 0;
    }

    int n = grid.length;
    int m = grid[0].length;

    int[][] dp = new int[n][m];

    int counter = 0;

    for (int i = 0; i < n; i++) {
      counter = 0;
      for (int j = 0; j < m; j++) {
        counter = incKills(grid, i, j, dp, counter);
      }

      counter = 0;
      for (int j = m - 1; j >= 0; j--) {
        counter = incKills(grid, i, j, dp, counter);
      }
    }

    for (int j = 0; j < m; j++) {
      counter = 0;
      for (int i = 0; i < n; i++) {
        counter = incKills(grid, i, j, dp, counter);
      }

      counter = 0;
      for (int i = n - 1; i >= 0; i--) {
        counter = incKills(grid, i, j, dp, counter);
      }
    }

    int max = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m ; j++) {
        if (grid[i][j] == '0') {
          max = Math.max(dp[i][j], max);
        }
      }
    }

    return max;
  }

  private int incKills(char[][] grid, int i, int j, int[][] dp, int counter) {
    if (grid[i][j] == 'E') {
      counter++;
    } else if (grid[i][j] == 'W') {
      counter = 0;
    } else if (grid[i][j] == '0') {
      dp[i][j] += counter;
    }

    return counter;
  }


}
package leetcode;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 289. Game of Life
 * algorithm: Array
 * time complexity: O(n*m)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 37.6 MB, less than 7.69% of Java online submissions
 */
public class GameOfLife289 {

  private static int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0},
    {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

  public static void main(String[] args) {
    GameOfLife289 problem = new GameOfLife289();
    problem.test();
  }

  private void test() {
    int[][] board = {
      {0, 1, 0},
      {0, 0, 1},
      {1, 1, 1},
      {0, 0, 0}
    };

    gameOfLife(board);

    TestUtils.printArray(board);
  }

  public void gameOfLife(int[][] board) {
    if (board.length == 0) {
      return;
    }

    int n = board.length;
    int m = board[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int liveCells = 0;
        for (int[] dir : DIRS) {
          int x = i + dir[0];
          int y = j + dir[1];

          if (x >= 0 && y >= 0 && x < n && y < m && Math.abs(board[x][y]) == 1) {
            liveCells++;
          }
        }

        if (board[i][j] == 1 && (liveCells < 2 || liveCells > 3)) {
          board[i][j] = -1;
        } else if (board[i][j] == 0 && liveCells == 3) {
          board[i][j] = 2;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        board[i][j] = board[i][j] == 0 || board[i][j] == -1? 0: 1;
      }
    }
  }

  /**
   * @author Jandos Iskakov
   * time complexity: O(N*M)
   * space complexity: O(N*M)
   * Runtime: 0 ms, faster than 100.00% of Java online submissions
   * Memory Usage: 37.6 MB, less than 7.69% of Java online submissions
   */
  private static class V2 {

    public void gameOfLife(int[][] board) {
      if (board.length == 0) {
        return;
      }

      int n = board.length;
      int m = board[0].length;

      int[][] clone = new int[n][m];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          clone[i][j] = board[i][j];

          int liveCells = 0;
          for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && y >= 0 && x < n && y < m && board[x][y] == 1) {
              liveCells++;
            }
          }

          if (board[i][j] == 1 && (liveCells < 2 || liveCells > 3)) {
            clone[i][j] = 0;
          } else if (board[i][j] == 0 && liveCells == 3) {
            clone[i][j] = 1;
          }
        }
      }

      for (int i = 0; i < n; i++) {
        System.arraycopy(clone[i], 0, board[i], 0, m);
      }
    }
  }

}
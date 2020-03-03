package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 529. Minesweeper
 * algorithm: DFS
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 41.5 MB, less than 56.25% of Java online submissions
 */
public class Minesweeper529 {

  private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1},
    {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

  public static void main(String[] args) {
    Minesweeper529 problem = new Minesweeper529();
    problem.test();
  }

  private void test() {
    TestUtils.printArray(updateBoard(
      new char[][]{{'E', 'E', 'E', 'E', 'E'},
        {'E', 'E', 'M', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0}));
  }

  public char[][] updateBoard(char[][] board, int[] click) {
    boolean terminate = false;

    if (board[click[0]][click[1]] == 'M') {
      terminate = true;
      board[click[0]][click[1]] = 'X';
    } else {
      int mines = countMines(board, click[0], click[1]);
      if (mines > 0) {
        terminate = true;
        board[click[0]][click[1]] = (char) (mines + '0');
      }
    }

    if (terminate) {
      return board;
    }

    dfs(board, click[0], click[1]);

    return board;
  }

  private void dfs(char[][] board, int x, int y) {
    int mines = countMines(board, x, y);

    if (mines == 0) {
      board[x][y] = 'B';

      for (int[] dir : DIRS) {
        int x2 = x + dir[0];
        int y2 = y + dir[1];

        if (isValid(x2, y2, board) && board[x2][y2] == 'E') {
          dfs(board, x2, y2);
        }
      }

    } else if (mines > 0) {
      board[x][y] = (char) (mines + '0');
    }
  }

  private int countMines(char[][] board, int x, int y) {
    int mines = 0;

    for (int[] dir : DIRS) {
      int x2 = x + dir[0];
      int y2 = y + dir[1];

      if (isValid(x2, y2, board) && board[x2][y2] == 'M') {
        mines++;
      }
    }

    return mines;
  }

  private boolean isValid(int x, int y, char[][] board) {
    return x >= 0 && y >= 0 && x < board.length && y < board[x].length;
  }

  /**
   * Runtime: 2 ms, faster than 34.59% of Java online submissions
   * Memory Usage: 42.1 MB, less than 56.25% of Java online submissions
   */
  private static class V2 {

    public char[][] updateBoard(char[][] board, int[] click) {
      boolean terminate = false;

      if (board[click[0]][click[1]] == 'M') {
        terminate = true;
        board[click[0]][click[1]] = 'X';
      } else {
        int mines = countMines(board, click[0], click[1]);
        if (mines > 0) {
          terminate = true;
          board[click[0]][click[1]] = (char) (mines + '0');
        }
      }

      if (terminate) {
        return board;
      }

      Queue<int[]> queue = new LinkedList<>();
      queue.add(click);

      while (!queue.isEmpty()) {
        int[] node = queue.poll();

        int mines = countMines(board, node[0], node[1]);

        if (mines == 0) {
          board[node[0]][node[1]] = 'B';

          for (int[] dir : DIRS) {
            int x2 = node[0] + dir[0];
            int y2 = node[1] + dir[1];

            if (isValid(x2, y2, board) && board[x2][y2] == 'E') {
              board[x2][y2] = 'B';
              queue.add(new int[] {x2, y2});
            }
          }

        } else if (mines > 0) {
          board[node[0]][node[1]] = (char) (mines + '0');
        }
      }

      return board;
    }

    private int countMines(char[][] board, int x, int y) {
      int mines = 0;

      for (int[] dir : DIRS) {
        int x2 = x + dir[0];
        int y2 = y + dir[1];

        if (isValid(x2, y2, board) && board[x2][y2] == 'M') {
          mines++;
        }
      }

      return mines;
    }

    private boolean isValid(int x, int y, char[][] board) {
      return x >= 0 && y >= 0 && x < board.length && y < board[x].length;
    }

  }

}
package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 348. Design Tic-Tac-Toe
 * algorithm: Array, Design
 * time complexity: O(1)
 * space complexity: O(N)
 * Runtime: 46 ms, faster than 92.93% of Java online submissions for Design Tic-Tac-Toe.
 * Memory Usage: 46.7 MB, less than 21.43% of Java online submissions for Design Tic-Tac-Toe.
 */
public class DesignTicTacToe348 {

  public static void main(String[] args) {
    DesignTicTacToe348 problem = new DesignTicTacToe348();
    problem.test();
  }

  private void test() {
    TicTacToe toe = new TicTacToe(3);
    System.out.println(toe.move(0, 0, 1));
    System.out.println(toe.move(0, 2, 2));
    System.out.println(toe.move(2, 2, 1));
    System.out.println(toe.move(1, 1, 2));
    System.out.println(toe.move(2, 0, 1));
    System.out.println(toe.move(1, 0, 2));
    System.out.println(toe.move(2, 1, 1));
  }

  class TicTacToe {

    int[][] rows;
    int[][] cols;
    int[][] diags;
    int n;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
      this.rows = new int[n][2];
      this.cols = new int[n][2];
      this.diags = new int[2][2];
      this.n = n;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row The row of the board.
     * @param col The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either: 0: No one wins. 1: Player 1 wins. 2:
     * Player 2 wins.
     */
    public int move(int row, int col, int player) {
      rows[row][player - 1]++;
      cols[col][player - 1]++;

      if (row == col) {
        diags[0][player - 1]++;
      }

      if (col == n - row - 1) {
        diags[1][player - 1]++;
      }

      if (rows[row][player - 1] == n || cols[col][player - 1] == n ||
        diags[0][player - 1] == n || diags[1][player - 1] == n) {
        return player;
      }

      return 0;
    }
  }

}

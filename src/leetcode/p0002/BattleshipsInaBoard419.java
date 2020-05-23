package leetcode.p0002;

/**
 * @author Jandos Iskakov
 * problem: 419. Battleships in a Board
 * algorithm: Array
 * time complexity: O(N*M)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 42.4 MB, less than 86.96% of Java online submissions
 */
public class BattleshipsInaBoard419 {

  public static void main(String[] args) {
    BattleshipsInaBoard419 problem = new BattleshipsInaBoard419();
    problem.test();
  }

  private void test() {
    char[][] tc1a = new char[][]{{'X', '.', '.', 'X'},
      {'.', '.', '.', 'X'},
      {'.', '.', '.', 'X'}};

    System.out.println(countBattleships(tc1a));
  }

  public int countBattleships(char[][] board) {
    int count = 0;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'X' &&
          (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
          count++;
        }
      }
    }

    return count;
  }

}
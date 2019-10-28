package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 79. Word Search algorithm: Array, Backtracking
 * time complexity: O(N*M*K)
 * space complexity: O(N*M)
 * Runtime: 6 ms, faster than 35.62% of Java online submissions for Word Search.
 * Memory Usage: 38 MB, less than 100.00% of Java online submissions for Word Search.
 */
public class WordSearch79 {

  private static int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public static void main(String[] args) {
    WordSearch79 problem = new WordSearch79();
    problem.test();
  }

  private void test() {
    char[][] tc1a = {{'A', 'B', 'C', 'E'},
      {'S', 'F', 'C', 'S'},
      {'A', 'D', 'E', 'E'}};

    System.out.println(exist(tc1a, "ABCCED"));
    System.out.println(exist(tc1a, "SEE"));
    System.out.println(exist(tc1a, "ABCB"));
  }

  public boolean exist(char[][] board, String word) {
    int n = board.length, m = board[0].length;

    boolean[][] used = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        used[i][j] = true;
        if (exist(board, word, 0, i, j, used)) {
          return true;
        }
        used[i][j] = false;
      }
    }

    return false;
  }

  private boolean exist(char[][] board, String word, int pos, int i, int j, boolean[][] used) {
    int n = board.length;
    int m = board[i].length;

    if (word.charAt(pos) != board[i][j]) {
      return false;
    }

    if (pos == word.length() - 1) {
      return true;
    }

    for (int[] dir : DIRS) {
      int i2 = i + dir[0];
      int j2 = j + dir[1];

      if (i2 < 0 || j2 < 0 || i2 >= n || j2 >= m || used[i2][j2]) {
        continue;
      }

      used[i2][j2] = true;

      if (exist(board, word, pos + 1, i2, j2, used)) {
        return true;
      }

      used[i2][j2] = false;
    }

    return false;
  }

}

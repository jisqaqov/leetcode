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
        if (exist(board, word, 0, i, j, used)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean exist(char[][] board, String word, int pos, int i, int j, boolean[][] used) {
    int n = board.length;
    int m = board[0].length;

    if (pos == word.length()) {
      return true;
    }

    if (i < 0 || j < 0 || i >= n || j >= m || used[i][j]) {
      return false;
    }

    if (word.charAt(pos) != board[i][j]) {
      return false;
    }

    used[i][j] = true;

    if (exist(board, word, pos + 1, i - 1, j, used) ||
      exist(board, word, pos + 1, i + 1, j, used) ||
      exist(board, word, pos + 1, i, j - 1, used) ||
      exist(board, word, pos + 1, i, j + 1, used)) {
      return true;
    }

    used[i][j] = false;

    return false;
  }

}

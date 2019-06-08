package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 79. Word Search
 * algorithm: Array, Backtracking
 */
public class WordSearch79 {

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;

        boolean[][] used = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }

                if (word.length() == 1)
                    return true;

                used[i][j] = true;
                boolean exists = exist(board, word, 0, i, j, used);

                if (exists)
                    return true;

                used[i][j] = false;
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int pos, int i, int j, boolean[][] used) {
        int n = board.length, m = board[0].length;

        if (pos >= word.length() - 1)
            return true;

        if (j < m - 1 && board[i][j + 1] == word.charAt(pos + 1) && !used[i][j + 1]) {
            used[i][j + 1] = true;
            boolean exists = exist(board, word, pos + 1, i, j + 1, used);
            used[i][j + 1] = false;

            if (exists) {
                return true;
            }
        }

        if (j > 0 && board[i][j - 1] == word.charAt(pos + 1) && !used[i][j - 1]) {
            used[i][j - 1] = true;
            boolean exists = exist(board, word, pos + 1, i, j - 1, used);
            used[i][j - 1] = false;

            if (exists) {
                return true;
            }
        }

        if (i > 0 && board[i - 1][j] == word.charAt(pos + 1) && !used[i - 1][j]) {
            used[i - 1][j] = true;
            boolean exists = exist(board, word, pos + 1, i - 1, j, used);
            used[i - 1][j] = false;

            if (exists) {
                return true;
            }
        }

        if (i < n - 1 && board[i + 1][j] == word.charAt(pos + 1) && !used[i + 1][j]) {
            used[i + 1][j] = true;
            boolean exists = exist(board, word, pos + 1, i + 1, j, used);
            used[i + 1][j] = false;

            if (exists) {
                return true;
            }
        }

        return false;
    }

}

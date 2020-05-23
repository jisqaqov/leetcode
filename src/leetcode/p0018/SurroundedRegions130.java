package leetcode.p0018;

/**
 * @author Jandos Iskakov
 * problem: 130. Surrounded Regions
 * algorithm: DFS, Flood Fill
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 */
public class SurroundedRegions130 {

    public static void main(String[] args) {
        SurroundedRegions130 solution = new SurroundedRegions130();
        solution.test();
    }

    public void test() {
        char[][] tc1board = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};

        solve(tc1board);

        for (int i = 0; i < tc1board.length; i++) {
            System.out.println(tc1board[i]);
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        int n = board.length, m = board[0].length;

        boolean[][] borders = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board, borders);
            }
            if (board[i][m - 1] == 'O') {
                dfs(i, m - 1, board, borders);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board, borders);
            }
            if (board[n - 1][j] == 'O') {
                dfs(n - 1, j, board, borders);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!borders[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board, boolean[][] borders) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        if (board[i][j] == 'X' || borders[i][j]) {
            return;
        }

        borders[i][j] = true;

        dfs(i - 1, j, board, borders);
        dfs(i + 1, j, board, borders);
        dfs(i, j - 1, board, borders);
        dfs(i, j  + 1, board, borders);
    }

}

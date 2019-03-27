package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 200. Number of Islands
 * algorithm: DFS
 * time complexity: O(n*m)
 * space complexity: O(n*m)
 */
public class NumberOfIslands200 {

    public static void main(String[] args) {
        NumberOfIslands200 solution = new NumberOfIslands200();
        solution.test();
    }

    public void test() {
        char[][] tc1grid = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','1','0'}};

        System.out.println(numIslands(tc1grid));
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int n = grid.length, m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;

                    dfs(visited, grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(boolean[][] visited, char[][] grid, int i, int j) {
        if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] == '1') {
            visited[i - 1][j] = true;
            dfs(visited, grid, i - 1, j);
        }

        if (i < grid.length - 1 && !visited[i + 1][j] && grid[i + 1][j] == '1') {
            visited[i + 1][j] = true;
            dfs(visited, grid, i + 1, j);
        }

        if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] == '1') {
            visited[i][j - 1] = true;
            dfs(visited, grid, i, j - 1);
        }

        if (j < grid[i].length - 1 && !visited[i][j + 1] && grid[i][j + 1] == '1') {
            visited[i][j + 1] = true;
            dfs(visited, grid, i, j + 1);
        }
    }

}

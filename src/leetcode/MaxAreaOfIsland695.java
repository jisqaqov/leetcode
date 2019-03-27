package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 695. Max Area of Island
 * algorithm: DFS
 * time complexity: O(n*m)
 * space complexity: O(n*m)
 */
public class MaxAreaOfIsland695 {

    public static void main(String[] args) {
        MaxAreaOfIsland695 solution = new MaxAreaOfIsland695();
        solution.test();
    }

    public void test() {
        int[][] tc1grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
         {0,0,0,0,0,0,0,1,1,1,0,0,0},
         {0,1,1,0,1,0,0,0,0,0,0,0,0},
         {0,1,0,0,1,1,0,0,1,0,1,0,0},
         {0,1,0,0,1,1,0,0,1,1,1,0,0},
         {0,0,0,0,0,0,0,0,0,0,1,0,0},
         {0,0,0,0,0,0,0,1,1,1,0,0,0},
         {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(tc1grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int n = grid.length, m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;

                    int area = dfs(visited, grid, i, j);
                    max = Math.max(area, max);
                }
            }
        }

        return max;
    }

    private int dfs(boolean[][] visited, int[][] grid, int i, int j) {
        int k = 1;

        if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] == 1) {
            visited[i - 1][j] = true;
            k += dfs(visited, grid, i - 1, j);
        }

        if (i < grid.length - 1 && !visited[i + 1][j] && grid[i + 1][j] == 1) {
            visited[i + 1][j] = true;
            k += dfs(visited, grid, i + 1, j);
        }

        if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] == 1) {
            visited[i][j - 1] = true;
            k += dfs(visited, grid, i, j - 1);
        }

        if (j < grid[i].length - 1 && !visited[i][j + 1] && grid[i][j + 1] == 1) {
            visited[i][j + 1] = true;
            k += dfs(visited, grid, i, j + 1);
        }

        return k;
    }

}

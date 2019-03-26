package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 994. Rotting Oranges
 * algorithm: BFS,
 * time complexity: O(n*m)
 * space complexity: O(n*m)
 */
public class RottingOranges994 {

    public static void main(String[] args) {
        RottingOranges994 solution = new RottingOranges994();
        solution.test();
    }

    public void test() {
        int[][] tc1a = {{2,1,1}, {1,1,0}, {0,1,1}};
        int[][] tc2a = {{2,1,1}, {0,1,1}, {1,0,1}};
        int[][] tc3a = {{0,2}};

        System.out.println(orangesRotting(tc1a));
        System.out.println(orangesRotting(tc2a));
        System.out.println(orangesRotting(tc3a));
    }

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int n = grid.length, m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int minutes = 0;
        boolean[][] visited = new boolean[n][m];

        while (!queue.isEmpty()) {
            Queue<int[]> rottens = new LinkedList<>();

            while (!queue.isEmpty()) {
                int[] coords = queue.poll();
                int i = coords[0], j = coords[1];

                if (i < n - 1 && !visited[i + 1][j] && grid[i + 1][j] == 1) {
                    rottens.add(new int[] {i + 1, j});
                    visited[i + 1][j] = true;
                }

                if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] == 1) {
                    rottens.add(new int[] {i - 1, j});
                    visited[i - 1][j] = true;
                }

                if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] == 1) {
                    rottens.add(new int[] {i, j - 1});
                    visited[i][j - 1] = true;
                }

                if (j < m - 1 && !visited[i][j + 1] && grid[i][j + 1] == 1) {
                    rottens.add(new int[] {i, j + 1});
                    visited[i][j + 1] = true;
                }
            }

            if (!rottens.isEmpty()) {
                minutes++;
            }

            queue = rottens;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes;
    }

}

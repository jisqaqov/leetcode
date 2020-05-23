package leetcode.p0014;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 694. Number of Distinct Islands
 * algorithm: Hash Table, DFS
 * time complexity:
 * space complexity:
 * Runtime: 18 ms, faster than 18.90% of Java online submissions for Number of Distinct Islands.
 * Memory Usage: 45.9 MB, less than 26.32% of Java online submissions for Number of Distinct Islands.
 */
public class NumberOfDistinctIslands694 {

    public static void main(String[] args) {
        NumberOfDistinctIslands694 solution = new NumberOfDistinctIslands694();
        solution.test();
    }

    public void test() {
        int[][] tc1grid = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};

        System.out.println(numDistinctIslands(tc1grid));

        int[][] tc2grid = {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};

        System.out.println(numDistinctIslands(tc2grid));
    }

    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int n = grid.length, m = grid[0].length;
        if (m == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[n][m];

        Set<Island> islands = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || grid[i][j] == 0) {
                    continue;
                }

                Island island = new Island();
                dfs(grid, 0, 0, i, j, island, visited);

                islands.add(island);
            }
        }

        return islands.size();
    }

    private void dfs(int[][] grid, int x, int y, int i, int j, Island island, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if (visited[i][j] || grid[i][j] == 0) {
            return;
        }

        island.coords.add(new Coord(x, y));
        visited[i][j] = true;

        dfs(grid, x - 1, y, i, j - 1, island, visited);
        dfs(grid, x + 1, y, i, j + 1, island, visited);
        dfs(grid, x, y - 1, i - 1, j, island, visited);
        dfs(grid, x, y + 1, i + 1, j, island, visited);
    }

    private static class Island {
        private Set<Coord> coords = new HashSet<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Island island = (Island) o;
            return Objects.equals(coords, island.coords);
        }

        @Override
        public int hashCode() {
            return Objects.hash(coords);
        }
    }

    private static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coord coord = (Coord) o;
            return x == coord.x &&
                    y == coord.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}

package leetcode.p0018;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 317. Shortest Distance from All Buildings
 * algorithm: BFS
 * time complexity: O(nmk), k- number of buildings
 * space complexity: O(nmk)
 * Runtime: 28 ms, faster than 72.78% of Java online submissions
 * Memory Usage: 41.2 MB, less than 76.92% of Java online submissions
 */
public class ShortestDistanceFromAllBuildings317 {

  private static final int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

  public static void main(String[] args) {
    ShortestDistanceFromAllBuildings317 problem = new ShortestDistanceFromAllBuildings317();
    problem.test();
  }

  private void test() {
    //7
    System.out.println(shortestDistance(
      new int[][]{
        {1, 0, 2, 0, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0}}));//7

    //1
    System.out.println(shortestDistance(new int[][]{{1}, {0}}));//1

    //88
    System.out.println(shortestDistance(
      new int[][]{
        {1, 1, 1, 1, 1, 0},
        {0, 0, 0, 0, 0, 1},
        {0, 1, 1, 0, 0, 1},
        {1, 0, 0, 1, 0, 1},
        {1, 0, 1, 0, 0, 1},
        {1, 0, 0, 0, 0, 1},
        {0, 1, 1, 1, 1, 0}}));
  }

  public int shortestDistance(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    int[][] count = new int[n][m];
    int[][] dis = new int[n][m];

    int b = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          b++;

          bfs(grid, dis, count, i, j);
        }
      }
    }

    int min = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 0 && count[i][j] == b) {
          min = Math.min(min, dis[i][j]);
        }
      }
    }

    return min == Integer.MAX_VALUE ? -1 : min;
  }

  private void bfs(int[][] grid, int[][] dis, int[][] count, int x, int y) {
    int n = grid.length;
    int m = grid[0].length;

    boolean[][] visited = new boolean[n][m];

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});

    for (int k = 1; !queue.isEmpty(); k++) {
      for (int sz = queue.size(); sz > 0; sz--) {
        int[] node = queue.poll();

        for (int[] dir : DIRS) {
          int x2 = node[0] + dir[0];
          int y2 = node[1] + dir[1];

          if (x2 >= 0 && y2 >= 0 && x2 < n && y2 < m && grid[x2][y2] == 0 && !visited[x2][y2]) {
            dis[x2][y2] += k;
            count[x2][y2]++;

            visited[x2][y2] = true;

            queue.add(new int[]{x2, y2});
          }
        }
      }
    }
  }

}
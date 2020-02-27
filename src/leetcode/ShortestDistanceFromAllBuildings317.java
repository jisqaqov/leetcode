package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 317. Shortest Distance from All Buildings
 * algorithm: BFS
 * time complexity: O(nmk), k- number of buildings
 * space complexity: O(nmk)
 * Runtime: 67 ms, faster than 23.73% of Java online submissions
 * Memory Usage: 46.3 MB, less than 7.69% of Java online submissions
 */
public class ShortestDistanceFromAllBuildings317 {

  private static final int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

  public static void main(String[] args) {
    ShortestDistanceFromAllBuildings317 problem = new ShortestDistanceFromAllBuildings317();
    problem.test();
  }

  private void test() {
    System.out.println(shortestDistance(
      new int[][]{
        {1, 0, 2, 0, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0}}));
    System.out.println(shortestDistance(new int[][]{{1}, {0}}));

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

    Map[][] map = new HashMap[n][m];

    int[][] ids = new int[n][m];

    Queue<int[]> queue = new LinkedList<>();

    int buildings = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        map[i][j] = new HashMap<Integer, Integer>();

        if (grid[i][j] == 1) {
          ids[i][j] = buildings++;

          queue.add(new int[]{i, j, ids[i][j]});
        }
      }
    }

    int min = Integer.MAX_VALUE;
    int dis = 0;

    while (!queue.isEmpty()) {
      dis++;

      for (int sz = queue.size(); sz > 0; sz--) {
        int[] node = queue.poll();

        int x = node[0];
        int y = node[1];

        if (map[x][y].size() == buildings) {
          int amount = 0;
          for (Object bdis : map[x][y].values()) {
            amount += (Integer) bdis;
          }

          min = Math.min(min, amount);
        }

        for (int[] dir : DIRS) {
          int x2 = node[0] + dir[0];
          int y2 = node[1] + dir[1];

          if (x2 < 0 || y2 < 0 || x2 >= n || y2 >= m || grid[x2][y2] == 1 || grid[x2][y2] == 2) {
            continue;
          }

          if (!map[x2][y2].containsKey(node[2])) {
            queue.add(new int[]{x2, y2, node[2]});
            map[x2][y2].put(node[2], dis);
          }
        }
      }
    }

    return min == Integer.MAX_VALUE? -1: min;
  }

}
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 1091. Shortest Path in Binary Matrix
 * algorithm: BFS
 * time complexity: O(N^2)
 * space complexity: O(N^2)
 * Runtime: 29 ms, faster than 22.78% of Java online submissions
 * Memory Usage: 52.4 MB, less than 100.00% of Java online submissions
 */
public class ShortestPathInBinaryMatrix1091 {

  private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1},
    {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

  public static void main(String[] args) {
    ShortestPathInBinaryMatrix1091 problem = new ShortestPathInBinaryMatrix1091();
    problem.test();
  }

  private void test() {
    System.out.println(shortestPathBinaryMatrix(new int[][] {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
  }

  public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;

    Queue<int[]> queue = new LinkedList<>();
    if (grid[0][0] == 0) {
      queue.add(new int[] {0, 0});
    }

    boolean[][] visited = new boolean[n][n];
    visited[0][0] = true;

    for (int d = 1; !queue.isEmpty(); d++) {
      for (int sz = queue.size(); sz > 0; sz--) {
        int[] node = queue.poll();

        if (node[0] == n - 1 && node[1] == n - 1) {
          return d;
        }

        for (int[] dir : DIRS) {
          int x = node[0] + dir[0];
          int y = node[1] + dir[1];

          if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y] && grid[x][y] == 0) {
            visited[x][y] = true;
            queue.add(new int[] {x, y});
          }
        }
      }
    }

    return -1;
  }


}

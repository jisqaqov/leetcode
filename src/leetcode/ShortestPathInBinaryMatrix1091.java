package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 1091. Shortest Path in Binary Matrix
 * algorithm: BFS
 * time complexity: O(N^2)
 * space complexity: O(N^2)
 * Runtime: 29 ms, faster than 22.78% of Java online submissions for Shortest Path in Binary Matrix.
 * Memory Usage: 52.4 MB, less than 100.00% of Java online submissions for Shortest Path in Binary Matrix.
 */
public class ShortestPathInBinaryMatrix1091 {

  private static final int[][] DIRS = {
    {0, 1},
    {0, -1},
    {1, -1},
    {-1, 1},
    {-1, -1},
    {1, 1},
    {1, 0},
    {-1, 0}
  };

  public static void main(String[] args) {
    ShortestPathInBinaryMatrix1091 problem = new ShortestPathInBinaryMatrix1091();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
    System.out.println(shortestPathBinaryMatrix(tc1a));
  }

  public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;

    int[][] dis = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dis[i], Integer.MAX_VALUE);
    }

    Queue<int[]> queue = new LinkedList<>();

    if (grid[0][0] == 0) {
      dis[0][0] = 1;
      queue.add(new int[]{0, 0});
    }

    while (!queue.isEmpty()) {
      int[] node = queue.poll();

      if (node[0] == n - 1 && node[1] == n - 1) {
        return dis[n - 1][n - 1];
      }

      for (int[] dir : DIRS) {
        int[] cords = new int[]{dir[0] + node[0], dir[1] + node[1]};

        if (cords[0] >= 0 && cords[0] < n && cords[1] >= 0 && cords[1] < n
          && dis[cords[0]][cords[1]] == Integer.MAX_VALUE && grid[cords[0]][cords[1]] == 0) {
          dis[cords[0]][cords[1]] = dis[node[0]][node[1]] + 1;
          queue.add(cords);
        }
      }
    }

    return -1;
  }


}

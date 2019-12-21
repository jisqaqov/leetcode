package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 542. 01 Matrix
 * algorithm: BFS
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 * Runtime: 19 ms, faster than 35.66% of Java online submissions
 * Memory Usage: 54 MB, less than 95.83% of Java online submissions
 */
public class Matrix01542 {

  public static void main(String[] args) {
    Matrix01542 problem = new Matrix01542();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{0, 0, 0},
      {0, 1, 0},
      {1, 1, 1}};

    TestUtils.printArray(updateMatrix(tc1a));

    int[][] tc2a = {{0, 0, 0},
      {0, 1, 0},
      {0, 0, 0}};

    TestUtils.printArray(updateMatrix(tc2a));
  }

  public int[][] updateMatrix(int[][] matrix) {
    Queue<int[]> queue = new ArrayDeque<>();

    int n = matrix.length;
    int m = matrix[0].length;

    boolean[][] visited = new boolean[n][m];

    int[][] dis = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == 0) {
          queue.add(new int[]{i, j});
        }
      }
    }

    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    while (!queue.isEmpty()) {
      int[] node = queue.poll();

      for (int[] dir : dirs) {
        int i = dir[0] + node[0];
        int j = dir[1] + node[1];

        if (i < 0 || j < 0 || i >= n || j >= m || matrix[i][j] == 0 || visited[i][j]) {
          continue;
        }

        visited[i][j] = true;
        dis[i][j] = dis[node[0]][node[1]] + 1;
        queue.add(new int[]{i, j});
      }
    }

    return dis;
  }

}

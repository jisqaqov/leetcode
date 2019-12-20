package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import utils.TestUtils;

/**
 * @author Jandos Iskakov problem: 542. 01 Matrix algorithm: BFS time complexity: O(N*M) space
 * complexity: O(N*M) Runtime: 19 ms, faster than 35.66% of Java online submissions Memory Usage: 54
 * MB, less than 95.83% of Java online submissions
 */
public class Matrix01542 {

  private static int[][] DIMS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

  public static void main(String[] args) {
    Matrix01542 problem = new Matrix01542();
    problem.test();
  }

  private void test() {
    V2 v2 = new V2();

    int[][] tc1a = {{0, 0, 0},
      {0, 1, 0},
      {1, 1, 1}};

    TestUtils.printArray(v2.updateMatrix(tc1a));

    int[][] tc2a = {{0, 0, 0},
      {0, 1, 0},
      {0, 0, 0}};

    TestUtils.printArray(v2.updateMatrix(tc2a));
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

    while (!queue.isEmpty()) {
      int[] node = queue.poll();

      for (int[] dim : DIMS) {
        int i = dim[0] + node[0];
        int j = dim[1] + node[1];

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

  private static class V2 {

    public int[][] updateMatrix(int[][] matrix) {
      int n = matrix.length;
      int m = matrix[0].length;

      boolean[][] visited = new boolean[n][m];

      int[][] dis = new int[n][m];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (matrix[i][j] == 0) {
            visited[i][j] = true;
          } else {
            dis[i][j] = Integer.MAX_VALUE;
          }
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (dis[i][j] == 0) {
            dfs(i, j, matrix, dis, visited);
          }
        }
      }

      return dis;
    }

    private void dfs(int i, int j, int[][] matrix, int[][] dis, boolean[][] visited) {
      visited[i][j] = true;

      if (matrix[i][j] == 0) {
        for (int[] dim : DIMS) {
          int x = i + dim[0];
          int y = j + dim[1];

          if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] == 0) {
            continue;
          }

          visited[x][y] = true;
          dis[x][y] = 1;
        }
      } else {
        for (int[] dim : DIMS) {
          int x = i + dim[0];
          int y = j + dim[1];

          if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            continue;
          }

          if (!visited[x][y]) {
            dfs(x, y, matrix, dis, visited);
          }

          if (dis[x][y] != Integer.MAX_VALUE) {
            dis[i][j] = Math.min(dis[i][j], dis[x][y] + 1);
          }
        }
      }
    }

  }

}

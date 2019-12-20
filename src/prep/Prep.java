package prep;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import utils.TestUtils;

public class Prep {

  private static int[][] DIMS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

  public static void main(String[] args) {
    Prep problem = new Prep();
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


}
package prep;

import java.util.ArrayDeque;
import java.util.Queue;

public class Prep {

  private static int[][] DIMS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    char[][] tc1a = {{'O', 'O', 'O', 'O'},
      {'D', 'O', 'D', 'O'},
      {'O', 'O', 'O', 'O'},
      {'X', 'D', 'D', 'O'}};

    System.out.println(minNumberSteps(tc1a));
  }

  public int minNumberSteps(char[][] grid) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{0, 0});

    int n = grid.length;
    int m = grid[0].length;

    boolean[][] visited = new boolean[n][m];

    int[][] dis = new int[n][m];

    while (!queue.isEmpty()) {
      int[] node = queue.poll();

      if (grid[node[0]][node[1]] == 'X') {
        return dis[node[0]][node[1]];
      }

      for (int[] dim : DIMS) {
        int i = dim[0] + node[0];
        int j = dim[1] + node[1];

        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 'D' || visited[i][j]) {
          continue;
        }

        visited[i][j] = true;
        queue.add(new int[]{i, j});
        dis[i][j] = dis[node[0]][node[1]] + 1;
      }
    }

    return 0;
  }


}
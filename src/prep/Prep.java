package prep;

import java.util.LinkedList;
import java.util.Queue;
import utils.TestUtils;

public class Prep {

  private static final int INF = Integer.MAX_VALUE;
  private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    int[][] tc1grid = {{INF, -1, 0, INF},
      {INF, INF, INF, -1},
      {INF, -1, INF, -1},
      {0, -1, INF, INF}};

    wallsAndGates(tc1grid);
    TestUtils.printArray(tc1grid);
  }

  public void wallsAndGates(int[][] grid) {
    Queue<int[]> queue = new LinkedList<>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 0) {
          queue.add(new int[]{i, j});
        }
      }
    }

    while (!queue.isEmpty()) {
      for (int sz = queue.size(); sz > 0; sz--) {
        int[] node = queue.poll();

        for (int[] dir : DIRS) {
          int i = dir[0] + node[0];
          int j = dir[1] + node[1];

          if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) {
            continue;
          }

          int dis = grid[node[0]][node[1]] + 1;
          if (grid[i][j] > dis) {
            grid[i][j] = dis;
            queue.add(new int[]{i, j});
          }
        }
      }
    }
  }


}
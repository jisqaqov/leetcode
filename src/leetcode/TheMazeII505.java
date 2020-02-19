package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 505. The Maze II
 * algorithm: BFS
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 * Runtime: 6 ms, faster than 97.70% of Java online submissions
 * Memory Usage: 42.5 MB, less than 100.00% of Java online submissions
 */
public class TheMazeII505 {
  private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

  public static void main(String[] args) {
    TheMazeII505 problem = new TheMazeII505();
    problem.test();
  }

  private void test() {
    int[][] maze = {{0, 0, 1, 0, 0},
      {0, 0, 0, 0, 0},
      {0, 0, 0, 1, 0},
      {1, 1, 0, 1, 1},
      {0, 0, 0, 0, 0}};
    System.out.println(shortestDistance(maze, new int[]{0, 4}, new int[]{4, 4}));//12
  }

  public int shortestDistance(int[][] maze, int[] start, int[] dest) {
    int n = maze.length;
    int m = maze[0].length;

    Queue<int[]> queue = new LinkedList<>();
    queue.add(start);

    int[][] dis = new int[n][m];
    for (int[] temp : dis) {
      Arrays.fill(temp, Integer.MAX_VALUE);
    }

    dis[start[0]][start[1]] = 0;

    while (!queue.isEmpty()) {
      for (int sz = queue.size(); sz > 0; sz--) {
        int[] node = queue.poll();

        for (int[] dir : DIRS) {
          int x = node[0];
          int y = node[1];

          while (x >= 0 && y >= 0 && x < n && y < m && maze[x][y] == 0) {
            x += dir[0];
            y += dir[1];
          }

          x -= dir[0];
          y -= dir[1];

          int k = Math.abs(node[0] - x) + Math.abs(node[1] - y);
          int newDis = dis[node[0]][node[1]] + k;

          if (dis[x][y] > newDis) {
            dis[x][y] = newDis;
            queue.add(new int[]{x, y});
          }
        }
      }
    }

    return dis[dest[0]][dest[1]] != Integer.MAX_VALUE? dis[dest[0]][dest[1]] : -1;
  }

  private static class V2 {

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
      int n = maze.length;
      int m = maze[0].length;

      int[][] dis = new int[n][m];
      for (int[] temp : dis) {
        Arrays.fill(temp, Integer.MAX_VALUE);
      }

      dis[start[0]][start[1]] = 0;

      helper(maze, start, dis);

      return dis[dest[0]][dest[1]] != Integer.MAX_VALUE? dis[dest[0]][dest[1]] : -1;
    }

    private void helper(int[][] maze, int[] node, int[][] dis) {
      int n = maze.length;
      int m = maze[0].length;

      for (int[] dir : DIRS) {
        int x = node[0];
        int y = node[1];

        while (x >= 0 && y >= 0 && x < n && y < m && maze[x][y] == 0) {
          x += dir[0];
          y += dir[1];
        }

        x -= dir[0];
        y -= dir[1];

        int k = Math.abs(node[0] - x) + Math.abs(node[1] - y);
        int newDis = dis[node[0]][node[1]] + k;

        if (dis[x][y] > newDis) {
          dis[x][y] = newDis;
          helper(maze, new int[] {x, y}, dis);
        }
      }
    }

  }


}
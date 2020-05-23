package leetcode.p0019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 505. The Maze II
 * algorithm: BFS, DFS, Greedy (Dijkstra)
 * time complexity: O(n*m*max(n, m))
 * space complexity: O(n*m)
 * Runtime: 5 ms, faster than 99.86% of Java online submissions
 * Memory Usage: 42.1 MB, less than 100.00% of Java online submissions
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

          int count = -1;
          while (x >= 0 && y >= 0 && x < n && y < m && maze[x][y] == 0) {
            x += dir[0];
            y += dir[1];

            count++;
          }

          x -= dir[0];
          y -= dir[1];

          int newDis = dis[node[0]][node[1]] + count;

          if (dis[x][y] > newDis) {
            dis[x][y] = newDis;
            queue.add(new int[]{x, y});
          }
        }
      }
    }

    return dis[dest[0]][dest[1]] != Integer.MAX_VALUE ? dis[dest[0]][dest[1]] : -1;
  }

  private static class DFS {

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
      int n = maze.length;
      int m = maze[0].length;

      int[][] dis = new int[n][m];
      for (int[] temp : dis) {
        Arrays.fill(temp, Integer.MAX_VALUE);
      }

      dis[start[0]][start[1]] = 0;

      dfs(maze, start, dis);

      return dis[dest[0]][dest[1]] != Integer.MAX_VALUE ? dis[dest[0]][dest[1]] : -1;
    }

    private void dfs(int[][] maze, int[] node, int[][] dis) {
      int n = maze.length;
      int m = maze[0].length;

      for (int[] dir : DIRS) {
        int x = node[0];
        int y = node[1];

        int count = 0;
        while (x >= 0 && y >= 0 && x < n && y < m && maze[x][y] == 0) {
          x += dir[0];
          y += dir[1];

          count++;
        }

        x -= dir[0];
        y -= dir[1];

        int newDis = dis[node[0]][node[1]] + count - 1;

        if (dis[x][y] > newDis) {
          dis[x][y] = newDis;
          dfs(maze, new int[]{x, y}, dis);
        }
      }
    }

  }

  /**
   * time complexity: O(n*m*log(n*m))
   * space complexity: O(n*m)
    */
  private static class Dijkstra {

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
      int n = maze.length;
      int m = maze[0].length;

      PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
      pq.add(new int[]{start[0], start[1], 0});

      int[][] dis = new int[n][m];
      for (int[] temp : dis) {
        Arrays.fill(temp, Integer.MAX_VALUE);
      }

      dis[start[0]][start[1]] = 0;

      boolean[][] visited = new boolean[n][m];

      while (!pq.isEmpty()) {
        int[] node = pq.poll();

        if (visited[node[0]][node[1]]) {
          continue;
        }

        visited[node[0]][node[1]] = true;
        dis[node[0]][node[1]] = node[2];

        for (int[] dir : DIRS) {
          int x2 = node[0];
          int y2 = node[1];

          int count = -1;
          while (x2 >= 0 && y2 >= 0 && x2 < n && y2 < m && maze[x2][y2] == 0) {
            x2 += dir[0];
            y2 += dir[1];

            count++;
          }

          x2 -= dir[0];
          y2 -= dir[1];

          int newDis = dis[node[0]][node[1]] + count;

          if (!visited[x2][y2]) {
            pq.add(new int[]{x2, y2, newDis});
          }
        }

      }

      return dis[dest[0]][dest[1]] != Integer.MAX_VALUE ? dis[dest[0]][dest[1]] : -1;
    }

  }


}
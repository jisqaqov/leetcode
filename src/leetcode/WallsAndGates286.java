package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jandos Iskakov problem: 286. Walls and Gates algorithm: BFS time complexity: O(N*M) space
 * complexity: O(N*M)
 */
public class WallsAndGates286 {

  public static void main(String[] args) {
    WallsAndGates286 solution = new WallsAndGates286();
    solution.test();
  }

  public void test() {
    int[][] tc1rooms = {{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
      {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
      {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
      {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
    };

    wallsAndGates(tc1rooms);

    int[][] tc1solution = {{3, -1, 0, 1},
      {2, 2, 1, -1},
      {1, -1, 2, -1},
      {0, -1, 3, 4}};

    print(tc1rooms);

    for (int i = 0; i < tc1rooms.length; i++) {
      for (int j = 0; j < tc1rooms[i].length; j++) {
        if (tc1rooms[i][j] != tc1solution[i][j]) {
          System.out.println("i = " + i + ", j = " + j);
        }
      }
    }
  }

  private void print(int[][] rooms) {
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[i].length; j++) {
        System.out.print(rooms[i][j] + " ");
      }
      System.out.println();
    }
  }

  public void wallsAndGates(int[][] rooms) {
    int n = rooms.length;
    if (n == 0) {
      return;
    }

    int m = rooms[0].length;

    Queue<Integer[]> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (rooms[i][j] == 0) {
          queue.add(new Integer[]{i, j});
        }
      }
    }

    Map<Integer, Set<Integer>> visited = new HashMap<>();

    while (!queue.isEmpty()) {
      Integer[] node = queue.poll();

      int si = node[0];
      int sj = node[1];

      visited.putIfAbsent(si, new HashSet<>());
      visited.get(si).add(sj);

      List<Integer[]> adjList = new ArrayList<>();

      adjList.add(new Integer[]{si + 1, sj});
      adjList.add(new Integer[]{si - 1, sj});
      adjList.add(new Integer[]{si, sj + 1});
      adjList.add(new Integer[]{si, sj - 1});

      for (Integer[] adj : adjList) {
        int ti = adj[0];
        int tj = adj[1];

        if (ti < 0 || tj < 0 || ti >= n || tj >= m) {
          continue;
        }

        if (rooms[ti][tj] <= 0 || (visited.containsKey(ti) && visited.get(ti).contains(tj))) {
          continue;
        }

        queue.add(new Integer[]{ti, tj});

        if (rooms[si][sj] < rooms[ti][tj]) {
          rooms[ti][tj] = Math.min(rooms[si][sj] + 1, rooms[ti][tj]);
        }
      }
    }
  }

}

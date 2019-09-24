package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WallsAndGates286 {

  public static void main(String[] args) {
    WallsAndGates286 solution = new WallsAndGates286();
    solution.test();
  }

  public void test() {
    int[][] tc1rooms = {{0,2147483647,0,2147483647,0,2147483647,0,-1,0,2147483647,2147483647,2147483647,0,2147483647,-1,-1,-1,2147483647,2147483647,0},
    {2147483647,2147483647,0,2147483647,0,-1,-1,2147483647,2147483647,2147483647,-1,0,-1,2147483647,2147483647,0,-1,0,-1,-1},
    {0,-1,-1,2147483647,-1,-1,-1,2147483647,2147483647,-1,-1,0,-1,2147483647,-1,-1,0,0,-1,0},
    {2147483647,-1,2147483647,-1,0,-1,0,2147483647,2147483647,0,-1,0,-1,-1,0,2147483647,0,0,2147483647,2147483647},
    {0,2147483647,-1,-1,-1,0,2147483647,2147483647,0,0,-1,2147483647,2147483647,-1,0,2147483647,-1,2147483647,2147483647,2147483647},
    {2147483647,-1,0,2147483647,2147483647,-1,0,-1,2147483647,0,-1,0,0,-1,-1,2147483647,-1,2147483647,2147483647,0},
    {2147483647,2147483647,2147483647,0,0,2147483647,-1,0,-1,-1,-1,2147483647,2147483647,-1,2147483647,2147483647,-1,2147483647,-1,-1},
    {0,0,0,-1,0,0,2147483647,-1,-1,0,-1,0,2147483647,-1,-1,0,0,0,0,2147483647},
    {-1,-1,2147483647,2147483647,2147483647,0,-1,0,0,2147483647,2147483647,0,2147483647,-1,0,-1,0,0,2147483647,0},
    {0,0,0,-1,-1,2147483647,-1,0,-1,2147483647,0,-1,-1,2147483647,-1,0,2147483647,-1,-1,-1},
    {-1,0,2147483647,0,-1,0,0,-1,2147483647,0,-1,-1,-1,0,0,2147483647,2147483647,2147483647,0,2147483647},
    {-1,-1,-1,0,0,-1,2147483647,2147483647,2147483647,0,-1,0,-1,0,2147483647,0,2147483647,2147483647,0,-1},
    {0,2147483647,-1,2147483647,0,-1,-1,0,-1,2147483647,2147483647,0,-1,2147483647,0,-1,2147483647,2147483647,-1,0},
    {0,0,0,0,-1,2147483647,2147483647,-1,2147483647,2147483647,-1,-1,-1,-1,-1,-1,2147483647,0,-1,-1},
    {-1,-1,0,-1,-1,-1,0,-1,-1,2147483647,2147483647,2147483647,-1,2147483647,2147483647,0,0,0,-1,0},
    {2147483647,-1,0,2147483647,-1,-1,0,2147483647,0,2147483647,2147483647,0,-1,2147483647,0,0,2147483647,2147483647,0,-1},
    {0,-1,0,0,2147483647,2147483647,0,0,2147483647,2147483647,-1,0,-1,0,2147483647,0,0,0,2147483647,2147483647},
    {0,-1,-1,-1,0,2147483647,-1,2147483647,-1,-1,-1,0,-1,2147483647,2147483647,-1,-1,-1,0,2147483647}};

    wallsAndGates(tc1rooms);

    int[][] tc1solution = {{0,1,0,1,0,1,0,-1,0,1,2,1,0,1,-1,-1,-1,1,1,0},
    {1,1,0,1,0,-1,-1,2,1,2,-1,0,-1,2,1,0,-1,0,-1,-1},
    {0,-1,-1,2,-1,-1,-1,2,2,-1,-1,0,-1,3,-1,-1,0,0,-1,0},
    {1,-1,2147483647,-1,0,-1,0,1,1,0,-1,0,-1,-1,0,1,0,0,1,1},
    {0,1,-1,-1,-1,0,1,1,0,0,-1,1,1,-1,0,1,-1,1,2,1},
    {1,-1,0,1,1,-1,0,-1,1,0,-1,0,0,-1,-1,2,-1,2,1,0},
    {1,1,1,0,0,1,-1,0,-1,-1,-1,1,1,-1,2,1,-1,1,-1,-1},
    {0,0,0,-1,0,0,1,-1,-1,0,-1,0,1,-1,-1,0,0,0,0,1},
    {-1,-1,1,2,1,0,-1,0,0,1,1,0,1,-1,0,-1,0,0,1,0},
    {0,0,0,-1,-1,1,-1,0,-1,1,0,-1,-1,1,-1,0,1,-1,-1,-1},
    {-1,0,1,0,-1,0,0,-1,1,0,-1,-1,-1,0,0,1,2,1,0,1},
    {-1,-1,-1,0,0,-1,1,1,1,0,-1,0,-1,0,1,0,1,1,0,-1},
    {0,1,-1,1,0,-1,-1,0,-1,1,1,0,-1,1,0,-1,2,1,-1,0},
    {0,0,0,0,-1,2,1,-1,3,2,-1,-1,-1,-1,-1,-1,1,0,-1,-1},
    {-1,-1,0,-1,-1,-1,0,-1,-1,2,2,1,-1,2,1,0,0,0,-1,0},
    {1,-1,0,1,-1,-1,0,1,0,1,1,0,-1,1,0,0,1,1,0,-1},
    {0,-1,0,0,1,1,0,0,1,2,-1,0,-1,0,1,0,0,0,1,2},
    {0,-1,-1,-1,0,1,-1,1,-1,-1,-1,0,-1,1,2,-1,-1,-1,0,1}};

    print(tc1rooms, tc1solution);
  }

  private void print(int[][] rooms, int[][] solution) {
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[i].length; j++) {
        System.out.print(rooms[i][j] + " ");
      }
      System.out.println();
    }

    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[i].length; j++) {
        if (rooms[i][j] != solution[i][j]) {
          System.out.println("i = " + i + ", j = " + j);
        }
      }
    }
  }

  public void wallsAndGates(int[][] rooms) {
    int n = rooms.length;
    if (n == 0) {
      return;
    }

    int m = rooms[0].length;

    List<Integer[]> emptyRooms = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (rooms[i][j] == Integer.MAX_VALUE) {
          emptyRooms.add(new Integer[]{i, j});
        }
      }
    }

    for (Integer[] emptyRoom : emptyRooms) {
      int oi = emptyRoom[0];
      int oj = emptyRoom[1];

      Map<Integer, Set<Integer>> visited = new HashMap<>();

      dfs(visited, rooms, oi, oj);
    }

    boolean refines = true;
    while (refines) {
      refines = false;

      for (Integer[] emptyRoom : emptyRooms) {
        int oi = emptyRoom[0];
        int oj = emptyRoom[1];

        if (refine(rooms, oi, oj)) {
          refines = true;
        }
      }
    }
  }

  boolean refine(int[][] rooms, int i, int j) {
    boolean refines = false;

    List<Integer[]> adjList = new ArrayList<>();
    adjList.add(new Integer[]{i + 1, j});
    adjList.add(new Integer[]{i - 1, j});
    adjList.add(new Integer[]{i, j + 1});
    adjList.add(new Integer[]{i, j - 1});

    for(Integer[] adj : adjList) {
      int ti = adj[0];
      int tj = adj[1];

      if (ti < 0 || tj < 0 || ti >= rooms.length || tj >= rooms[0].length) {
        continue;
      }

      if (rooms[ti][tj] == -1) {
        continue;
      }

      int oldValue =  rooms[i][j];
      if (rooms[ti][tj] < rooms[i][j]) {
        rooms[i][j] = Math.min(rooms[ti][tj] + 1, rooms[i][j]);
      }

      if (oldValue > rooms[i][j]) {
        refines = true;
      }
    }

    return refines;
  }

  int dfs(Map<Integer, Set<Integer>> visited, int[][] rooms, int i, int j) {
    if (rooms[i][j] == 0) {
      return 0;
    }

    if (rooms[i][j] != Integer.MAX_VALUE) {
      return rooms[i][j];
    }

    visited.putIfAbsent(i, new HashSet<>());
    visited.get(i).add(j);

    List<Integer[]> adjList = new ArrayList<>();
    adjList.add(new Integer[]{i + 1, j});
    adjList.add(new Integer[]{i - 1, j});
    adjList.add(new Integer[]{i, j + 1});
    adjList.add(new Integer[]{i, j - 1});

    int min = Integer.MAX_VALUE;

    for(Integer[] adj : adjList) {
      int ti = adj[0];
      int tj = adj[1];

      if (ti < 0 || tj < 0 || ti >= rooms.length || tj >= rooms[0].length) {
        continue;
      }

      if (rooms[ti][tj] == -1 || (visited.containsKey(ti) && visited.get(ti).contains(tj))) {
        continue;
      }

      int dis = dfs(visited, rooms, ti, tj);
      if (dis >= 0 && dis < min) {
        min = Math.min(dis + 1, min);
      }
    }

    rooms[i][j] = min;

    visited.get(i).remove(j);

    return min;
  }

}

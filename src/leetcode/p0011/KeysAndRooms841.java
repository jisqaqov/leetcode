package leetcode.p0011;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 841. Keys and Rooms
 * algorithm: DFS, Graph
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 39.6 MB, less than 100.00%
 */
public class KeysAndRooms841 {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int n = rooms.size();

    boolean[] visited = new boolean[n];

    walk(0, visited, rooms);

    for (int v = 0; v < n; v++) {
      if (!visited[v]) {
        return false;
      }
    }

    return true;
  }

  private void walk(int room, boolean[] visited, List<List<Integer>> rooms) {
    visited[room] = true;

    for (Integer key : rooms.get(room)) {
      if (!visited[key]) {
        walk(key, visited, rooms);
      }
    }
  }

  private class IterativeDfsVersion {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      int n = rooms.size();

      Deque<Integer> stack = new ArrayDeque<>();
      stack.push(0);

      boolean[] visited = new boolean[n];
      visited[0] = true;

      while (!stack.isEmpty()) {
        int room = stack.poll();

        for (int key : rooms.get(room)) {
          if (!visited[key]) {
            visited[key] = true;
            stack.push(key);
          }
        }
      }

      for (int i = 0; i < n; i++) {
        if (!visited[i]) {
          return false;
        }
      }

      return true;
    }

  }

}
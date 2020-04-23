package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 886. Possible Bipartition
 * algorithm: Graph, DFS
 * time complexity: O(N + E)
 * space complexity: O(N + E)
 * Runtime: 11 ms, faster than 95.97% of Java online submissions
 * Memory Usage: 47.1 MB, less than 100.00% of Java online submissions
 */
public class PossibleBipartition886 {

  public boolean possibleBipartition(int n, int[][] dislikes) {
    List<Integer>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] dislike : dislikes) {
      int u = dislike[0] - 1;
      int v = dislike[1] - 1;

      graph[u].add(v);
      graph[v].add(u);
    }

    int[] groups = new int[n];

    for (int i = 0; i < n; i++) {
      if (groups[i] != 0) {
        continue;
      }

      groups[i] = 1;

      Queue<Integer> queue = new LinkedList<>();
      queue.add(i);

      while (!queue.isEmpty()) {
        int person = queue.poll();

        for (int adj : graph[person]) {
          if (groups[adj] == groups[person]) {
            return false;
          }

          if (groups[adj] == 0) {
            groups[adj] = -groups[person];
            queue.add(adj);
          }
        }
      }
    }

    return true;
  }

  private static class DfsVersion {

    public boolean possibleBipartition(int n, int[][] dislikes) {
      Set<Integer>[] graph = new HashSet[n + 1];
      for (int i = 1; i <= n; i++) {
        graph[i] = new HashSet<>();
      }

      for (int[] dislike : dislikes) {
        graph[dislike[0]].add(dislike[1]);
        graph[dislike[1]].add(dislike[0]);
      }

      int[] groups = new int[n + 1];

      for (int p = 1; p <= n; p++) {
        if (groups[p] == 0) {
          groups[p] = 1;

          if (!dfs(groups, p, graph)) {
            return false;
          }
        }
      }

      return true;
    }

    private boolean dfs(int[] groups, int person, Set<Integer>[] dislikes) {
      for (int p : dislikes[person]) {
        if (groups[person] == groups[p]) {
          return false;
        }

        if (groups[p] == 0) {
          groups[p] = -groups[person];

          if (!dfs(groups, p, dislikes)) {
            return false;
          }
        }
      }

      return true;
    }

  }

  private static class V2 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
      Set<Integer>[] graph = new HashSet[n + 1];
      for (int i = 1; i <= n; i++) {
        graph[i] = new HashSet<>();
      }

      for (int[] dislike : dislikes) {
        graph[dislike[0]].add(dislike[1]);
        graph[dislike[1]].add(dislike[0]);
      }

      int[] colors = new int[n + 1];

      for (int node = 1; node <= n; node++) {
        if (colors[node] == 0 && !paint(colors, node, graph, 1)) {
          return false;
        }
      }

      return true;
    }

    private boolean paint(int[] colors, int node, Set<Integer>[] graph, int color) {
      if (colors[node] != 0) {
        return colors[node] == color;
      }

      colors[node] = color;

      for (int adj : graph[node]) {
        if (!paint(colors, adj, graph, -color)) {
          return false;
        }
      }

      return true;
    }


  }

}
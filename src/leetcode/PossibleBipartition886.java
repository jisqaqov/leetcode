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

    int[] colors = new int[n];

    for (int i = 0; i < n; i++) {
      if (colors[i] != 0) {
        continue;
      }

      colors[i] = 1;

      Queue<Integer> queue = new LinkedList<>();
      queue.add(i);

      while (!queue.isEmpty()) {
        int node = queue.poll();

        for (int adj : graph[node]) {
          if (colors[adj] == colors[node]) {
            return false;
          }

          if (colors[adj] == 0) {
            colors[adj] = -colors[node];
            queue.add(adj);
          }
        }
      }
    }

    return true;
  }

  private static class DfsVersion {

    public boolean possibleBipartition(int n, int[][] dislikes) {
      List<Integer>[] graph = new ArrayList[n + 1];
      for (int i = 1; i <= n; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int[] dislike : dislikes) {
        graph[dislike[0]].add(dislike[1]);
        graph[dislike[1]].add(dislike[0]);
      }

      int[] colors = new int[n + 1];

      for (int node = 1; node <= n; node++) {
        if (colors[node] == 0) {
          colors[node] = 1;

          if (!dfs(colors, node, graph)) {
            return false;
          }
        }
      }

      return true;
    }

    private boolean dfs(int[] colors, int person, List<Integer>[] graph) {
      for (int p : graph[person]) {
        if (colors[person] == colors[p]) {
          return false;
        }

        if (colors[p] == 0) {
          colors[p] = -colors[person];

          if (!dfs(colors, p, graph)) {
            return false;
          }
        }
      }

      return true;
    }

  }

  private static class V2 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
      List<Integer>[] graph = new ArrayList[n + 1];
      for (int i = 1; i <= n; i++) {
        graph[i] = new ArrayList<>();
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

    private boolean paint(int[] colors, int node, List<Integer>[] graph, int color) {
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
package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 785. Is Graph Bipartite?
 * algorithm: DFS, Graph
 * time complexity: O(V + E)
 * space complexity: O(V)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Is Graph Bipartite?.
 * Memory Usage: 45.3 MB, less than 36.59% of Java online submissions for Is Graph Bipartite?.
 */
public class IsGraphBipartite785 {

  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] colour = new int[n];

    for (int u = 0; u < n; u++) {
      if (colour[u] != 0) {
        continue;
      }

      colour[u] = 1;
      if (!isBipartite(u, colour, graph)) {
        return false;
      }
    }

    return true;
  }

  private boolean isBipartite(int node, int[] colour, int[][] graph) {
    for (int adj : graph[node]) {
      if (colour[adj] == colour[node]) {
        return false;
      }

      if (colour[adj] == 0) {
        colour[adj] = -colour[node];
        if (!isBipartite(adj, colour, graph)) {
          return false;
        }
      }
    }

    return true;
  }

  private static class IterativeDFSApproach {

    public boolean isBipartite(int[][] graph) {
      int n = graph.length;
      int[] colour = new int[n];

      for (int v = 0; v < n; v++) {
        if (colour[v] != 0) {
          continue;
        }

        colour[v] = -1;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(v);

        while (!stack.isEmpty()) {
          int node = stack.poll();

          for (int adj : graph[node]) {
            if (colour[adj] == colour[node]) {
              return false;
            }

            if (colour[adj] == 0) {
              colour[adj] = -colour[node];
              stack.push(adj);
            }
          }
        }
      }

      return true;
    }
  }

  private static class BFSApproach {

    public boolean isBipartite(int[][] graph) {
      int n = graph.length;
      int[] colour = new int[n];

      for (int v = 0; v < n; v++) {
        if (colour[v] != 0) {
          continue;
        }

        colour[v] = 1;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);

        while (!queue.isEmpty()) {
          int node = queue.poll();

          for (int adj : graph[node]) {
            if (colour[adj] == colour[node]) {
              return false;
            }

            if (colour[adj] == 0) {
              colour[adj] = -colour[node];
              queue.add(adj);
            }
          }
        }
      }

      return true;
    }
  }

}

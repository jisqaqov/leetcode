package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 785. Is Graph Bipartite?
 * algorithm: DFS, Graph
 * time complexity: O(V + E)
 * space complexity: O(V + E)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Is Graph Bipartite?.
 * Memory Usage: 45.3 MB, less than 36.59% of Java online submissions for Is Graph Bipartite?.
 */
public class IsGraphBipartite785 {

  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] set = new int[n];

    for (int u = 0; u < n; u++) {
      if (set[u] != 0) {
        continue;
      }

      set[u] = 1;
      if (!isBipartite(u, set, graph)) {
        return false;
      }
    }

    return true;
  }

  private boolean isBipartite(int s, int[] set, int[][] graph) {
    for (int adj : graph[s]) {
      if (set[adj] == set[s]) {
        return false;
      }

      if (set[adj] == 0) {
        set[adj] = set[s] == 1? 2: 1;
        if (!isBipartite(adj, set, graph)) {
          return false;
        }
      }
    }

    return true;
  }

}

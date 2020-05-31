package leetcode.p0006;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 802. Find Eventual Safe States
 * algorithm: DFS, Graph
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 47 ms, faster than 21.75%
 * Memory Usage: 47.9 MB, less than 100.00%
 */
public class FindEventualSafeStates802 {

  public List<Integer> eventualSafeNodes(int[][] graph) {
    int n = graph.length;

    Set<Integer> cycles = new HashSet<>();
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(i, visited, new HashSet<>(), cycles, graph);
      }
    }

    List<Integer> output = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (!cycles.contains(i)) {
        output.add(i);
      }
    }

    return output;
  }

  private void dfs(int node, boolean[] visited, Set<Integer> walks, Set<Integer> cycles,
    int[][] graph) {
    visited[node] = true;

    walks.add(node);

    for (int adj : graph[node]) {
      if ((visited[adj] && walks.contains(adj)) || cycles.contains(adj)) {
        cycles.addAll(walks);
      } else if (!visited[adj]) {
        dfs(adj, visited, walks, cycles, graph);
      }
    }

    walks.remove(node);
  }

}
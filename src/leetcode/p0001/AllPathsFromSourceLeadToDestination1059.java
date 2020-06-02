package leetcode.p0001;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 1059. All Paths from Source Lead to Destination
 * algorithm: DFS, Graph
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 * Runtime: 4 ms, faster than 99.66%
 * Memory Usage: 41.7 MB, less than 100.00%
 */
public class AllPathsFromSourceLeadToDestination1059 {

  public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
    List<Integer>[] adjList = new List[n];
    for (int v = 0; v < n; v++) {
      adjList[v] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      adjList[edge[0]].add(edge[1]);
    }

    int[] states = new int[n];

    return dfs(adjList, source, states, destination);
  }

  private boolean dfs(List<Integer>[] adjList, int source, int[] states, int destination) {
    if (states[source] != 0) {
      return states[source] == 1;
    }

    if (adjList[source].isEmpty()) {
      return source == destination;
    }

    states[source] = -1;

    for (int adj : adjList[source]) {
      if (!dfs(adjList, adj, states, destination)) {
        return false;
      }
    }

    states[source] = 1;

    return true;
  }

}
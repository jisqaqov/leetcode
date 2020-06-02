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

    boolean[] visited = new boolean[n];
    boolean[] explored = new boolean[n];

    return dfs(adjList, source, visited, explored, destination);
  }

  private boolean dfs(List<Integer>[] adjList, int source, boolean[] visited, boolean[] explored, int destination) {
    if (adjList[source].isEmpty()) {
      return source == destination;
    }

    visited[source] = true;

    explored[source] = true;

    for (int adj : adjList[source]) {
      if (explored[adj] || (!visited[adj] && !dfs(adjList, adj, visited, explored, destination))) {
        return false;
      }
    }

    explored[source] = false;

    return true;
  }

}
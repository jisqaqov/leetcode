package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 684. Redundant Connection
 * algorithm: Graph
 * time complexity: O(Elog(E) + V + E)
 * space complexity: O(Elog(E) + V + E)
 * Runtime: 5 ms, faster than 21.98% of Java online submissions
 * Memory Usage: 40 MB, less than 63.64% of Java online submissions
 */
public class RedundantConnection684 {

  public static void main(String[] args) {
    RedundantConnection684 problem = new RedundantConnection684();
    problem.test();
  }

  private void test() {
    TestUtils
      .printArray(findRedundantConnection(new int[][]{{1, 3}, {1, 2}, {2, 5}, {3, 4}, {2, 4}}));
  }

  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;

    List<Integer>[] adjList = new List[n + 1];
    for (int i = 0; i <= n; i++) {
      adjList[i] = new ArrayList();
    }

    for (int[] edge : edges) {
      adjList[edge[0]].add(edge[1]);
      adjList[edge[1]].add(edge[0]);
    }

    Set<Integer> cycles = new HashSet<>();

    int[] time = new int[n + 1];
    int[] vertex = new int[2];

    boolean[] visited = new boolean[n + 1];

    findCycle(adjList, visited, 1, -1, cycles, time, vertex);

    int minTime = time[vertex[0]];
    int maxTime = time[vertex[1]];

    for (int v : new ArrayList<>(cycles)) {
      if (time[v] < minTime || time[v] > maxTime) {
        cycles.remove(v);
      }
    }

    List<Integer> temp = new ArrayList<>(cycles);
    temp.sort(Comparator.comparingInt(a -> time[a]));

    boolean[][] candidates = new boolean[n + 1][n + 1];

    for (int i = 0; i < temp.size() - 1; i++) {
      int u = Math.min(temp.get(i), temp.get(i + 1));
      int v = Math.max(temp.get(i), temp.get(i + 1));

      candidates[u][v] = true;
    }

    int u = Math.min(vertex[0], vertex[1]);
    int v = Math.max(vertex[0], vertex[1]);

    candidates[u][v] = true;

    int output = -1;
    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];

      if (candidates[edge[0]][edge[1]]) {
        output = Math.max(output, i);
      }
    }

    return edges[output];
  }

  private boolean findCycle(List<Integer>[] adjList, boolean[] visited, int src, int prev,
    Set<Integer> cycles, int[] time, int[] vertex) {

    visited[src] = true;

    cycles.add(src);

    time[0]++;
    time[src] = time[0];

    for (int adj : adjList[src]) {
      if (adj == prev) {
        continue;
      }

      if (visited[adj]) {
        vertex[0] = adj;
        vertex[1] = src;

        return true;
      }

      if (findCycle(adjList, visited, adj, src, cycles, time, vertex)) {
        return true;
      }
    }

    cycles.remove(src);

    return false;
  }

}
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

    int[] states = new int[n];

    List<Integer> output = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (checkSafe(graph, states, i)) {
        output.add(i);
      }
    }

    return output;
  }

  private boolean checkSafe(int[][] graph, int[] states, int node) {
    if (states[node] != 0) {
      return states[node] == 1;
    }

    states[node] = -1;

    for (int adj : graph[node]) {
      if (!checkSafe(graph, states, adj)) {
        return false;
      }
    }

    states[node] = 1;

    return true;
  }

}
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem:
 * algorithm: Graph, Backtracking
 * time complexity:
 * space complexity:
 */
public class AllPathsFromSourceToTarget797 {

  public static void main(String[] args) {
    AllPathsFromSourceToTarget797 problem = new AllPathsFromSourceToTarget797();
    problem.test();
  }

  private void test() {
    int[][] tc1g = {{1,2}, {3}, {3}, {}};
    System.out.println(allPathsSourceTarget(tc1g));
  }

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    return dfs(0, graph.length - 1, graph, new HashMap<>());
  }

  private List<List<Integer>> dfs(int s, int d, int[][] graph, Map<Integer, List<List<Integer>>> map) {
    List<List<Integer>> solution = new ArrayList<>();

    if (s == d) {
      solution.add(Collections.singletonList(d));
      return solution;
    }

    if (map.containsKey(s)) {
      return map.get(s);
    }

    for (int v : graph[s]) {
      List<List<Integer>> path = dfs(v, d, graph, map);

      for (List<Integer> list : path) {
        List<Integer> newList = new ArrayList<>();
        newList.add(s);
        newList.addAll(list);

        solution.add(newList);
      }
    }

    map.put(s, solution);

    return solution;
  }

}

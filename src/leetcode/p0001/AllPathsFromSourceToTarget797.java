package leetcode.p0001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 797. All Paths From Source to Target
 * algorithm: Graph, Recursion
 * time complexity: O(2^N*N^2)
 * space complexity: O(2^N*N)
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
    return dfs(0, graph);
  }

  private List<List<Integer>> dfs(int s, int[][] graph) {
    int n = graph.length - 1;

    List<List<Integer>> solution = new ArrayList<>();

    if (s == n) {
      solution.add(new ArrayList<>(Collections.singleton(n)));
      return solution;
    }

    for (int v : graph[s]) {
      for (List<Integer> list : dfs(v, graph)) {
        list.add(0, s);
        solution.add(list);
      }
    }

    return solution;
  }

}

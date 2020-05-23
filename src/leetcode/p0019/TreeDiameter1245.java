package leetcode.p0019;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 1245. Tree Diameter
 * algorithm: Tree, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 15 ms, faster than 34.04% of Java online submissions
 * Memory Usage: 54.6 MB, less than 100.00% of Java online submissions
 */
public class TreeDiameter1245 {

  private int diameter = 0;

  public static void main(String[] args) {
    TreeDiameter1245 problem = new TreeDiameter1245();
    problem.test();
  }

  private void test() {
    System.out.println(treeDiameter(new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}}));//4
  }

  public int treeDiameter(int[][] edges) {
    int n = edges.length + 1;

    List<Integer>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }

    maxDepth(0, -1, graph);

    return diameter;
  }

  private int maxDepth(int root, int parent, List<Integer>[] graph) {
    int maxDepth = 0;

    for (int adj : graph[root]) {
      if (adj == parent) {
        continue;
      }

      int depth = maxDepth(adj, root, graph) + 1;

      diameter = Math.max(diameter, depth + maxDepth);

      maxDepth = Math.max(maxDepth, depth);
    }

    return maxDepth;
  }

}
package leetcode;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 684. Redundant Connection
 * algorithm: Graph
 * time complexity: O(Nlog(N))
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 39.4 MB, less than 72.73%
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
    DisjointSet ds = new DisjointSet(edges.length);

    for (int[] edge : edges) {
      int u = edge[0] - 1;
      int v = edge[1] - 1;

      if (!ds.union(u, v)) {
        return edge;
      }
    }

    return edges[0];
  }

  private class DisjointSet {
    private int[] ds;

    DisjointSet(int n) {
      ds = new int[n];
      for (int i = 0; i < n; i++) {
        ds[i] = i;
      }
    }

    int root(int x) {
      while (ds[x] != x) {
        ds[x] = ds[ds[x]];
        x = ds[x];
      }

      return ds[x];
    }

    boolean union(int x, int y) {
      int rootX = root(x);
      int rootY = root(y);

      if (rootX != rootY) {
        ds[rootX] = rootY;

        return true;
      }

      return false;
    }

  }

}
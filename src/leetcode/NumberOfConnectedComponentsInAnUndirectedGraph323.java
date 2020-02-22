package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 323. Number of Connected Components in an Undirected Graph
 * algorithm: Union Find
 * time complexity: O(n*gamma(m))
 * space complexity: O(n)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 40.9 MB, less than 100.00% of Java online submissions
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph323 {

  public static void main(String[] args) {
    NumberOfConnectedComponentsInAnUndirectedGraph323 problem =
      new NumberOfConnectedComponentsInAnUndirectedGraph323();
    problem.test();
  }

  private void test() {
    System.out.println(countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));//2
    System.out.println(countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}));//1
    System.out.println(countComponents(5, new int[][]{{0, 1}, {1, 2}, {0, 2}, {3, 4}}));//2
  }

  public int countComponents(int n, int[][] edges) {
    DisjointSet ds = new DisjointSet(n);

    for (int[] edge : edges) {
      ds.union(edge[0], edge[1]);
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (ds.ds[i] == i) {
        count++;
      }
    }

    return count;
  }

  private static class DisjointSet {

    private int[] ds;

    public DisjointSet(int n) {
      this.ds = new int[n];
      for (int i = 0; i < n; i++) {
        ds[i] = i;
      }
    }

    private int getRoot(int x) {
      while (ds[x] != x) {
        ds[x] = ds[ds[x]];
        x = ds[x];
      }

      return ds[x];
    }

    private void union(int x, int y) {
      int rootX = getRoot(x);
      int rootY = getRoot(y);

      ds[rootX] = rootY;
    }


  }


}
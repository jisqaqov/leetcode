package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 547. Friend Circles
 * algorithm: DFS, Union Find
 * time complexity: O(N^2)
 * space complexity: O(N^2)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 42.1 MB, less than 56.00% of Java online submissions
 */
public class FriendCircles547 {

  public static void main(String[] args) {
    FriendCircles547 problem = new FriendCircles547();
    problem.test();
  }

  private void test() {
    System.out.println(findCircleNum(new int[][]{{1, 1, 0},
      {1, 1, 0},
      {0, 0, 1}}));//2
    System.out.println(findCircleNum(new int[][]{{1, 1, 0},
      {1, 1, 1},
      {0, 1, 1}}));//1
  }

  public int findCircleNum(int[][] m) {
    int circles = 0;
    boolean[] visited = new boolean[m.length];

    for (int u = 0; u < m.length; u++) {
      if (!visited[u]) {
        circles++;
        dfs(u, m, visited);
      }
    }

    return circles;
  }

  private void dfs(int u, int[][] m, boolean[] visited) {
    visited[u] = true;
    for (int v = 0; v < m.length; v++) {
      if (!visited[v] && m[u][v] == 1 && u != v) {
        dfs(v, m, visited);
      }
    }
  }

  private static class V2 {

    public int findCircleNum(int[][] m) {
      DisjointSet ds = new DisjointSet(m.length);

      for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < m.length; j++) {
          if (m[i][j] == 1) {
            ds.union(i, j);
          }
        }
      }

      int circles = 0;
      for (int i = 0; i < m.length; i++) {
        if (ds.ds[i] == i) {
          circles++;
        }
      }

      return circles;
    }

    private class DisjointSet {

      private int[] ds;

      DisjointSet(int n) {
        ds = new int[n];
        for (int i = 0; i < n; i++) {
          ds[i] = i;
        }
      }

      int getRoot(int x) {
        while (ds[x] != x) {
          x = ds[x];
          ds[x] = ds[ds[x]];
        }

        return x;
      }

      void union(int x, int y) {
        int rootX = getRoot(x);
        int rootY = getRoot(y);

        ds[rootX] = rootY;
      }

    }

  }

}
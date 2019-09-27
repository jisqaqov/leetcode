package leetcode;

/**
 * @author Jandos Iskakov problem: 261. Graph Valid Tree algorithm: Graph, Union Find time
 * complexity: O(V+E) space complexity: O(V+E)
 */
public class GraphValidTreeXXX {

  public static void main(String[] args) {
    GraphValidTreeXXX problem = new GraphValidTreeXXX();
    problem.test();
  }

  private void test() {
    int[][] tc0edges = {{0, 1}, {2, 3}, {1, 2}};
    int[][] tc1edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
    int[][] tc2edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
    int[][] tc3edges = {{0, 1}, {2, 3}};
    int[][] tc4edges = {{2, 3}, {1, 2}, {1, 3}};
    int[][] tc5edges = {{1, 0}, {2, 0}};

    System.out.println(validTree(4, tc0edges));
    System.out.println(validTree(5, tc1edges));
    System.out.println(validTree(5, tc2edges));
    System.out.println(validTree(4, tc3edges));
    System.out.println(validTree(4, tc4edges));
    System.out.println(validTree(3, tc5edges));
  }

  public boolean validTree(int n, int[][] edges) {
    if (n <= 0) {
      return true;
    }

    if (edges.length == 0 && n > 1) {
      return false;
    }

    int[] ds = new int[n];
    for (int i = 0; i < n; i++) {
      ds[i] = i;
    }

    int root = edges[0][0];

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];

      if (ds[u] != u && ds[v] != v) {
        return false;
      }

      if ((u == root && ds[v] != v) || (v == root && ds[u] != u)) {
        return false;
      }

      if (u == root) {
        ds[v] = u;
      } else if (v == root) {
        ds[u] = v;
      } else if (ds[u] != u) {
        ds[v] = u;
      } else if (ds[v] != v) {
        ds[u] = v;
      } else if (ds[u] == u && ds[v] == v) {
        ds[v] = u;
      }
    }

    int roots = 0;
    for (int i = 0; i < n; i++) {
      if (ds[i] == i) {
        roots++;
      }
    }

    return roots <= 1;
  }

}

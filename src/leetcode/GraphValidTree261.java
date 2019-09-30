package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 261. Graph Valid Tree
 * algorithm: Graph, Union Find, BFS
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 */
public class GraphValidTree261 {

  public static void main(String[] args) {
    GraphValidTree261 problem = new GraphValidTree261();
    problem.test();
  }

  private void test() {
    int[][] tc0edges = {{0, 1}, {2, 3}, {1, 2}};
    int[][] tc1edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
    int[][] tc2edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
    int[][] tc3edges = {{0, 1}, {2, 3}};
    int[][] tc4edges = {{2, 3}, {1, 2}, {1, 3}};
    int[][] tc5edges = {{1, 0}, {2, 0}};

    System.out.println(validTreeUsingDfs(4, tc0edges));
    System.out.println(validTreeUsingDfs(5, tc1edges));
    System.out.println(validTreeUsingDfs(5, tc2edges));
    System.out.println(validTreeUsingDfs(4, tc3edges));
    System.out.println(validTreeUsingDfs(4, tc4edges));
    System.out.println(validTreeUsingDfs(3, tc5edges));
  }

  public boolean validTree(int n, int[][] edges) {
    if (n <= 0) {
      return true;
    }

    if (edges.length == 0 && n == 1) {
      return true;
    } else if (edges.length == 0) {
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

  public boolean validTreeUsingBfs(int n, int[][] edges) {
    if (n <= 0) {
      return true;
    }

    if (edges.length == 0 && n == 1) {
      return true;
    } else if (edges.length == 0) {
      return false;
    }

    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];

      adjList.get(u).add(v);
      adjList.get(v).add(u);
    }

    Set<Integer> visited = new HashSet<>();

    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);

    Set<Integer> marked = new HashSet<>();

    while(!queue.isEmpty()) {
      int node = queue.poll();

      visited.add(node);

      for (int v : adjList.get(node)) {
        if (node == v) {
          return true;
        }

        if (visited.contains(v)) {
          continue;
        }

        if (marked.contains(v)) {
          return false;
        }

        marked.add(v);
        queue.add(v);
      }
    }

    return visited.size() == n;
  }

  public boolean validTreeUsingDfs(int n, int[][] edges) {
    if (n <= 0) {
      return true;
    }

    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];

      adjList.get(u).add(v);
      adjList.get(v).add(u);
    }

    Set<Integer> visited = new HashSet<>();

    if (dfs(0, 0, visited, adjList)) {
      return false;
    }

    return visited.size() == n;
  }

  private boolean dfs(int parent, int node, Set<Integer> visited, List<List<Integer>> adjList) {
    visited.add(node);

    for (Integer adj : adjList.get(node)) {
      if (adj == parent) {
        continue;
      }

      if (visited.contains(adj) || dfs(node, adj, visited, adjList)) {
        return true;
      }
    }

    return false;
  }

}

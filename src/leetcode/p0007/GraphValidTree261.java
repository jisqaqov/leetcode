package leetcode.p0007;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 261. Graph Valid Tree
 * algorithm: Graph, Union Find, BFS, DFS
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

    DisjointSet ds = new DisjointSet(n);

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];

      if (u == v || ds.parent(u) == ds.parent(v)) {
        return false;
      }

      ds.union(u, v);
    }

    int roots = 0;
    for (int i = 0; i < n; i++) {
      if (ds.ds[i] == i) {
        roots++;
      }
    }

    return roots == 1;
  }

  private static class DisjointSet {
    private int[] ds;

    DisjointSet(int n) {
      this.ds = new int[n];

      for (int i = 0; i < n; i++) {
        ds[i] = i;
      }
    }

    private int parent(int i) {
      while (ds[i] != i) {
        ds[i] = ds[ds[i]];
        i = ds[i];
      }

      return i;
    }

    private void union(int i, int j) {
      int rootX = parent(i);
      int rootY = parent(j);

      ds[rootX] = rootY;
    }
  }

  public boolean validTreeUsingBfs(int n, int[][] edges) {
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

    if (validTreeUsingDfs(0, 0, visited, adjList)) {
      return false;
    }

    return visited.size() == n;
  }

  private boolean validTreeUsingDfs(int parent, int node, Set<Integer> visited,
    List<List<Integer>> adjList) {
    visited.add(node);

    for (Integer adj : adjList.get(node)) {
      if (adj == parent) {
        continue;
      }

      if (visited.contains(adj) || validTreeUsingDfs(node, adj, visited, adjList)) {
        return true;
      }
    }

    return false;
  }

}

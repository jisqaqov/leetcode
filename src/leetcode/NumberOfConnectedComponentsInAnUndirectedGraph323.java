package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 323. Number of Connected Components in an Undirected Graph
 * algorithm: Union Find, BFS, DFS
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

  /**
   * algorithm: Union Find
   * time complexity: O(n*gamma(m))
   * space complexity: O(n)
   * Runtime: 1 ms, faster than 100.00% of Java online submissions
   * Memory Usage: 40.9 MB, less than 100.00% of Java online submissions
   */
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

  /**
   * @author Jandos Iskakov
   * algorithm: BFS
   * time complexity: O(v+e)
   * space complexity: O(v)
   * Runtime: 5 ms, faster than 46.32% of Java online submissions
   * Memory Usage: 41.7 MB, less than 100.00% of Java online submissions
   */
  private static class BFS {

    public int countComponents(int n, int[][] edges) {
      List<Integer>[] adjList = new ArrayList[n];
      for (int v = 0; v < n; v++) {
        adjList[v] = new ArrayList<>();
      }

      for (int[] edge : edges) {
        adjList[edge[0]].add(edge[1]);
        adjList[edge[1]].add(edge[0]);
      }

      int count = 0;
      boolean[] visited = new boolean[n];

      for (int v = 0; v < n; v++) {
        if (visited[v]) {
          continue;
        }

        count++;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
          int node = queue.poll();
          for (int adj : adjList[node]) {
            if (!visited[adj]) {
              visited[adj] = true;
              queue.add(adj);
            }
          }
        }
      }

      return count;
    }

  }

  /**
   * @author Jandos Iskakov
   * algorithm: DFS
   * time complexity: O(v+e)
   * space complexity: O(v)
   * Runtime: 3 ms, faster than 69.81% of Java online submissions
   * Memory Usage: 41.1 MB, less than 100.00% of Java online submissions
   */
  private static class DFS {

    public int countComponents(int n, int[][] edges) {
      List<Integer>[] adjList = new ArrayList[n];
      for (int v = 0; v < n; v++) {
        adjList[v] = new ArrayList<>();
      }

      for (int[] edge : edges) {
        adjList[edge[0]].add(edge[1]);
        adjList[edge[1]].add(edge[0]);
      }

      int count = 0;
      boolean[] visited = new boolean[n];

      for (int v = 0; v < n; v++) {
        if (!visited[v]) {
          count++;

          dfs(v, visited, adjList);
        }
      }

      return count;
    }

    private void dfs(int node, boolean[] visited, List<Integer>[] adjList) {
      visited[node] = true;

      for (int adj : adjList[node]) {
        if (!visited[adj]) {
          dfs(adj, visited, adjList);
        }
      }
    }

  }


}
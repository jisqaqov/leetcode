package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 1245. Tree Diameter
 * algorithm: Tree, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 13 ms, faster than 42.25% of Java online submissions
 * Memory Usage: 54.5 MB, less than 100.00% of Java online submissions
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

    List<Integer>[] adjList = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adjList[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      adjList[edge[0]].add(edge[1]);
      adjList[edge[1]].add(edge[0]);
    }

    boolean[] visited = new boolean[n];

    treeDiameter(0, adjList, visited);

    return diameter;
  }

  private int treeDiameter(int src, List<Integer>[] adjList, boolean[] visited) {
    visited[src] = true;

    int m = adjList[src].size();
    int[] list = new int[m];

    for (int i = 0, k = 0; i < m; i++) {
      int node = adjList[src].get(i);
      if (!visited[node]) {
        list[k++] = treeDiameter(node, adjList, visited) + 1;
      }
    }

    int max = 0;
    for (int i = 0; i < list.length; i++) {
      max = Math.max(max, list[i]);
      for (int j = i + 1; j < list.length; j++) {
        diameter = Math.max(diameter, list[i] + list[j]);
      }
    }

    return max;
  }

}
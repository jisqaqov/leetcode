package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 787. Cheapest Flights Within K Stops
 * algorithm: BFS, DFS, Dijkstra
 * time complexity:
 * space complexity:
 * Runtime: 12 ms, faster than 50.61% of Java online submissions
 * Memory Usage: 42.8 MB, less than 5.55% of Java online submissions
 */
public class CheapestFlightsWithinKStops787 {

  public static void main(String[] args) {
    CheapestFlightsWithinKStops787 problem = new CheapestFlightsWithinKStops787();
    problem.test();
  }

  private void test() {
    //200
    System.out.println(findCheapestPrice(3,
      new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
    //500
    System.out.println(findCheapestPrice(3,
      new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
    // 7
    System.out.println(findCheapestPrice(5,
      new int[][]{{0, 1, 5}, {1, 2, 5}, {3, 1, 2}, {0, 3, 2}, {1, 4, 1}, {4, 2, 1}}, 0, 2, 2));
    // -1
    System.out.println(findCheapestPrice(5,
      new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}}, 2, 1, 1));

    int[][] tc1 =
      {{7, 5, 20}, {7, 6, 59}, {3, 1, 95}, {7, 0, 85}, {4, 7, 84}, {0, 7, 90}, {1, 0, 19},
        {2, 5, 74}, {2, 3, 81}, {2, 0, 56}, {5, 1, 25}, {4, 0, 89}, {3, 6, 18}, {5, 2, 1},
        {7, 1, 43}, {3, 2, 66}, {7, 3, 4}};

    System.out.println(findCheapestPrice(8, tc1, 0, 6, 6));
  }

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    List<List<int[]>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int[] flight : flights) {
      adjList.get(flight[0]).add(new int[]{flight[1], flight[2]});
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    pq.add(new int[]{src, 0, 0});

    int[] dis = new int[n];
    Arrays.fill(dis, Integer.MAX_VALUE);

    dis[src] = 0;

    while (!pq.isEmpty()) {
      int[] node = pq.poll();

      if (node[0] == dst) {
        return node[2];
      }

      dis[node[0]] = node[2];

      for (int[] adj : adjList.get(node[0])) {
        int len = node[1];
        if (adj[0] != dst) {
          len = node[1] + 1;
        }

        int newDis = dis[node[0]] + adj[1];
        if (len <= k && dis[adj[0]] > newDis) {
          pq.add(new int[]{adj[0], len, newDis});
          dis[adj[0]] = newDis;
        }
      }
    }

    return -1;
  }

  private static class BFS {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      List<List<int[]>> adjList = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        adjList.add(new ArrayList<>());
      }

      for (int[] flight : flights) {
        adjList.get(flight[0]).add(new int[]{flight[1], flight[2]});
      }

      Queue<int[]> queue = new LinkedList<>();
      queue.add(new int[]{src, 0, 0});

      int[][] dp = new int[n][k + 1];
      for (int i = 0; i < n; i++) {
        Arrays.fill(dp[i], Integer.MAX_VALUE);
      }

      dp[src][0] = 0;

      while (!queue.isEmpty()) {
        int[] node = queue.poll();

        int u = node[0];
        int s = node[1];

        for (int[] adj : adjList.get(u)) {
          int v = adj[0];
          int len = v == dst ? s : s + 1;

          if (len <= k && dp[u][s] + adj[1] < dp[v][len]) {
            queue.add(new int[]{v, len});
            dp[v][len] = dp[u][s] + adj[1];
          }
        }
      }

      int output = Integer.MAX_VALUE;
      for (int i = 0; i <= k; i++) {
        output = Math.min(dp[dst][i], output);
      }

      return output == Integer.MAX_VALUE ? -1 : output;
    }

  }

  private static class DFS {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      List<List<int[]>> adjList = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        adjList.add(new ArrayList<>());
      }

      for (int[] flight : flights) {
        adjList.get(flight[1]).add(new int[]{flight[0], flight[2]});
      }

      int[][] dp = new int[n][k + 1];
      for (int i = 0; i < n; i++) {
        Arrays.fill(dp[i], Integer.MAX_VALUE);
      }

      dp[src][0] = 0;

      boolean[][] visited = new boolean[n][n];

      helper(src, dst, dp, adjList, k, visited);

      int output = Integer.MAX_VALUE;
      for (int i = 0; i <= k; i++) {
        output = Math.min(dp[dst][i], output);
      }

      return output == Integer.MAX_VALUE ? -1 : output;
    }

    private void helper(int src, int dst, int[][] dp, List<List<int[]>> adjList, int k,
      boolean[][] visited) {

      for (int[] flight : adjList.get(dst)) {
        int city = flight[0];

        if (!visited[city][dst]) {
          visited[city][dst] = true;
          helper(src, city, dp, adjList, k, visited);
        }

        if (city == src) {
          dp[dst][0] = Math.min(dp[dst][0], flight[1]);
        } else {
          for (int i = 0; i < k; i++) {
            if (dp[city][i] != Integer.MAX_VALUE) {
              dp[dst][i + 1] = Math.min(dp[dst][i + 1], dp[city][i] + flight[1]);
            }
          }
        }
      }
    }


  }

}
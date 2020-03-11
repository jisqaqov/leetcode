package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 787. Cheapest Flights Within K Stops
 * algorithm: BFS, Dijkstra
 * time complexity: O(elog(v)), O(ek)
 * space complexity: O(v)
 * Runtime: 5 ms, faster than 86.39% of Java online submissions
 * Memory Usage: 41.1 MB, less than 5.55% of Java online submissions
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

    //112
    System.out.println(findCheapestPrice(8, tc1, 0, 6, 6));
  }

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, List<int[]>> adjList = new HashMap<>();

    for (int[] flight : flights) {
      adjList.putIfAbsent(flight[0], new ArrayList<>());
      adjList.get(flight[0]).add(new int[]{flight[1], flight[2]});
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(src);

    int[] cost = new int[n];
    Arrays.fill(cost, Integer.MAX_VALUE);

    cost[src] = 0;

    for (int stops = 0; !queue.isEmpty(); stops++) {
      for (int sz = queue.size(); sz > 0; sz--) {
        int u = queue.poll();

        if (adjList.containsKey(u)) {
          for (int[] flight : adjList.get(u)) {
            int v = flight[0];
            int price = flight[1];

            if (stops == k && v != dst) {
              continue;
            }

            int newPrice = cost[u] + price;
            if (cost[v] > newPrice) {
              queue.add(flight[0]);
              cost[v] = newPrice;
            }
          }
        }
      }
    }

    return cost[dst] == Integer.MAX_VALUE? -1: cost[dst];
  }

  private static class Dijkstra {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      Map<Integer, List<int[]>> adjList = new HashMap<>();

      for (int[] flight : flights) {
        adjList.putIfAbsent(flight[0], new ArrayList<>());
        adjList.get(flight[0]).add(new int[]{flight[1], flight[2]});
      }

      PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
      pq.add(new int[]{src, 0, 0});

      while (!pq.isEmpty()) {
        int[] node = pq.poll();

        if (node[0] == dst) {
          return node[2];
        }

        if (node[1] <= k && adjList.containsKey(node[0])) {
          for (int[] adj : adjList.get(node[0])) {
            int newDis = node[2] + adj[1];
            pq.add(new int[]{adj[0], node[1] + 1, newDis});
          }
        }
      }

      return -1;
    }

  }


}
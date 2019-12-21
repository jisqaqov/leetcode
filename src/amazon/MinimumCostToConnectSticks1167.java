package amazon;

import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 1167. Minimum Cost to Connect Sticks
 * algorithm: Greedy
 * time complexity: O(nlog(n))
 * space complexity: O(n)
 * Runtime: 41 ms, faster than 80.32% of Java online submissions
 * Memory Usage: 39.6 MB, less than 100.00% of Java online submissions
 */
public class MinimumCostToConnectSticks1167 {

  public static void main(String[] args) {
    MinimumCostToConnectSticks1167 problem = new MinimumCostToConnectSticks1167();
    problem.test();
  }

  private void test() {
    System.out.println(connectSticks(new int[]{2, 4, 3}));//14
    System.out.println(connectSticks(new int[]{1, 8, 3, 5}));//30
    System.out.println(connectSticks(new int[]{8, 4, 6, 12}));//58
    System.out.println(connectSticks(new int[]{20, 4, 8, 2}));//54
  }

  public int connectSticks(int[] sticks) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int len : sticks) {
      pq.add(len);
    }

    int cost = 0;

    while (pq.size() >= 2) {
      int a = pq.poll();
      int b = pq.poll();

      int c = a + b;
      if (!pq.isEmpty()) {
        pq.add(c);
      }

      cost += c;
    }

    return cost;
  }

}

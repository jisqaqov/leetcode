package amazon;

import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 1167. Minimum Cost to Connect Sticks
 * algorithm: Greedy
 * time complexity: O(nlog(n))
 * space complexity: O(n)
 * Runtime: 40 ms, faster than 93.53% of Java online submissions
 * Memory Usage: 39.7 MB, less than 100.00% of Java online submissions
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

    while (pq.size() > 1) {
      int len = pq.poll() + pq.poll();
      cost += len;

      if (!pq.isEmpty()) {
        pq.add(len);
      }
    }

    return cost;
  }

}

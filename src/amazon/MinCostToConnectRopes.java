package amazon;

import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 *
 * Given n ropes of different lengths, we need to connect these ropes into one rope. We can connect
 * only 2 ropes at a time. The cost required to connect 2 ropes is equal to sum of their lengths.
 * The length of this connected rope is also equal to the sum of their lengths. This process is
 * repeated until n ropes are connected into a single rope. Find the min possible cost required to
 * connect all ropes.
 *
 * Example 1:
 *
 * Input: ropes = [8, 4, 6, 12]
 *
 * Output: 58
 *
 * Explanation: The optimal way to connect ropes is as follows
 * 1. Connect the ropes of length 4 and 6 (cost is 10).
 * Ropes after connecting: [8, 10, 12]
 * 2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12]
 * 3. Connect the ropes of length 18 and 12 (cost is 30).
 * Total cost to connect the ropes is 10 + 18 + 30 = 58
 *
 * Example 2:
 *
 * Input: ropes = [20, 4, 8, 2]
 *
 * Output: 54
 *
 * algorithm: Greedy
 *
 * time complexity: O(nlog(n))
 *
 * space complexity: O(n)
 */
public class MinCostToConnectRopes {

  public static void main(String[] args) {
    MinCostToConnectRopes problem = new MinCostToConnectRopes();
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

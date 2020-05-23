package leetcode.p0012;

import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 1046. Last Stone Weight
 * algorithm: Greedy, Heap
 * time complexity: O(nlog(n))
 * space complexity: O(n)
 * Runtime: 1 ms, faster than 91.11% of Java online submissions
 * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions
 */
public class LastStoneWeight1046 {

  public int lastStoneWeight(int[] stones) {
    if (stones.length == 0) {
      return 0;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

    for (int stone : stones) {
      pq.add(stone);
    }

    while (pq.size() > 1) {
      int x = pq.poll();
      int y = pq.poll();

      if (x > y) {
        pq.add(x - y);
      }
    }

    return pq.isEmpty() ? 0 : pq.poll();
  }

}
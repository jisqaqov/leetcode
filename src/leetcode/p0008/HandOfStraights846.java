package leetcode.p0008;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author Jandos Iskakov
 * problem: 846. Hand of Straights
 * algorithm: Ordered Map, Heap
 * time complexity: O(nlog(n))
 * space complexity: O(n)
 * Runtime: 29 ms, faster than 80.31% of Java online submissions
 * Memory Usage: 40.4 MB, less than 87.50% of Java online submissions
 */
public class HandOfStraights846 {

  public static void main(String[] args) {
    HandOfStraights846 problem = new HandOfStraights846();
    problem.test();
  }

  private void test() {
    System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));//true
    System.out.println(isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));//false
  }

  public boolean isNStraightHand(int[] hand, int w) {
    TreeMap<Integer, Integer> tree = new TreeMap<>();

    for (int card : hand) {
      tree.put(card, tree.getOrDefault(card, 0) + 1);
    }

    while(!tree.isEmpty()) {
      int min = tree.firstKey();
      int size = min + w - 1;

      for (int card = min; card <= size; card++) {
        if (!tree.containsKey(card)) {
          return false;
        }

        tree.put(card, tree.get(card) - 1);
        if (tree.get(card) == 0) {
          tree.remove(card);
        }
      }
    }

    return true;
  }

  private static class V2 {

    public boolean isNStraightHand(int[] hand, int w) {
      PriorityQueue<Integer> pq = new PriorityQueue<>();

      Map<Integer, Integer> counter = new HashMap<>();
      for (int card : hand) {
        counter.put(card, counter.getOrDefault(card, 0) + 1);
      }

      for (int card : counter.keySet()) {
        pq.add(card);
        counter.put(card, counter.get(card) - 1);
      }

      int k = hand.length;
      for (; k > 0; k -= w) {
        int[] pulled = new int[w];

        int size = 0;
        for (; !pq.isEmpty() && size < w; size++) {
          pulled[size] = pq.poll();
          if (size > 0 && pulled[size - 1] + 1 != pulled[size]) {
            return false;
          }
        }

        if (size < w) {
          return false;
        }

        for (int card : pulled) {
          if (counter.get(card) > 0) {
            pq.add(card);

            counter.put(card, counter.get(card) - 1);
          }
        }
      }

      return k == 0;
    }

  }

}
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 692. Top K Frequent Words
 * algorithm: Heap, Hash Table
 * time complexity: O((N+K)logk)
 * space complexity: O(N)
 * Runtime: 39 ms, faster than 9.65% of Java online submissions for Top K Frequent Words.
 * Memory Usage: 38.7 MB, less than 67.86% of Java online submissions for Top K Frequent Words.
 */
public class TopKFrequentWords692 {

  public static void main(String[] args) {
    TopKFrequentWords692 problem = new TopKFrequentWords692();
    problem.test();
  }

  private void test() {
    String[] tc1a = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    System.out.println(topKFrequent(tc1a, 4));

    String[] tc2a = {"i", "love", "leetcode", "i", "love", "coding"};
    System.out.println(topKFrequent(tc2a, 2));
  }

  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> counter = new HashMap<>();
    for (String word : words) {
      counter.put(word, counter.getOrDefault(word, 0) + 1);
    }

    PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
      if (counter.get(o1).equals(counter.get(o2))) {
        return o2.compareTo(o1);
      }
      return counter.get(o1) - counter.get(o2);
    });

    for (String word : counter.keySet()) {
      pq.add(word);
      if (pq.size() > k) {
        pq.poll();
      }
    }

    List<String> solution = new ArrayList<>();
    while (!pq.isEmpty()) {
      solution.add(pq.poll());
    }

    Collections.reverse(solution);

    return solution;
  }

}

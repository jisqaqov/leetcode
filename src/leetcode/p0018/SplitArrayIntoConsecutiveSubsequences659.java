package leetcode.p0018;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 659. Split Array into Consecutive Subsequences
 * algorithm: Heap, Greedy, Hash Table
 * time complexity: O(nlog(n))
 * space complexity: O(n)
 * Runtime: 49 ms, faster than 19.60% of Java online submissions
 * Memory Usage: 42.6 MB, less than 66.67% of Java online submissions
 */
public class SplitArrayIntoConsecutiveSubsequences659 {

  public static void main(String[] args) {
    SplitArrayIntoConsecutiveSubsequences659 problem = new SplitArrayIntoConsecutiveSubsequences659();
    problem.test();
  }

  private void test() {
    System.out.println(isPossible(new int[]{1, 2, 3, 3, 4, 5}));//true
    System.out.println(isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));//true
    System.out.println(isPossible(new int[]{1, 2, 3, 4, 4, 5}));//false
    System.out.println(isPossible(new int[]{1, 3, 3, 4, 4, 7, 8, 8, 9, 10}));//false
  }

  public boolean isPossible(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    Set<Integer> used = new HashSet<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    int k = nums.length;

    while (k > 0) {
      for (int num : freq.keySet()) {
        if (freq.get(num) == 0 || used.contains(num)) {
          continue;
        }

        pq.add(num);
        used.add(num);

        freq.put(num, freq.get(num) - 1);
      }

      int size = 0;
      for (int last = pq.peek(); !pq.isEmpty(); size++) {
        int curr = pq.peek();

        if (freq.get(curr) < freq.get(last) || last + 1 < curr) {
          break;
        }

        used.remove(pq.poll());

        last = curr;
      }

      if (size < 3) {
        return false;
      }

      k -= size;
    }

    return true;
  }

}
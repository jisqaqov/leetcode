package leetcode.p0004;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 1296. Divide Array in Sets of K Consecutive Numbers
 * algorithm: Sort, Greedy
 * time complexity: O(nlog(n))
 * space complexity: O(n)
 * Runtime: 88 ms, faster than 58.61% of Java online submissions
 * Memory Usage: 51.4 MB, less than 100.00% of Java online submissions
 */
public class DivideArrayInSetsOfKConsecutiveNumbers1296 {

  public static void main(String[] args) {
    DivideArrayInSetsOfKConsecutiveNumbers1296 problem = new DivideArrayInSetsOfKConsecutiveNumbers1296();
    problem.test();
  }

  private void test() {
    System.out.println(isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4));
  }

  public boolean isPossibleDivide(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int val : nums) {
      map.put(val, map.getOrDefault(val, 0) + 1);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    addNumbers(pq, map, new ArrayList<>(map.keySet()));

    for (int n = nums.length; n > 0; n -= k) {
      int last = -1;
      int size = k;

      List<Integer> used = new ArrayList<>();

      while (size > 0 && !pq.isEmpty() && (last == -1 || last + 1 == pq.peek())) {
        int val = pq.poll();

        used.add(val);
        last = val;

        size--;
      }

      if (size > 0) {
        return false;
      }

      addNumbers(pq, map, used);
    }

    return true;
  }

  private void addNumbers(PriorityQueue<Integer> pq, Map<Integer, Integer> map, List<Integer> list) {
    for (int val : list) {
      if (map.get(val) > 0) {
        pq.add(val);
        map.put(val, map.get(val) - 1);
      }
    }
  }

}
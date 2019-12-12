package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 40. Combination Sum II
 * algorithm: Backtracking
 * time complexity:
 * space complexity: O(N)
 * Runtime: 5 ms, faster than 56.43% of Java online submissions for Combination Sum II.
 * Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Combination Sum II.
 */
public class CombinationSumII40 {

  public static void main(String[] args) {
    CombinationSumII40 problem = new CombinationSumII40();
    problem.test();
  }

  private void test() {
    System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> output = new ArrayList<>();

    Map<Integer, Integer> map = new HashMap<>();
    for (int candidate : candidates) {
      map.put(candidate, map.getOrDefault(candidate, 0) + 1);
    }

    List<Integer> values = new ArrayList<>(map.keySet());
    Collections.sort(values);

    helper(map, values, 0, output, target, new ArrayDeque<>());

    return output;
  }

  private void helper(Map<Integer, Integer> map, List<Integer> candidates, int index,
    List<List<Integer>> output, int target, Deque<Integer> values) {
    if (target == 0) {
      output.add(new ArrayList<>(values));
      return;
    }

    for (int i = index; i < candidates.size() && candidates.get(i) <= target; i++) {
      if (map.get(candidates.get(i)) == 0) {
        continue;
      }

      values.addLast(candidates.get(i));
      map.put(candidates.get(i), map.get(candidates.get(i)) - 1);

      helper(map, candidates, i, output, target - candidates.get(i), values);

      values.removeLast();
      map.put(candidates.get(i), map.get(candidates.get(i)) + 1);
    }
  }

}

package leetcode.p0003;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 40. Combination Sum II
 * algorithm: Backtracking
 * time complexity:
 * space complexity: O(N)
 * Runtime: 3 ms, faster than 82.21% of Java online submissions for Combination Sum II.
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
    Arrays.sort(candidates);

    List<List<Integer>> output = new ArrayList<>();

    helper(candidates, 0, output, target, new ArrayDeque<>());

    return output;
  }

  private void helper(int[] candidates, int index, List<List<Integer>> output, int target, Deque<Integer> values) {
    if (target == 0) {
      output.add(new ArrayList<>(values));
      return;
    }

    for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
      if (i > index && candidates[i] == candidates[i - 1]) {
        continue;
      }

      values.addLast(candidates[i]);

      helper(candidates, i + 1, output, target - candidates[i], values);

      values.removeLast();
    }
  }

}

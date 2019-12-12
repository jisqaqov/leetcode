package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 39. Combination Sum
 * algorithm: Backtracking
 * Runtime: 2 ms, faster than 99.93% of Java online submissions for Combination Sum.
 * Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Combination Sum.
 */
public class CombinationSum39 {

  public static void main(String[] args) {
    CombinationSum39 problem = new CombinationSum39();
    problem.test();
  }

  private void test() {
    System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> output = new ArrayList<>();

    Arrays.sort(candidates);
    helper(candidates, 0, output, target, new ArrayList<>());

    return output;
  }

  private void helper(int[] candidates, int index, List<List<Integer>> output,
    int target, List<Integer> values) {

    for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
      values.add(candidates[i]);

      if (candidates[i] == target) {
        output.add(new ArrayList<>(values));
      } else {
        helper(candidates, i, output, target - candidates[i], values);
      }

      values.remove(values.size() - 1);
    }
  }

}

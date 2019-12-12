package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
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
    for (int i = index; i < candidates.length; i++) {
      if (candidates[i] > target) {
        continue;
      }

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
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
    System.out.println(combinationSum(new int[]{2,3,5}, 8));

  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> output = new ArrayList<>();
    comb(candidates, 0, target, new ArrayList<>(), output);
    return output;
  }

  private void comb(int[] candidates, int index, int target, List<Integer> list,
    List<List<Integer>> output) {

    if (target == 0) {
      output.add(new ArrayList<>(list));
      return;
    }

    for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
      list.add(candidates[i]);

      comb(candidates, i, target - candidates[i], list, output);

      list.remove(list.size() - 1);
    }
  }

}
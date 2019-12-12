package prep;

import java.util.ArrayList;
import java.util.List;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(permute(new int[]{1, 2, 3}));
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();

    boolean[] placed = new boolean[nums.length];
    List<Integer> values = new ArrayList<>();

    helper(nums, placed, values, output, 0);

    return output;
  }

  private void helper(int[] nums, boolean[] used, List<Integer> values,
    List<List<Integer>> output, int index) {
    if (index == nums.length) {
      output.add(new ArrayList<>(values));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }

      used[i] = true;
      values.add(nums[i]);

      helper(nums, used, values, output, index + 1);

      used[i] = false;
      values.remove(values.size() - 1);
    }
  }

}
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 46. Permutations
 * algorithm: Backtracking
 * time complexity: O((N!)
 * space complexity: O(N!)
 * Runtime: 1 ms, faster than 97.75% of Java online submissions for Permutations.
 * Memory Usage: 36.6 MB, less than 97.16% of Java online submissions for Permutations.
 */
public class Permutations46 {

  public static void main(String[] args) {
    Permutations46 problem = new Permutations46();
    problem.test();
  }

  private void test() {
    System.out.println(permute(new int[]{1, 2, 3}));
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();

    int[] values = new int[nums.length];
    boolean[] used = new boolean[nums.length];

    permute(nums, values, 0, used, output);

    return output;
  }

  private void permute(int[] nums, int[] values, int index, boolean[] used,
    List<List<Integer>> list) {
    if (index == nums.length) {
      list.add(new ArrayList<>());

      for (int number : values) {
        list.get(list.size() - 1).add(number);
      }

      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }

      values[index] = nums[i];
      used[i] = true;

      permute(nums, values, index + 1, used, list);

      used[i] = false;
    }
  }

}

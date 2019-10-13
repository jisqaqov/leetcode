package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 46. Permutations
 * algorithm: Backtracking
 * time complexity: O()
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 97.75% of Java online submissions for Permutations.
 * Memory Usage: 36.6 MB, less than 97.16% of Java online submissions for Permutations.
 */
public class Permutations46 {

  public static void main(String[] args) {
    Permutations46 problem = new Permutations46();
    problem.test();
  }

  private void test() {
    int[] t1a = {1,2,3};
    System.out.println(permute(t1a));
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();

    int n = nums.length;
    if (n == 0) {
      return list;
    }

    int[] p = new int[n];
    boolean[] used = new boolean[n];

    permute(nums, p, 0, used, list);

    return list;
  }

  private void permute(int[] nums, int[] p,
    int index, boolean[] used,
    List<List<Integer>> list) {
    if (index == nums.length) {
      list.add(new ArrayList<>());

      for (int number : p) {
        list.get(list.size() - 1).add(number);
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }

      p[index] = nums[i];

      used[i] = true;
      permute(nums, p, index + 1, used, list);
      used[i] = false;
    }
  }



}

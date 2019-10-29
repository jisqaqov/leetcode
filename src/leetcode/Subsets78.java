package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 78. Subsets
 * algorithm: Backtracking
 * time complexity: O()
 * space complexity: O()
 * Runtime: 1 ms, faster than 41.15% of Java online submissions for Subsets.
 * Memory Usage: 36.6 MB, less than 99.18% of Java online submissions for Subsets.
 */
public class Subsets78 {

  public static void main(String[] args) {
    Subsets78 problem = new Subsets78();
    problem.test();
  }

  private void test() {
    System.out.println(subsets(new int[]{1,2,3}));
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> solution = new ArrayList<>();

    for (int l = 0; l <= nums.length; l++) {
      subsets(nums, 0, 0, l, solution, new LinkedList<>());
    }

    return solution;
  }

  private void subsets(int[] nums, int index, int k, int n, List<List<Integer>> solution, LinkedList<Integer> list) {
    if (k == n) {
      solution.add(new ArrayList<>(list));
      return;
    }

    for (int i = index; i < nums.length; i++) {
      list.add(nums[i]);
      subsets(nums, i + 1, k + 1, n, solution, list);
      list.removeLast();
    }
  }

}

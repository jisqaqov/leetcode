package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 78. Subsets
 * algorithm: Backtracking
 * time complexity: O(N*2^N)
 * space complexity: O(2^N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 37.1 MB, less than 99.18% of Java online submissions
 */
public class Subsets78 {

  public static void main(String[] args) {
    Subsets78 problem = new Subsets78();
    problem.test();
  }

  private void test() {
    System.out.println(subsets(new int[]{1, 2, 3}));
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    subsets(nums, 0, new ArrayList<>(), output);
    return output;
  }

  private void subsets(int[] nums, int index, List<Integer> list, List<List<Integer>> output) {
    output.add(new ArrayList<>(list));

    for (int i = index; i < nums.length; i++) {
      list.add(nums[i]);

      subsets(nums, i + 1, list, output);

      list.remove(list.size() - 1);
    }
  }

  private static class V2 {

    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> solution = new ArrayList<>();

      for (int l = 0; l <= nums.length; l++) {
        subsets(nums, 0, 0, l, solution, new ArrayList<>());
      }

      return solution;
    }

    private void subsets(int[] nums, int index, int k, int n, List<List<Integer>> output,
      List<Integer> list) {
      if (k == n) {
        output.add(new ArrayList<>(list));
        return;
      }

      for (int i = index; i < nums.length; i++) {
        list.add(nums[i]);
        subsets(nums, i + 1, k + 1, n, output, list);
        list.remove(list.size() - 1);
      }
    }
  }


}

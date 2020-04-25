package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 491. Increasing Subsequences
 * algorithm: Backtracking
 * time complexity:
 * space complexity:
 * Runtime: 4 ms, faster than 96.93% of Java online submissions
 * Memory Usage: 45.9 MB, less than 100.00% of Java online submissions
 */
public class IncreasingSubsequences491 {

  public static void main(String[] args) {
    IncreasingSubsequences491 problem = new IncreasingSubsequences491();
    problem.test();
  }

  private void test() {
    System.out.println(findSubsequences(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1}));
  }

  public List<List<Integer>> findSubsequences(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();

    helper(nums, 0, new LinkedList<>(), output);

    return output;
  }

  private void helper(int[] nums, int index, LinkedList<Integer> list, List<List<Integer>> output) {
    if (list.size() > 1) {
      output.add(new ArrayList<>(list));
    }

    Set<Integer> used = new HashSet<>();
    for (int i = index; i < nums.length; i++) {
      if (used.contains(nums[i])) {
        continue;
      }

      if (list.isEmpty() || list.peekLast() <= nums[i]) {
        used.add(nums[i]);
        list.add(nums[i]);

        helper(nums, i + 1, list, output);

        list.removeLast();
      }
    }
  }

}
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 18. 4Sum
 * algorithm: Two Pointers
 * time complexity: O(n^3)
 * space complexity: O(1)
 * Runtime: 14 ms, faster than 68.10% of Java online submissions
 * Memory Usage: 41.5 MB, less than 44.93% of Java online submissions
 */
public class FourSum18 {

  public static void main(String[] args) {
    FourSum18 problem = new FourSum18();
    problem.test();
  }

  private void test() {
    System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    System.out.println(fourSum(new int[]{0, 0, 0, 0}, 0));
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> output = new ArrayList<>();

    Arrays.sort(nums);

    for (int i = 0; i <= nums.length - 4; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      List<int[]> list = threeSum(nums, i + 1, target - nums[i]);
      for (int[] sub : list) {
        output.add(Arrays.asList(nums[i], sub[0], sub[1], sub[2]));
      }
    }

    return output;
  }

  private List<int[]> threeSum(int[] nums, int idx, int target) {
    List<int[]> output = new ArrayList<>();

    for (int i = idx; i <= nums.length - 3; i++) {
      if (i > idx && nums[i] == nums[i - 1]) {
        continue;
      }

      int p = target - nums[i];

      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        if (nums[j] + nums[k] == p) {
          output.add(new int[]{nums[i], nums[j], nums[k]});

          j++;
          k--;

          while (j < k && nums[j] == nums[j - 1]) {
            j++;
          }

          while (j < k && nums[k] == nums[k + 1]) {
            k--;
          }

        } else if (nums[j] + nums[k] < p) {
          j++;
        } else {
          k--;
        }
      }
    }

    return output;
  }

}
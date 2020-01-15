package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 15. 3Sum
 * algorithm: Two Pointers
 * time complexity: O(N^2)
 * space complexity: O(1)
 * Runtime: 32 ms, faster than 64.52% of Java online submissions
 * Memory Usage: 49 MB, less than 55.12% of Java online submissions
 */
public class ThreeSum15 {

  public static void main(String[] args) {
    ThreeSum15 problem = new ThreeSum15();

    problem.test();
  }

  private void test() {
    System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
  }

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> output = new ArrayList<>();

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int target = -nums[i];
      int j = i + 1, k = nums.length - 1;

      while (j < k) {
        if (nums[j] + nums[k] == target) {
          output.add(Arrays.asList(nums[i], nums[j], nums[k]));

          j++;
          k--;

          while (j < k && nums[j] == nums[j - 1]) j++;
          while (j < k && nums[k] == nums[k + 1]) k--;
        } else if (nums[j] + nums[k] > target) {
          k--;
        } else {
          j++;
        }
      }
    }

    return output;
  }



}
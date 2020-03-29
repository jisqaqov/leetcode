package leetcode;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 268. Missing Number
 * algorithm: Array
 * time complexity: O(n)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 38.18% of Java online submissions
 * Memory Usage: 40.8 MB, less than 89.47% of Java online submissions
 */
public class MissingNumber268 {

  public static void main(String[] args) {
    MissingNumber268 problem = new MissingNumber268();
    problem.test();
  }

  private void test() {
    System.out.println(missingNumber(new int[]{3, 0, 1}));
    System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
  }

  public int missingNumber(int[] nums) {
    int s = 0;
    for (int val = 1; val <= nums.length; val++) {
      s += val;
    }

    for (int i = 0; i < nums.length; i++) {
      s -= nums[i];
    }

    return s;
  }

  private static class V2 {

    public int missingNumber(int[] nums) {
      int n = nums.length;

      for (int i = 0; i < nums.length; i++) {
        while (nums[i] < n && nums[i] != nums[nums[i]]) {
          swap(nums, i, nums[i]);
        }
      }

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i) {
          return i;
        }
      }

      return n;
    }

    private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }

  }

  private static class V3 {

    public int missingNumber(int[] nums) {
      Arrays.sort(nums);

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i) {
          return i;
        }
      }

      return nums.length;
    }


  }

}
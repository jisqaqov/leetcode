package leetcode.p0013;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 283. Move Zeroes
 * algorithm: Two Pointers
 * time complexity: O(n)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 38.2 MB, less than 81.12% of Java online submissions
 */
public class MoveZeros283 {

  public static void main(String[] args) {
    MoveZeros283 problem = new MoveZeros283();
    problem.test();
  }

  private void test() {
    int[] tc1a = {0, 1, 0, 3, 12};
    moveZeroes(tc1a);
    TestUtils.printArray(tc1a);
  }

  public void moveZeroes(int[] nums) {
    int p = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        if (i != p) {
          nums[p] = nums[i];
        }

        p++;
      }
    }

    while (p < nums.length) {
      nums[p++] = 0;
    }
  }

  private static class V2 {

    public void moveZeroes(int[] nums) {
      int j = 0;

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          if (i != j) {
            swap(i, j, nums);
          }

          j++;
        }
      }
    }

    private void swap(int i, int j, int[] nums) {
      int temp = nums[j];
      nums[j] = nums[i];
      nums[i] = temp;
    }
  }

}

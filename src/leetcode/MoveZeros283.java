package leetcode;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 283. Move Zeroes
 * algorithm: Two Pointers
 * time complexity: O(n)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
 * Memory Usage: 38.2 MB, less than 81.12% of Java online submissions for Move Zeroes.
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

    System.out.println("v2:");
    int[] tc2a = {0, 1, 0, 3, 12};
    new V2().moveZeroes(tc2a);

    TestUtils.printArray(tc2a);

    System.out.println("v3:");
    int[] tc3a = {0, 1, 0, 3, 12};
    new V3().moveZeroes(tc3a);

    TestUtils.printArray(tc3a);
  }

  public void moveZeroes(int[] nums) {
    int zeros = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeros++;
      } else if (zeros > 0) {
        nums[i - zeros] = nums[i];
        nums[i] = 0;
      }
    }
  }

  private static class V2 {
    public void moveZeroes(int[] nums) {
      int j = 0;

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          if (i != j) {
            nums[j] = nums[i];
          }

          j++;
        }
      }

      while (j < nums.length) {
        nums[j++] = 0;
      }
    }
  }

  private static class V3 {
    public void moveZeroes(int[] nums) {
      int j = 0;

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          if (i != j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
          }

          j++;
        }
      }
    }
  }

}

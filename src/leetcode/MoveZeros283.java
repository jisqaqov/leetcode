package leetcode;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 283. Move Zeroes
 * algorithm: Two Pointers
 * time complexity: O(n)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
 * Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Move Zeroes.
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
    moveZeroes(tc2a);

    TestUtils.printArray(tc2a);
  }

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

}

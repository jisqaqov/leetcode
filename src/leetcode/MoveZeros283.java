package leetcode;

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

  public void moveZeroes(int[] nums) {
    int j = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;

        j++;
      }
    }
  }

}

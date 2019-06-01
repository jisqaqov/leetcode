package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 283. Move Zeroes
 * algorithm: Two Pointer Technique
 * time complexity: O(n)
 */
public class MoveZeros283 {

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;

        while (i < nums.length) {
            while (i < nums.length && nums[i] != 0)
                i++;

            if (i == nums.length)
                break;

            if (j < i)
                j = i + 1;

            while (j < nums.length && nums[j] == 0)
                j++;

            if (j == nums.length)
                break;

            if (nums[i] == 0 && nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;

                j++;
                i++;
            }
        }
    }

}

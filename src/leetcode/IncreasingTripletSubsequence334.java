package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 334. Increasing Triplet Subsequence
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 39.2 MB, less than 95.35% of Java online submissions
 */
public class IncreasingTripletSubsequence334 {

  public boolean increasingTriplet(int[] nums) {
    if (nums.length < 3) {
      return false;
    }

    int num1 = Integer.MAX_VALUE;
    int num2 = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= num1) {
        num1 = nums[i];
      } else if (nums[i] <= num2) {
        num2 = nums[i];
      } else if (nums[i] > num2) {
        return true;
      }
    }

    return false;
  }

}
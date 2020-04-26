package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 674. Longest Continuous Increasing Subsequence
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 99.49% of Java online submissions
 * Memory Usage: 40.2 MB, less than 91.89% of Java online submissions
 */
public class LongestContinuousIncreasingSubsequence674 {

  public int findLengthOfLCIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int maxLen = 1;
    int len = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        len++;
      } else {
        len = 1;
      }

      maxLen = Math.max(maxLen, len);
    }

    return maxLen;
  }

}
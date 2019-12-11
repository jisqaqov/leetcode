package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 209. Minimum Size Subarray Sum
 * algorithm: Two Pointers
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 99.99% of Java online submissions for Minimum Size Subarray Sum.
 * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Minimum Size Subarray Sum.
 */
public class MinimumSizeSubarraySum209 {

  public static void main(String[] args) {
    MinimumSizeSubarraySum209 problem = new MinimumSizeSubarraySum209();
    problem.test();
  }

  private void test() {
    int[] tc1a = {2, 3, 1, 2, 4, 3};
    System.out.println(minSubArrayLen(7, tc1a));//2

    int[] tc2a = {1, 2, 3, 4, 5};
    System.out.println(minSubArrayLen(11, tc2a));//3

  }

  public int minSubArrayLen(int s, int[] nums) {
    int minLen = 0;

    int p = 0;
    int start = 0;

    for (int i = 0; i < nums.length; i++) {
      p += nums[i];

      while (start <= i && p >= s) {
        int len = i - start + 1;

        if (minLen == 0) {
          minLen = len;
        } else {
          minLen = Math.min(minLen, len);
        }

        p -= nums[start];
        start++;
      }
    }

    return minLen;
  }

}

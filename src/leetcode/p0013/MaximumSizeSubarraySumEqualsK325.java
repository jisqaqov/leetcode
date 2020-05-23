package leetcode.p0013;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 325. Maximum Size Subarray Sum Equals k
 * algorithm: Hash Table
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 14 ms, faster than 23.35% of Java online submissions for Maximum Size Subarray Sum Equals k.
 * Memory Usage: 38.5 MB, less than 100.00% of Java online submissions for Maximum Size Subarray Sum Equals k.
 */
public class MaximumSizeSubarraySumEqualsK325 {

  public static void main(String[] args) {
    MaximumSizeSubarraySumEqualsK325 problem = new MaximumSizeSubarraySumEqualsK325();
    problem.test();
  }

  private void test() {
    int[] tc1a = {1, -1, 5, -2, 3};
    System.out.println(maxSubArrayLen(tc1a, 3));//4

    int[] tc2a = {-2, -1, 2, 1};
    System.out.println(maxSubArrayLen(tc2a, 1));//2

    int[] tc3a = {0};
    System.out.println(maxSubArrayLen(tc3a, 0));//0
  }

  public int maxSubArrayLen(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    int prefix = 0;
    int maxLen = 0;

    for (int i = 0; i < nums.length; i++) {
      prefix += nums[i];

      if (!map.containsKey(prefix)) {
        map.put(prefix, i);
      }

      if (prefix == k) {
        maxLen = i + 1;
      } else if (map.containsKey(prefix - k)) {
        maxLen = Math.max(maxLen, i - map.get(prefix - k));
      }
    }

    return maxLen;
  }

}

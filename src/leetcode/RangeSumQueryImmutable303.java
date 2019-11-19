package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 303. Range Sum Query - Immutable
 * algorithm: DP
 * time complexity: O(1)
 * space complexity: O(n)
 * Runtime: 9 ms, faster than 99.06% of Java online submissions for Range Sum Query - Immutable.
 * Memory Usage: 43.4 MB, less than 19.51% of Java online submissions for Range Sum Query - Immutable.
 */
public class RangeSumQueryImmutable303 {

  class NumArray {
    int[] prefix;

    public NumArray(int[] nums) {
      this.prefix = new int[nums.length + 1];

      for (int i = 1; i <= nums.length; i++) {
        prefix[i] = prefix[i - 1] + nums[i - 1];
      }
    }

    public int sumRange(int i, int j) {
      return prefix[j + 1] - prefix[i];
    }
  }

}

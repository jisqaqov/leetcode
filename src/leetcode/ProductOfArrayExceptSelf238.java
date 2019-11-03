package leetcode;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 238. Product of Array Except Self
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
 * Memory Usage: 41.5 MB, less than 100.00% of Java online submissions for Product of Array Except Self.
 */
public class ProductOfArrayExceptSelf238 {

  public static void main(String[] args) {
    ProductOfArrayExceptSelf238 problem = new ProductOfArrayExceptSelf238();
    problem.test();
  }

  private void test() {
    int[] tc1a = {1, 2, 3, 4};
    TestUtils.printArray(productExceptSelf(tc1a));

    int[] tc2a = {2, 3};
    TestUtils.printArray(productExceptSelf(tc2a));
  }

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] output = new int[n];

    output[n - 1] = nums[n - 1];

    for (int i = n - 2; i >= 0; i--) {
      output[i] = output[i + 1] * nums[i];
    }

    int left = 1;
    for (int i = 0; i < n; i++) {
      int right = i < n - 1 ? output[i + 1] : 1;
      output[i] = left * right;

      left = left * nums[i];
    }

    return output;
  }

}

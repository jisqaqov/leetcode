package leetcode.p0017;

/**
 * @author Jandos Iskakov
 * problem: 189. Rotate Array
 * algorithm: String
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 39.5 MB, less than 5.77%
 */
public class RotateArray189 {

  public void rotate(int[] nums, int k) {
    int n = nums.length;

    k %= n;

    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
  }

  private void reverse(int[] nums, int i, int j) {
    while (i < j) {
      int temp = nums[j];
      nums[j] = nums[i];
      nums[i] = temp;

      i++;
      j--;
    }
  }

}
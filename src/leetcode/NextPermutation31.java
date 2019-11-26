package leetcode;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 31. Next Permutation
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 89.95% of Java online submissions for Next Permutation.
 * Memory Usage: 41.5 MB, less than 30.00% of Java online submissions for Next Permutation.
 */
public class NextPermutation31 {

  public static void main(String[] args) {
    NextPermutation31 problem = new NextPermutation31();
    problem.test();
  }

  private void test() {
    int[] tc1a = {6, 2, 1, 5, 4, 3, 0};
    nextPermutation(tc1a);
    TestUtils.printArray(tc1a);

    int[] tc2a = {1, 2, 3};
    nextPermutation(tc2a);
    TestUtils.printArray(tc2a);

    int[] tc3a = {1, 1, 5};
    nextPermutation(tc3a);
    TestUtils.printArray(tc3a);

    int[] tc4a = {3, 2, 1};
    nextPermutation(tc4a);
    TestUtils.printArray(tc4a);

    int[] tc5a = {2, 3, 1, 3, 3};
    nextPermutation(tc5a);
    TestUtils.printArray(tc5a);
  }

  public void nextPermutation(int[] nums) {
    if (nums.length <= 1) {
      return;
    }

    int d = -1;

    for (int i = nums.length - 1; i > 0; i--) {
      if (nums[i - 1] < nums[i]) {
        d = i - 1;
        break;
      }
    }

    if (d >= 0) {
      int maxIndex = d + 1;

      for (int i = d + 1; i < nums.length; i++) {
        if (nums[i] > nums[d] && nums[i] <= nums[maxIndex]) {
          maxIndex = i;
        }
      }

      swap(nums, d, maxIndex);
    }

    reverse(nums, d + 1, nums.length - 1);
  }

  private void reverse(int[] a, int l, int r) {
    while (l < r) {
      swap(a, l, r);

      l++;
      r--;
    }
  }

  private void swap(int[] a, int i, int j) {
    int temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }

}

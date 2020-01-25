package leetcode;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 31. Next Permutation
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 39.6 MB, less than 50.00% of Java online submissions
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
    if (nums.length == 0) {
      return;
    }

    int p = nums.length - 2;
    while (p >= 0 && nums[p] >= nums[p + 1]) {
      p--;
    }

    if (p == -1) {
      reverse(nums, 0);
      return;
    }

    int maxIndex = nums.length - 1;

    for (; maxIndex > p; maxIndex--) {
      if (nums[maxIndex] > nums[p]) {
        break;
      }
    }

    swap(nums, p, maxIndex);

    reverse(nums, p + 1);
  }

  private void reverse(int[] nums, int index) {
    int l = index;
    int r = nums.length - 1;

    while (l < r) {
      swap(nums, l, r);

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

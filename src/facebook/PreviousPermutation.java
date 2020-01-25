package facebook;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: variation of 31. Next Permutation
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(1)
 */
public class PreviousPermutation {

  public static void main(String[] args) {
    PreviousPermutation problem = new PreviousPermutation();
    problem.test();
  }

  private void test() {
    int[] tc1a = {1, 3, 2};
    previousPermutation(tc1a);
    TestUtils.printArray(tc1a);

    int[] tc2a = {3, 2, 1};
    previousPermutation(tc2a);
    TestUtils.printArray(tc2a);

    int[] tc3a = {1, 1, 5};
    previousPermutation(tc3a);
    TestUtils.printArray(tc3a);

    int[] tc4a = {1, 4, 2, 0, 7, 6, 9};
    previousPermutation(tc4a);
    TestUtils.printArray(tc4a);
  }

  public void previousPermutation(int[] nums) {
    if (nums.length == 0) {
      return;
    }

    int p = nums.length - 2;
    while (p >= 0 && nums[p] <= nums[p + 1]) {
      p--;
    }

    if (p == -1) {
      reverse(0, nums);
      return;
    }

    int minIndex = nums.length - 1;
    for (; minIndex > p; minIndex--) {
      if (nums[minIndex] < nums[p]) {
        break;
      }
    }

    swap(minIndex, p, nums);
    reverse(p + 1, nums);
  }

  private void reverse(int index, int[] nums) {
    int l = index;
    int r = nums.length - 1;

    while (l < r) {
      swap(l, r, nums);

      l++;
      r--;
    }
  }

  private void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
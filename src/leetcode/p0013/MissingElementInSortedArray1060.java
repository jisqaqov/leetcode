package leetcode.p0013;

/**
 * @author Jandos Iskakov
 * problem: 1060. Missing Element in Sorted Array
 * algorithm: Binary Search
 * time complexity: O(log(N))
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Element in Sorted Array.
 * Memory Usage: 48.5 MB, less than 100.00% of Java online submissions for Missing Element in Sorted Array.
 */
public class MissingElementInSortedArray1060 {

  public static void main(String[] args) {
    MissingElementInSortedArray1060 problem = new MissingElementInSortedArray1060();
    problem.test();
  }

  private void test() {
    int[] tc1a = {4, 7, 9, 10};
    int[] tc2a = {4, 7, 9, 10};
    int[] tc3a = {1, 2, 4};
    int[] tc4a = {1, 4};

    System.out.println(missingElement(tc1a, 1));//5
    System.out.println(missingElement(tc2a, 3));//8
    System.out.println(missingElement(tc3a, 3));//6
    System.out.println(missingElement(tc4a, 3));//5
  }

  public int missingElement(int[] nums, int k) {
    int left = 0;
    int right = nums.length - 1;

    // number is beyond the array
    if (nums[right] - nums[left] - right < k) {
      return nums[left] + k + right;
    }

    while (left + 1 < right) {
      int middle = left + (right - left) / 2;

      int missing = nums[middle] - nums[left] - middle + left;
      if (missing >= k) {
        right = middle;
      } else {
        left = middle;
        k -= missing;
      }
    }

    return nums[left] + k;
  }

}

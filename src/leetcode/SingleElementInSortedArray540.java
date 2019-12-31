package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 540. Single Element in a Sorted Array
 * algorithm: Binary Search
 * time complexity: O(log(N))
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions
 */
public class SingleElementInSortedArray540 {

  public static void main(String[] args) {
    SingleElementInSortedArray540 problem = new SingleElementInSortedArray540();
    problem.test();
  }

  private void test() {
    System.out.println(singleNonDuplicate(new int[]{1, 2, 2}));//1
    System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));//2
    System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));//10
    System.out.println(singleNonDuplicate(new int[]{1, 1, 2}));//2
  }

  public int singleNonDuplicate(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
      int mid = l + (r - l) / 2;

      if (mid == 0 || mid == nums.length - 1 ||
        (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])) {
        return nums[mid];
      }

      if (nums[mid] == nums[mid - 1]) {
        mid--;
      }

      int len = r - mid + 1;
      if (len % 2 > 0) {
        l = mid + 2;
      } else {
        r = mid - 1;
      }
    }

    return -1;
  }

}

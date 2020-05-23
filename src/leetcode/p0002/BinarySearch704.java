package leetcode.p0002;

/**
 * @author Jandos Iskakov
 * problem: 704. Binary Search
 * algorithm: Binary Search
 * time complexity: O(log(N))
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 38.9 MB, less than 100.00% of Java online submissions
 */
public class BinarySearch704 {

  public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
      int mid = l + (r - l) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      if (nums[mid] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }

    return -1;
  }

}

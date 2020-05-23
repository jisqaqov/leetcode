package leetcode.p0006;

/**
 * @author Jandos Iskakov
 * problem: 153. Find Minimum in Rotated Sorted Array
 * algorithm: Binary Search
 * time complexity: O(log(N))
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
 * Memory Usage: 38.5 MB, less than 79.54% of Java online submissions for Find Minimum in Rotated Sorted Array.
 */
public class FindMinimumInRotatedSortedArray153 {

  public static void main(String[] args) {
    FindMinimumInRotatedSortedArray153 solution = new FindMinimumInRotatedSortedArray153();
    solution.test();
  }

  public void test() {
    System.out.println(findMin(new int[]{5}));
    System.out.println(findMin(new int[]{1, 2}));
    System.out.println(findMin(new int[]{3, 1, 2}));
    System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
    System.out.println(findMin(new int[]{3, 4, 5, 2}));
    System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    System.out.println(findMin(new int[]{4, 5, 6, 7, 1}));
    System.out.println(findMin(new int[]{1, 2, 3, 4, 5, 6}));
  }

  public int findMin(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    while (l < r) {
      int mid = l + (r - l) / 2;

      if (nums[mid] < nums[r]) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }

    return nums[r];
  }

}

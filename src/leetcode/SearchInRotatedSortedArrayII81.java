package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 81. Search in Rotated Sorted Array II
 * algorithm: Binary Search
 * time complexity: O(nlog(n)) on average, O(n) worst case
 * space complexity: O(1)
 * Runtime: 2 ms, faster than 25.74% of Java online submissions
 * Memory Usage: 46.9 MB, less than 5.63% of Java online submissions
 */
public class SearchInRotatedSortedArrayII81 {

  public static void main(String[] args) {
    SearchInRotatedSortedArrayII81 problem =
      new SearchInRotatedSortedArrayII81();
    problem.test();
  }

  private void test() {
    System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));//true
    System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));//false
  }

  private boolean search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
      int mid = l + (r - l) / 2;

      if (nums[mid] == target) {
        return true;
      }

      if (nums[mid] < nums[r]) {
        if (target >= nums[mid] && target <= nums[r]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      } else if (nums[mid] > nums[r]) {
        if (target >= nums[l] && target <= nums[mid]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      } else {
        if (nums[mid] == nums[r]) {
          r--;
        }
        if (nums[mid] == nums[l]) {
          l++;
        }
      }
    }

    return false;
  }

}

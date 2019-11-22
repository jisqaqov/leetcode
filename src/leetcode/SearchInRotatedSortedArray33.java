package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 33. Search in Rotated Sorted Array
 * time complexity: O(log(n))
 * space complexity: O(1)
 * algorithm: Binary Search
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
 * Memory Usage: 40.3 MB, less than 9.44% of Java online submissions for Search in Rotated Sorted Array.
 */
public class SearchInRotatedSortedArray33 {

  public static void main(String[] args) {
    SearchInRotatedSortedArray33 solution = new SearchInRotatedSortedArray33();
    solution.test();
  }

  public void test() {
    System.out.println(search(new int[]{3, 1}, 3));
    System.out.println(search(new int[]{3, 1}, 1));
    System.out.println(search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2, 3}, 0));
    System.out.println(search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2, 3}, 3));

    V2 v2 = new V2();

    System.out.println("v2:");
    System.out.println(v2.search(new int[]{3, 1}, 3));
    System.out.println(v2.search(new int[]{3, 1}, 1));
    System.out.println(v2.search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2, 3}, 0));
    System.out.println(v2.search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2, 3}, 3));
  }

  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }

    int pivot = findRotateIndex(nums);

    int l = 0;
    int r = nums.length - 1;

    if (pivot > 0) {
      if (target < nums[0]) {
        l = pivot;
      } else {
        r = pivot - 1;
      }
    }

    return search(l, r, nums, target);
  }

  private int search(int l, int r, int[] nums, int target) {
    while (l <= r) {
      int m = l + (r - l) / 2;

      if (nums[m] == target) {
        return m;
      }

      if (nums[m] < target) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }

    return -1;
  }

  private int findRotateIndex(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    while (l < r) {
      int m = l + (r - l) / 2;

      if (nums[m] < nums[r]) {
        r = m;
      } else {
        l = m + 1;
      }
    }

    return l;
  }

  /**
   * One pass solution
   */
  private static class V2 {
    public int search(int[] nums, int target) {
      if (nums.length == 0) {
        return -1;
      }

      int l = 0;
      int r = nums.length - 1;

      while (l <= r) {
        int mid = l + (r - l) / 2;

        if (nums[mid] == target) {
          return mid;
        }

        if (nums[l] <= nums[mid]) {
          if (target >= nums[l] && target <= nums[mid]) {
            r = mid - 1;
          } else {
            l = mid + 1;
          }
        } else {
          if (target >= nums[mid] && target <= nums[r]) {
            l = mid + 1;
          } else {
            r = mid - 1;
          }
        }
      }

      return -1;
    }
  }

}


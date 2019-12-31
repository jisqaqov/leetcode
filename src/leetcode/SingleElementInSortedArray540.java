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
    System.out.println(singleNonDuplicate(new int[]{0}));//0
    System.out.println(singleNonDuplicate(new int[]{1, 2, 2}));//1
    System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));//2
    System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));//10
    System.out.println(singleNonDuplicate(new int[]{1, 1, 2}));//2
  }

  public int singleNonDuplicate(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    if (nums.length == 1) {
      return nums[0];
    }

    while (l + 2 < r) {
      int m = l + (r - l) / 2;

      if (nums[m] == nums[m - 1]) {
        m--;
      }

      int len = r - m + 1;

      if (len % 2 > 0) {
        l = m;
      } else {
        r = m - 1;
      }
    }

    if (nums[l] != nums[l + 1]) {
      return nums[l];
    }

    return nums[r];
  }

  private static class V2 {
    public int singleNonDuplicate(int[] nums) {
      int n = nums.length;

      int l = 0, r = n - 1;

      while (l <= r) {
        int m = l + (r - l) / 2;

        if (m == 0 || m == n - 1 || (nums[m] != nums[m - 1] && nums[m] != nums[m + 1])) {
          return nums[m];
        }

        if (nums[m] == nums[m - 1]) {
          m--;
        }

        int len = r - m + 1;
        if (len % 2 > 0) {
          l = m + 2;
        } else {
          r = m - 1;
        }
      }

      return -1;
    }
  }

}

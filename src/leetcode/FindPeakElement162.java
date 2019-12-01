package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 162. Find Peak Element
 * algorithm: Binary Search
 * time complexity: O(log(N))
 * space complexity: O(log(N))
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
 * Memory Usage: 38.7 MB, less than 100.00% of Java online submissions for Find Peak Element.
 */
public class FindPeakElement162 {

  public static void main(String[] args) {
    FindPeakElement162 problem = new FindPeakElement162();
    problem.test();
  }

  private void test() {
    System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
    System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
  }

  public int findPeakElement(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
      int mid = l + (r - l) / 2;

      if (mid > 0 && nums[mid - 1] > nums[mid]) {
        r = mid - 1;
      } else if (mid < nums.length - 1 && nums[mid + 1] > nums[mid]) {
        l = mid + 1;
      } else {
        return mid;
      }
    }

    return -1;
  }

}

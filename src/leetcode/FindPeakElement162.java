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
    int[] tc1a = new int[]{1, 2, 3, 1};
    int[] tc2a = new int[]{1, 2, 1, 3, 5, 6, 4};

    System.out.println(findPeakElement(tc1a));
    System.out.println(findPeakElement(tc2a));

    System.out.println("v2:");

    V2 v2 = new V2();
    System.out.println(v2.findPeakElement(tc1a));
    System.out.println(v2.findPeakElement(tc2a));

    System.out.println("v3:");

    V3 v3 = new V3();
    System.out.println(v3.findPeakElement(tc1a));
    System.out.println(v3.findPeakElement(tc2a));
  }

  public int findPeakElement(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    while (l < r) {
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

  private static class V3 {
    public int findPeakElement(int[] nums) {
      int l = 0;
      int r = nums.length - 1;

      while (l < r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] < nums[mid + 1]) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }

      return l;
    }
  }

  private static class V2 {
    public int findPeakElement(int[] nums) {
      return findPeakElement(nums, 0, nums.length - 1);
    }

    public int findPeakElement(int[] nums, int l, int r) {
      if (l == r) {
        return l;
      }

      int mid = l + (r - l) / 2;
      if (nums[mid] > nums[mid + 1]) {
        return findPeakElement(nums, l, mid);
      }

      return findPeakElement(nums, mid + 1, r);
    }
  }

}

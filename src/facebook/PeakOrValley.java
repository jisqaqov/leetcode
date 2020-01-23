package facebook;

/**
 * @author Jandos Iskakov
 * algorithm: Binary Search
 * time complexity: O(log(N))
 * space complexity: O(1)
 *
 * problem:
 * https://leetcode.com/discuss/interview-question/473801/Facebook-or-Phone-Screen-or-Peak-or-Valley-Problem
 * Facebook | Phone Screen | Peak or Valley Problem
 *
 * Determine Peak or Valley from an integer array satisfying the following properities.
 *
 * At any given point in the array, the difference between two elements is +/- 1.
 * Ex. Arr[i] = A [i - 1] is +/- 1.
 * There should be only one peak or valley.
 * Return the index of the peak or valley from the given integer array.
 *
 * Examples:
 * Valley - [3, 2, 1, 0, 1] ==> 3
 * Peak - [4, 5, 6, 7, 8, 9, 8, 7] ==> 5
 * Invalid - [1, 2, 3] or [1, 2, 3, 2, 1, 2]
 *
 */
public class PeakOrValley {

  public static void main(String[] args) {
    PeakOrValley problem = new PeakOrValley();
    problem.test();
  }

  private void test() {
    System.out.println(findPeakOrValley(new int[]{3, 2, 1, 0, 1}));// 3
    System.out.println(findPeakOrValley(new int[]{4, 5, 6, 7, 8, 9, 8, 7}));// 5
    System.out.println(findPeakOrValley(new int[]{1, 2, 3}));// -1
    System.out.println(findPeakOrValley(new int[]{1, 2, 3, 2, 1, 2}));// -1
  }

  private int findPeakOrValley(int[] nums) {
    int peakIndex = findPeak(nums);
    int valleyIndex = findValley(nums);

    if (peakIndex > 0 && valleyIndex > 0) {
      return -1;
    } else if (peakIndex > 0) {
      return peakIndex;
    }

    return valleyIndex;
  }

  private int findPeak(int[] nums) {
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

    if (l == 0 || l == nums.length - 1 ||
      nums[l] < nums[l - 1] ||
      nums[l] < nums[l + 1]) {
      return -1;
    }

    return l;
  }

  private int findValley(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] > nums[mid + 1]) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }

    if (l == 0 || l == nums.length - 1 ||
      nums[l] > nums[l - 1] ||
      nums[l] > nums[l + 1]) {
      return -1;
    }

    return l;
  }


}
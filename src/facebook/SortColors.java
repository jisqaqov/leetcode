package facebook;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem:
 * https://leetcode.com/discuss/interview-question/124623/Facebook-or-Onsite-or-Variation-of-Dutch-National-Flag-problem
 * You have an unsorted array of integers and a function string
 * getCategory(integer), which deterministically returns 1 of three possible strings: "low",
 * "medium", or "high", depending on the input integer. You need to output an array with all the
 * "low" numbers at the bottom, all the "medium" numbers in the middle, and all the "high" numbers
 * at the top. This is basically a partial sort. Within each category, the order of the numbers does
 * not matter.
 *
 * For example, you might be give the array [5,7,2,9,1,14,12,10,5,3].
 * For input integers 1 - 3, getCategory(integer) returns "low",
 * for 4 - 10 it returns "medium," and for 11 - 15 it returns "high".
 *
 * You could output an array (or modify the given array) that looks like this:
 * [3,1,2,5,5,9,7,10,14,12]
 *
 * algorithm: Two Pointers
 * time complexity: O(N)
 * space complexity: O(1)
 */
public class SortColors {

  public static void main(String[] args) {
    SortColors problem = new SortColors();
    problem.test();
  }

  private void test() {
    int[] tc1a = {5, 7, 2, 9, 1, 14, 12, 10, 5, 3};
    sort(tc1a);
    System.out.println(Arrays.toString(tc1a));
  }

  public void sort(int[] nums) {
    int low = 0;
    int mid = 0;
    int high = nums.length - 1;

    while (mid <= high) {
      String cat = getCategory(nums[mid]);

      switch (cat) {
        case "low":
          swap(nums, mid, low);

          low++;
          mid++;
          break;
        case "high":
          swap(nums, mid, high);
          high--;
          break;
        default:
          mid++;
          break;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }

  private String getCategory(int number) {
    if (number <= 3) {
      return "low";
    } else if (number <= 10) {
      return "medium";
    }

    return "high";
  }


}
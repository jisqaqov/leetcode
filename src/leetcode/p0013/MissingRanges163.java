package leetcode.p0013;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 163. Missing Ranges
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 5 ms, faster than 29.24% of Java online submissions
 * Memory Usage: 37.7 MB, less than 7.41% of Java online submissions
 */
public class MissingRanges163 {

  public static void main(String[] args) {
    MissingRanges163 problem = new MissingRanges163();
    problem.test();
  }

  private void test() {
    //[2, 4->49, 51->74, 76->99]
    System.out.println(findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
    //[2, 4->49, 51->74]
    System.out.println(findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 75));
    System.out.println(findMissingRanges(new int[]{}, 0, 75));//[0->75]
    System.out.println(findMissingRanges(new int[]{-1}, -2, -1));//[-2]

    //[-2147483647->2147483646]
    System.out.println(findMissingRanges(new int[]{-2147483648, 2147483647}, -2147483648, 2147483647));
    //[-2147483648->2147483646]
    System.out.println(findMissingRanges(new int[]{2147483647}, -2147483648, 2147483647));
    //[-2147483648->2147483647]
    System.out.println(findMissingRanges(new int[]{}, -2147483648, 2147483647));
  }

  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    int n = nums.length;
    List<String> output = new ArrayList<>();

    if (n == 0) {
      output.add(getRange(lower, upper));
      return output;
    }

    if (lower < nums[0]) {
      output.add(getRange(lower, nums[0] - 1));
    }

    for (int i = 0; i < n - 1; i++) {
      if (nums[i] != nums[i + 1] && nums[i] + 1 != nums[i + 1]) {
        output.add(getRange(nums[i] + 1, nums[i + 1] - 1));
      }
    }

    if (nums[n - 1] < upper) {
      output.add(getRange(nums[n - 1] + 1, upper));
    }

    return output;
  }

  private String getRange(long lower, long upper) {
    return lower == upper? String.valueOf(lower): lower + "->" + upper;
  }

}
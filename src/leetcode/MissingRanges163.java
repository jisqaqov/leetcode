package leetcode;

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
    System.out.println(findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));//[2, 4->49, 51->74, 76->99]
    System.out.println(findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 75));//[2, 4->49, 51->74]
    System.out.println(findMissingRanges(new int[]{}, 0, 75));//[0->75]
    System.out.println(findMissingRanges(new int[]{-1}, -2, -1));//[-2]
    System.out.println(findMissingRanges(new int[]{-2147483648, 2147483647}, -2147483648, 2147483647));//[-2147483647->2147483646]
    System.out.println(findMissingRanges(new int[]{2147483647}, -2147483648, 2147483647));//[-2147483648->2147483646]
    System.out.println(findMissingRanges(new int[]{}, -2147483648, 2147483647));//[-2147483648->2147483647]
  }

  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    int n = nums.length;
    List<String> output = new ArrayList<>();

    if (n == 0) {
      addRange(lower, upper, output);
    } else {
      if (lower < nums[0]) {
        addRange(lower, (long)nums[0] - 1, output);
      }

      for (int i = 1; i < n; i++) {
        addRange((long)nums[i - 1] + 1, (long)nums[i] - 1, output);
      }

      if (nums[n - 1] < upper) {
        addRange((long)nums[n - 1] + 1, upper, output);
      }
    }

    return output;
  }

  private void addRange(long lower, long upper, List<String> output) {
    if (lower == upper) {
      output.add(String.valueOf(lower));
    } else if (lower < upper) {
      output.add(lower + "->" + upper);
    }
  }

}
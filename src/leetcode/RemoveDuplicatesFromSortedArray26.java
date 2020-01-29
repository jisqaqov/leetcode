package leetcode;

import java.util.Arrays;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 26. Remove Duplicates from Sorted Array
 * algorithm: Two Pointers
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 41.7 MB, less than 16.49% of Java online submissions
 */
public class RemoveDuplicatesFromSortedArray26 {

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedArray26 problem =
      new RemoveDuplicatesFromSortedArray26();
    problem.test();
  }

  private void test() {
    int[] tc1a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int n = removeDuplicates(tc1a);
    tc1a = Arrays.copyOf(tc1a, n);

    System.out.println("n = " + n);
    TestUtils.printArray(tc1a);
  }

  public int removeDuplicates(int[] nums) {
    int p = 0;

    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        nums[p] = nums[i];
        p++;
      }
    }

    return p;
  }

}

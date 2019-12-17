package leetcode;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 75. Sort Colors
 * algorithm: Two Pointers
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 35.3 MB, less than 99.21% of Java online submissions
 */
public class SortColors75 {

  public static void main(String[] args) {
    SortColors75 problem = new SortColors75();
    problem.test();
  }

  private void test() {
    int[] tc1a = {2, 0, 2, 1, 1, 0, 2, 2, 1, 0, 1, 0, 2, 0, 1};
    sortColors(tc1a);
    TestUtils.printArray(tc1a);

    int[] tc2a = {2, 0, 2, 0, 1, 2};
    sortColors(tc2a);
    TestUtils.printArray(tc2a);

    int[] tc3a = {1, 0, 1};
    sortColors(tc3a);
    TestUtils.printArray(tc3a);

    int[] tc4a = {0, 1, 0};
    sortColors(tc4a);
    TestUtils.printArray(tc4a);
  }

  public void sortColors(int[] nums) {
    int idx1 = -1;
    int idx2 = -1;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 2 && idx2 == -1) {
        idx2 = i;
      } else if (nums[i] == 1) {
        if (idx2 >= 0) {
          nums[i] = 2;
          nums[idx2] = 1;

          if (idx1 == -1) {
            idx1 = idx2;
          }

          idx2++;
        }

        if (idx1 == -1) {
          idx1 = i;
        }
      } else if (nums[i] == 0) {
        if (idx1 >= 0 && idx2 >= 0) {
          nums[i] = 2;
          nums[idx2] = 1;
          nums[idx1] = 0;

          idx1++;
          idx2++;
        } else if (idx2 >= 0) {
          nums[i] = 2;
          nums[idx2] = 0;

          idx2++;
        } else if (idx1 >= 0) {
          nums[i] = 1;
          nums[idx1] = 0;

          idx1++;
        }
      }
    }
  }

}

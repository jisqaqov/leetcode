package facebook;

import java.util.Arrays;
import utils.TestUtils;


/**
 * @author Jandos Iskakov
 * problem: 350. Intersection of Two Arrays II (given arrays are sorted)
 * algorithm: Two Pointer
 * time complexity: O(n + m)
 * space complexity: O(1)
 */
public class IntersectionOfTwoSortedArraysII {

  public static void main(String[] args) {
    IntersectionOfTwoSortedArraysII problem = new IntersectionOfTwoSortedArraysII();
    problem.test();
  }

  private void test() {
    TestUtils.printArray(intersect(new int[]{1, 1, 2, 2}, new int[]{2, 2}));
  }

  public int[] intersect(int[] nums1, int[] nums2) {
    int i = 0, j = 0;
    int k = 0;

    int[] output = new int[nums1.length];

    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j]) {
        output[k] = nums1[i];

        k++;
        i++;
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
      }
    }

    return Arrays.copyOf(output, k);
  }

}

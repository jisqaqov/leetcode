package facebook;

import java.util.Arrays;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: variation of 349. Intersection of Two Arrays
 * algorithm: Two Pointer
 * time complexity: O(n + m)
 * space complexity: O(1)
 */
public class IntersectionOfTwoSortedArrays {

  public static void main(String[] args) {
    IntersectionOfTwoSortedArrays problem = new IntersectionOfTwoSortedArrays();
    problem.test();
  }

  private void test() {
    TestUtils.printArray(intersection(new int[] {1, 1, 2, 2}, new int[] {2, 2}));
  }

  public int[] intersection(int[] nums1, int[] nums2) {
    int i = 0, j = 0;
    int k = 0;

    int[] output = new int[nums1.length + nums2.length];

    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j]) {
        if (k == 0 || output[k - 1] != nums1[i]) {
          output[k] = nums1[i];
          k++;
        }

        i++;
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
      }
    }

    return Arrays.copyOfRange(output, 0, k);
  }


}

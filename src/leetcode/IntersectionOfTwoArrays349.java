package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 349. Intersection of Two Arrays
 * algorithm: Hash Table, Two Pointer
 * time complexity: O(n + m)
 * space complexity: O(n + m)
 * Runtime: 2 ms, faster than 97.53% of Java online submissions
 * Memory Usage: 39.7 MB, less than 6.75% of Java online submissions
 */
public class IntersectionOfTwoArrays349 {

  public static void main(String[] args) {
    IntersectionOfTwoArrays349 problem = new IntersectionOfTwoArrays349();
    problem.test();
  }

  private void test() {
    TestUtils.printArray(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
  }

  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> setOfNums2 = new HashSet<>();
    for (int num : nums2) {
      setOfNums2.add(num);
    }

    int[] output = new int[Math.min(nums1.length, nums2.length)];

    int k = 0;
    for (int number : nums1) {
      if (setOfNums2.contains(number)) {
        output[k++] = number;
        setOfNums2.remove(number);
      }
    }

    return Arrays.copyOf(output, k);
  }

  private static class V2 {

    public int[] intersection(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Arrays.sort(nums2);

      int i = 0, j = 0;
      int k = 0;

      int[] output = new int[Math.min(nums1.length, nums2.length)];

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

}

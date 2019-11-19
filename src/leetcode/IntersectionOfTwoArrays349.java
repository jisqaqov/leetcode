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
 * Runtime: 1 ms, faster than 99.71% of Java online submissions for Intersection of Two Arrays.
 * Memory Usage: 38 MB, less than 39.19% of Java online submissions for Intersection of Two Arrays.
 */
public class IntersectionOfTwoArrays349 {

  public static void main(String[] args) {
    IntersectionOfTwoArrays349 problem = new IntersectionOfTwoArrays349();
    problem.test();
  }

  private void test() {
    int[] tc1a = {1,2,2,1};
    int[] tc1b = {2,2};

    FacebookInterview facebookInterview = new FacebookInterview();

    TestUtils.printArray(intersection(tc1a, tc1b));
    TestUtils.printArray(facebookInterview.intersection(tc1a, tc1b));
  }

  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    for (int num : nums1) {
      set1.add(num);
    }

    Set<Integer> set2 = new HashSet<>();
    for (int num : nums2) {
      set2.add(num);
    }

    int i = 0;
    int[] output = new int[set2.size()];

    for (int number : set1) {
      if (set2.contains(number)) {
        output[i++] = number;
      }
    }

    return Arrays.copyOf(output, i);
  }

  /**
   * Facebook interview question
   * solve in (1) space and O(N) time complexity
   * in case that arrays are already sorted
   */
  private static class FacebookInterview {
    public int[] intersection(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Arrays.sort(nums2);

      int i = 0;
      int j = 0;
      int k = 0;

      int[] sol = new int[nums1.length + nums2.length];

      while (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) {
          i++;
        } else if (nums1[i] > nums2[j]) {
          j++;
        } else {
          if (k == 0 || sol[k - 1] != nums1[i]) {
            sol[k] = nums1[i];
            k++;
          }

          i++;
          j++;
        }
      }

      return Arrays.copyOfRange(sol, 0, k);
    }
  }

}

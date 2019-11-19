package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 350. Intersection of Two Arrays II
 * algorithm: Hash Table, Two Pointer
 * time complexity: O(nlogn + mlogm)
 * space complexity: O(n + m)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Intersection of Two Arrays II.
 * Memory Usage: 36.2 MB, less than 83.87% of Java online submissions for Intersection of Two Arrays II.
 */
public class IntersectionOfTwoArraysII350 {

  public static void main(String[] args) {
    IntersectionOfTwoArraysII350 problem = new IntersectionOfTwoArraysII350();
    problem.test();
  }

  private void test() {
    int[] tc1a = {1,2,2,1};
    int[] tc1b = {2,2};

    V2 v2 = new V2();

    TestUtils.printArray(intersect(tc1a, tc1b));
    TestUtils.printArray(v2.intersect(tc1a, tc1b));
  }

  public int[] intersect(int[] nums1, int[] nums2) {
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
        sol[k] = nums1[i];

        k++;
        i++;
        j++;
      }
    }

    return Arrays.copyOfRange(sol, 0, k);
  }

  private static class V2 {
    public int[] intersect(int[] nums1, int[] nums2) {
      Map<Integer, Integer> c1 = new HashMap<>();
      for (int num : nums1) {
        c1.put(num, c1.getOrDefault(num, 0) + 1);
      }

      Map<Integer, Integer> c2 = new HashMap<>();
      for (int num : nums2) {
        c2.put(num, c2.getOrDefault(num, 0) + 1);
      }

      int n = 0;

      int[] list = new int[nums1.length + nums2.length];

      for (int num : c1.keySet()) {
        int m = Math.min(c1.get(num), c2.getOrDefault(num, 0));

        for (int k = 0; k < m; k++) {
          list[n++] = num;
        }
      }

      return Arrays.copyOfRange(list, 0, n);
    }
  }

}

package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 350. Intersection of Two Arrays II
 * algorithm: Hash Table, Two Pointer
 * time complexity: O(n + m)
 * space complexity: O(n + m)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 36.2 MB, less than 83.87% of Java online submissions
 */
public class IntersectionOfTwoArraysII350 {

  public static void main(String[] args) {
    IntersectionOfTwoArraysII350 problem = new IntersectionOfTwoArraysII350();
    problem.test();
  }

  private void test() {
    TestUtils.printArray(intersect(new int[]{1, 1, 2, 2}, new int[]{2, 2}));
  }

  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> mapOfNums1 = new HashMap<>();
    for (int num : nums1) {
      mapOfNums1.put(num, mapOfNums1.getOrDefault(num, 0) + 1);
    }

    int k = 0;
    int[] output = new int[nums1.length];

    for (int num : nums2) {
      int cnt = mapOfNums1.getOrDefault(num, 0);

      if (cnt > 0) {
        output[k++] = num;
        mapOfNums1.put(num, mapOfNums1.get(num) - 1);
      }
    }

    return Arrays.copyOf(output, k);
  }

}

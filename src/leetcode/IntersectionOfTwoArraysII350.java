package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 350. Intersection of Two Arrays II
 * algorithm: Hash Table
 * time complexity: O(N + M)
 * space complexity: O(N + M)
 * Runtime: 4 ms, faster than 22.41% of Java online submissions for Intersection of Two Arrays II.
 * Memory Usage: 36.6 MB, less than 83.87% of Java online submissions for Intersection of Two Arrays II.
 */
public class IntersectionOfTwoArraysII350 {

  public static void main(String[] args) {
    IntersectionOfTwoArraysII350 problem = new IntersectionOfTwoArraysII350();
    problem.test();
  }

  private void test() {
    int[] tc1a = {1,2,2,1};
    int[] tc1b = {2,2};

    TestUtils.printArray(intersect(tc1a, tc1b));
  }

  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> c1 = new HashMap<>();
    for (int num : nums1) {
      c1.put(num, c1.getOrDefault(num, 0) + 1);
    }

    Map<Integer, Integer> c2 = new HashMap<>();
    for (int num : nums2) {
      c2.put(num, c2.getOrDefault(num, 0) + 1);
    }

    List<Integer> list = new ArrayList<>();
    for (int num : c1.keySet()) {
      int n = Math.min(c1.get(num), c2.getOrDefault(num, 0));
      for (int k = 0; k < n; k++) {
        list.add(num);
      }
    }

    int[] sol = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      sol[i] = list.get(i);
    }

    return sol;
  }

}

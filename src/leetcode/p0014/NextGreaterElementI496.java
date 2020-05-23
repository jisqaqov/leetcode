package leetcode.p0014;

import utils.TestUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 496. Next Greater Element I
 * algorithm: Stack, Hash Table
 * time complexity: O(N + M)
 * space complexity: O(M)
 * Runtime: 3 ms, faster than 85.79% of Java online submissions
 * Memory Usage: 41.2 MB, less than 7.41% of Java online submissions
 */
public class NextGreaterElementI496 {

  public static void main(String[] args) {
    NextGreaterElementI496 prep = new NextGreaterElementI496();
    prep.test();
  }

  private void test() {
    TestUtils.printArray(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));//-1, 3, -1
  }

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Deque<Integer> stack = new ArrayDeque<>();
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums2.length; i++) {
      while (!stack.isEmpty() && stack.peek() < nums2[i]) {
        map.put(stack.pop(), nums2[i]);
      }

      stack.push(nums2[i]);
    }

    while (!stack.isEmpty()) {
      map.put(stack.pop(), -1);
    }

    int[] output = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      output[i] = map.getOrDefault(nums1[i], -1);
    }

    return output;
  }

  private static class V2 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      Deque<Integer> stack = new ArrayDeque<>();
      Map<Integer, Integer> map = new HashMap<>();

      for (int i = nums2.length - 1; i >= 0; i--) {
        int g = -1;
        if (i + 1 <= nums2.length - 1 && nums2[i] < nums2[i + 1]) {
          g = nums2[i + 1];
          stack.push(nums2[i + 1]);
        } else if (!stack.isEmpty()) {
          while (!stack.isEmpty() && stack.peek() < nums2[i]) {
            stack.pop();
          }

          if (!stack.isEmpty()) {
            g = stack.peek();
          }
        }

        map.put(nums2[i], g);
      }

      int[] output = new int[nums1.length];
      for (int i = 0; i < nums1.length; i++) {
        output[i] = map.getOrDefault(nums1[i], -1);
      }

      return output;
    }

  }

}

package leetcode.p0014;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 503. Next Greater Element II
 * algorithm: Stack
 * time complexity: O(n)
 * space complexity: O(n)
 * Runtime: 4 ms, faster than 99.07%
 * Memory Usage: 40.7 MB, less than 100.00%
 */
public class NextGreaterElementII503 {

  public int[] nextGreaterElements(int[] nums) {
    Deque<Integer> stack = new ArrayDeque<>();

    int[] output = new int[nums.length];
    Arrays.fill(output, -1);

    for (int i = 0; i < nums.length; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        output[stack.poll()] = nums[i];
      }

      stack.push(i);
    }

    for (int i = 0; i < nums.length; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        output[stack.poll()] = nums[i];
      }
    }

    return output;
  }


}

package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 739. Daily Temperatures
 * algorithm: Stack
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 13 ms, faster than 86.93% of Java online submissions
 * Memory Usage: 46.3 MB, less than 6.78% of Java online submissions
 */
public class DailyTemperatures739 {

  public static void main(String[] args) {
    DailyTemperatures739 problem = new DailyTemperatures739();
    problem.test();
  }

  private void test() {
    // 1, 1, 4, 2, 1, 1, 0, 0
    TestUtils.printArray(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
  }

  public int[] dailyTemperatures(int[] t) {
    int[] output = new int[t.length];

    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < t.length; i++) {
      while (!stack.isEmpty() && t[stack.peek()] < t[i]) {
        output[stack.peek()] = i - stack.peek();
        stack.pop();
      }

      stack.push(i);
    }

    return output;
  }


}
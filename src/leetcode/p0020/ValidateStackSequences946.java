package leetcode.p0020;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 946. Validate Stack Sequences
 * algorithm: Stack
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 2 ms, faster than 90.76% of Java online submissions
 * Memory Usage: 40.7 MB, less than 50.00% of Java online submissions
 */
public class ValidateStackSequences946 {

  public boolean validateStackSequences(int[] pushed, int[] popped) {
    if (pushed.length != popped.length) {
      return false;
    }

    int j = 0;
    Deque<Integer> stack = new ArrayDeque<>();

    for (int val: pushed) {
      stack.push(val);

      while (!stack.isEmpty() && stack.peek() == popped[j]) {
        stack.poll();
        j++;
      }
    }

    return j == popped.length;
  }

}
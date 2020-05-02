package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 735. Asteroid Collision
 * algorithm: Stack
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 12 ms, faster than 8.15% of Java online submissions
 * Memory Usage: 46.5 MB, less than 8.33% of Java online submissions
 */
public class AsteroidCollision735 {

  public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> stack = new ArrayDeque<>();

    for (int ast : asteroids) {
      if (ast > 0) {
        stack.push(ast);
      } else {
        while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(ast)) {
          stack.poll();
        }

        if (stack.isEmpty() || stack.peek() < 0) {
          stack.push(ast);
        } else if (stack.peek() == Math.abs(ast)) {
          stack.poll();
        }
      }
    }

    int[] output = new int[stack.size()];

    for (int i = stack.size(); i > 0; i--) {
      output[i - 1] = stack.poll();
    }

    return output;
  }

}
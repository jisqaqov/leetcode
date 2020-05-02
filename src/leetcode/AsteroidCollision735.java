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

    for (int i = 0; i < asteroids.length; i++) {
      stack.push(asteroids[i]);

      while (stack.size() >= 2) {
        int ast1 = stack.poll();
        int ast2 = stack.peek();

        boolean collide = collide(ast1, ast2);
        if (!collide) {
          stack.push(ast1);
          break;
        }

        int size1 = Math.abs(ast1);
        int size2 = Math.abs(ast2);

        if (size1 < size2) {
          break;
        }

        if (size1 > size2) {
          stack.poll();
          stack.push(ast1);
        } else if (size1 == size2) {
          stack.poll();
        }
      }
    }

    List<Integer> list = new ArrayList<>(stack);
    Collections.reverse(list);

    int[] output = new int[list.size()];

    for (int i = 0; i < list.size(); i++) {
      output[i] = list.get(i);
    }

    return output;
  }

  private boolean collide(int ast1, int ast2) {
    return ast1 < 0 && ast2 > 0;
  }

}
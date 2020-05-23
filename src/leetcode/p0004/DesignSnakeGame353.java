package leetcode.p0004;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 353. Design Snake Game
 * algorithm: Queue
 * time complexity: O(1)
 * space complexity: O(N*M)
 * Runtime: 59 ms, faster than 33.71%
 * Memory Usage: 45.7 MB, less than 100.00%
 */
public class DesignSnakeGame353 {

  class SnakeGame {

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the      second is at [1,0]. */

    private int score = 0;

    private int width = 0;
    private int height = 0;

    private Set<List<Integer>> used = new HashSet<>();
    private Deque<List<Integer>> queue = new ArrayDeque<>();

    private int[][] food;
    private int index = 0;

    public SnakeGame(int width, int height, int[][] food) {
      queue.addLast(Arrays.asList(0, 0));
      used.add(Arrays.asList(0, 0));

      this.width = width;
      this.height = height;

      this.food = food;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
      List<Integer> head = queue.getLast();
      List<Integer> newHead = new ArrayList<>(head);

      switch(direction) {
        case "U":
          newHead.set(0, newHead.get(0) - 1);
          break;
        case "D":
          newHead.set(0, newHead.get(0) + 1);
          break;
        case "L":
          newHead.set(1, newHead.get(1) - 1);
          break;
        case "R":
          newHead.set(1, newHead.get(1) + 1);
          break;
      }

      if (newHead.get(0) < 0 || newHead.get(0) >= height ||
        newHead.get(1) < 0 || newHead.get(1) >= width ||
        (used.contains(newHead) && !newHead.equals(queue.getFirst()))) {
        return -1;
      }

      if (index < food.length &&
        newHead.get(0) == food[index][0] &&
        newHead.get(1) == food[index][1]) {
        index++;
        score++;
      } else {
        used.remove(queue.pollFirst());
      }

      queue.addLast(newHead);
      used.add(newHead);

      return score;
    }

  }

}
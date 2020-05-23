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

    private Set<Integer> used = new HashSet<>();
    private Deque<Integer> queue = new ArrayDeque<>();

    private int[][] food;
    private int index = 0;

    public SnakeGame(int width, int height, int[][] food) {
      used.add(0);
      queue.addLast(0);

      this.width = width;
      this.height = height;

      this.food = food;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
      int head = queue.getLast();

      int hr = head / width;
      int hc = head % width;

      switch(direction) {
        case "U":
          hr--;
          break;
        case "D":
          hr++;
          break;
        case "L":
          hc--;
          break;
        case "R":
          hc++;
          break;
      }

      int newHead = hr * width + hc;
      int tail = queue.getFirst();

      if (hr < 0 || hr >= height ||
        hc < 0 || hc >= width ||
        (used.contains(newHead) && newHead != tail)) {
        return -1;
      }

      if (index < food.length && hr == food[index][0] && hc == food[index][1]) {
        index++;
        score++;
      } else {
        queue.pollFirst();
        used.remove(tail);
      }

      queue.addLast(newHead);
      used.add(newHead);

      return score;
    }

  }

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */

}
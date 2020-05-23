package leetcode.p0013;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 346. Moving Average from Data Stream
 * algorithm: Queue
 * time complexity: O(1)
 * space complexity: O(K)
 * Runtime: 22 ms, faster than 63.94% of Java online submissions
 * Memory Usage: 42.8 MB, less than 75.00% of Java online submissions
 */
public class MovingAverageFromDataStream346 {

  public static void main(String[] args) {
    MovingAverageFromDataStream346 problem = new MovingAverageFromDataStream346();
    problem.test();
  }

  private void test() {
    MovingAverage m = new MovingAverage(3);

    //[1.00000,5.50000,4.66667,6.00000]
    System.out.println(m.next(1));
    System.out.println(m.next(10));
    System.out.println(m.next(3));
    System.out.println(m.next(5));
  }

  class MovingAverage {
    private int size = 0;
    private int sum = 0;
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
      queue = new LinkedList<>();
      this.size = size;
    }

    public double next(int val) {
      sum += val;

      queue.add(val);
      if (queue.size() > size) {
        sum -= queue.poll();
      }

      return sum * 1.0 / queue.size();
    }
  }

}

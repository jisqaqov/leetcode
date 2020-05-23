package leetcode.p0006;

import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 295. Find Median from Data Stream
 * algorithm: Heap, Design
 * time complexity: O(log(n))
 * space complexity: O(n)
 * Runtime: 119 ms, faster than 38.80% of Java online submissions for Find Median from Data Stream.
 * Memory Usage: 67 MB, less than 52.54% of Java online submissions for Find Median from Data Stream.
 */
public class FindMedianFromDataStream295 {
  public static void main(String[] args) {
    FindMedianFromDataStream295 problem = new FindMedianFromDataStream295();
    problem.test();
  }

  private void test() {
    MedianFinder finder = new MedianFinder();
    finder.addNum(1);
    finder.addNum(2);
    System.out.println(finder.findMedian());
    finder.addNum(3);
    System.out.println(finder.findMedian());
    finder.addNum(1);
    System.out.println(finder.findMedian());
  }

  class MedianFinder {
    private PriorityQueue<Integer> low;
    private PriorityQueue<Integer> high;

    /** initialize your data structure here. */
    public MedianFinder() {
      low = new PriorityQueue<>((a1, a2) -> a2 - a1);
      high = new PriorityQueue<>();
    }

    public void addNum(int num) {
      low.add(num);

      high.add(low.poll());

      if (low.size() < high.size()) {
        low.add(high.poll());
      }
    }

    public double findMedian() {
      return low.size() > high.size()? low.peek(): (low.peek() + high.peek()) * 0.5;
    }
  }

}

package leetcode;

import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 295. Find Median from Data Stream
 * algorithm: Heap, Design
 * time complexity: O(log(n))
 * space complexity: O(n)
 * Runtime: 106 ms, faster than 93.47% of Java online submissions for Find Median from Data Stream.
 * Memory Usage: 61.8 MB, less than 91.53% of Java online submissions for Find Median from Data Stream.
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
    private int n = 0;
    private double median = 0;
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    /** initialize your data structure here. */
    public MedianFinder() {
      left = new PriorityQueue<>((a1, a2) -> a2 - a1);
      right = new PriorityQueue<>();
    }

    public void addNum(int num) {
      if (n == 0) {
        median = num;
      } else if (n == 1) {
        int medianInt = (int) median;
        left.add(Math.min(num, medianInt));
        right.add(Math.max(num, medianInt));
        median = (left.peek() + right.peek()) / 2.0;
      } else {
        if (n % 2 == 0) {
          if (num == median) {
            median = num;
          } else if (num > median) {
            right.add(num);
            median = right.poll();
          } else if (num < median) {
            left.add(num);
            median = left.poll();
          }
        } else {
          int medianInt = (int) median;
          if (num > median) {
            right.add(num);
            left.add(medianInt);
          } else if (num <= median) {
            left.add(num);
            right.add(medianInt);
          }

          median = (left.peek() + right.peek()) / 2.0;
        }
      }

      n++;
    }

    public double findMedian() {
      return median;
    }
  }

}

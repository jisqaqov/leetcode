package leetcode;

import java.util.PriorityQueue;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 480. Sliding Window Median
 * algorithm: Sliding Window, Heap
 * time complexity: O(nlog(k))
 * space complexity: O(k)
 * Runtime: 139 ms, faster than 25.85% of Java online submissions
 * Memory Usage: 43.5 MB, less than 40.00% of Java online submissions
 */
public class SlidingWindowMedian480 {

  public static void main(String[] args) {
    SlidingWindowMedian480 problem = new SlidingWindowMedian480();
    problem.test();
  }

  private void test() {
    // [1.0 -1.0 -1.0 3.0 5.0 6.0 ]
    TestUtils.printArray(medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
  }

  public double[] medianSlidingWindow(int[] nums, int k) {
    PriorityQueue<Integer> low = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    PriorityQueue<Integer> high = new PriorityQueue<>();

    for (int i = 0; i < k; i++) {
      addNumber(low, high, nums[i]);
    }

    double[] output = new double[nums.length - k + 1];
    output[0] = getMedian(low, high);

    for (int i = k; i < nums.length; i++) {
      removeNumber(low, high, nums[i - k]);
      addNumber(low, high, nums[i]);

      output[i - k + 1] = getMedian(low, high);
    }

    return output;
  }

  private void removeNumber(PriorityQueue<Integer> low, PriorityQueue<Integer> high, int num) {
    if (!high.remove(num)) {
      low.remove(num);
    }
  }

  private void addNumber(PriorityQueue<Integer> low, PriorityQueue<Integer> high, int num) {
    low.add(num);
    high.add(low.poll());

    if (high.size() > low.size()) {
      low.add(high.poll());
    }
  }

  private double getMedian(PriorityQueue<Integer> low, PriorityQueue<Integer> high) {
    if (low.size() == high.size()) {
      return (low.peek() * 1.0 + high.peek() * 1.0) / 2.0;
    }

    return low.peek();
  }

}
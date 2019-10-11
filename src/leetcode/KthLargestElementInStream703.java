package leetcode;

import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 703. Kth Largest Element in a Stream
 * algorithm: Heap
 * time complexity: O(nlog(k))
 * space complexity: O(k)
 * Runtime: 62 ms, faster than 51.58% of Java online submissions for Kth Largest Element in a Stream.
 * Memory Usage: 45.2 MB, less than 96.67% of Java online submissions for Kth Largest Element in a Stream.
 */
public class KthLargestElementInStream703 {

  public static void main(String[] args) {
    KthLargestElementInStream703 problem = new KthLargestElementInStream703();
    problem.test();
  }

  private void test() {
    int[] tc1a = {4, 5, 8, 2};
    KthLargest problem = new KthLargest(3, tc1a);

    System.out.println(problem.add(3));
    System.out.println(problem.add(5));
    System.out.println(problem.add(10));
    System.out.println(problem.add(9));
    System.out.println(problem.add(4));
  }


  class KthLargest {

    private int k;
    private PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
      this.k = k;
      this.heap = new PriorityQueue<>(k);
      for (int number : nums) {
        add(number);
      }
    }

    public int add(int val) {
      heap.add(val);

      if (heap.size() > k) {
        heap.poll();
      }

      return heap.peek();
    }
  }

}

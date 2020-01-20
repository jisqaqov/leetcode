package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 378. Kth Smallest Element in a Sorted Matrix
 * algorithm: Heap
 * time complexity: O((n+k)*log(n))
 * space complexity: O(n)
 * Runtime: 22 ms, faster than 18.75% of Java online submissions
 * Memory Usage: 52.8 MB, less than 5.41% of Java online submissions
 */
public class KthSmallestElementInASortedMatrix378 {

  public static void main(String[] args) {
    KthSmallestElementInASortedMatrix378 problem =
      new KthSmallestElementInASortedMatrix378();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{1, 5, 9},
      {10, 11, 13},
      {12, 13, 15}};

    System.out.println(kthSmallest(tc1a, 8));
  }

  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;

    PriorityQueue<int[]> pq = new PriorityQueue<>(
      Comparator.comparingInt(rc -> matrix[rc[0]][rc[1]]));

    int num = -1;

    for (int i = 0; i < n; i++) {
      pq.add(new int[]{i, 0});
    }

    while (k > 0) {
      int[] rc = pq.poll();
      num = matrix[rc[0]][rc[1]];

      if (rc[1] < matrix[rc[0]].length - 1) {
        pq.add(new int[]{rc[0], rc[1] + 1});
      }

      k--;
    }

    return num;
  }

}

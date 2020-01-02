package facebook;

import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * algorithm: Heap
 * Given k sorted arrays of possibly different sizes, find m-th smallest value in the merged array.
 *
 * Example 1:
 *
 * Input: [[1, 3], [2, 4, 6], [0, 9, 10, 11]], m = 5
 * Output: 4
 * Explanation: The merged array would be [0, 1, 2, 3, 4, 6, 9, 10, 11].
 * The 5-th smallest element in this merged array is 4.
 *
 * time complexity: O(r*c*log(k))
 * space complexity: O(k)
 */
public class KthSmallestInSortedMatrix {

  public static void main(String[] args) {
    KthSmallestInSortedMatrix problem = new KthSmallestInSortedMatrix();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{1, 3}, {2, 4, 6}, {0, 9, 10, 11}};

    System.out.println(kthSmallest(tc1a, 5));//4

    int[][] tc2a = {{1, 3, 20}, {2, 4, 6}};

    System.out.println(kthSmallest(tc2a, 2));//2
  }

  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> matrix[x[0]][x[1]] - matrix[y[0]][y[1]]);

    for (int i = 0; i < matrix.length; i++) {
      pq.add(new int[] {i, 0});
    }

    int min = -1;

    while (k > 0) {
      int[] rc = pq.poll();

      if (rc[1] < matrix[rc[0]].length - 1) {
        pq.add(new int[] {rc[0], rc[1] + 1});
      }

      min = matrix[rc[0]][rc[1]];

      k--;
    }

    return min;
  }

  private static class V2 {
    public int kthSmallest(int[][] a, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<>((t1, t2) -> t2 - t1);

      for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[i].length; j++) {
          pq.add(a[i][j]);

          if (pq.size() > k) {
            pq.poll();
          }
        }
      }

      return pq.poll();
    }
  }

}
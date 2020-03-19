package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 373. Find K Pairs with Smallest Sums
 * algorithm: Graph, Topological Sort
 * time complexity: O(klog(k))
 * space complexity: O(k)
 * Runtime: 4 ms, faster than 79.90% of Java online submissions
 * Memory Usage: 41.5 MB, less than 48.15% of Java online submissions
 */
public class FindKPairsWithSmallestSums373 {

  public static void main(String[] args) {
    FindKPairsWithSmallestSums373 problem = new FindKPairsWithSmallestSums373();
    problem.test();
  }

  private void test() {
    // [[1,2],[1,4],[1,6]]
    System.out.println(kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
  }

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    int n = nums1.length;
    int m = nums2.length;

    if (n == 0 || m == 0) {
      return Collections.emptyList();
    }

    List<List<Integer>> output = new ArrayList<>();

    PriorityQueue<int[]> pq = new PriorityQueue<>(
      (p1, p2) -> nums1[p1[0]] + nums2[p1[1]] - (nums1[p2[0]] + nums2[p2[1]]));
    pq.add(new int[]{0, 0});

    boolean[][] used = new boolean[n][m];

    for (; k > 0 && !pq.isEmpty(); k--) {
      int[] idx = pq.poll();

      output.add(Arrays.asList(nums1[idx[0]], nums2[idx[1]]));

      int[] idx1 = {idx[0] + 1, idx[1]};
      if (idx1[0] < n && !used[idx1[0]][idx1[1]]) {
        pq.add(idx1);
        used[idx1[0]][idx1[1]] = true;
      }

      int[] idx2 = {idx[0], idx[1] + 1};
      if (idx2[1] < m && !used[idx2[0]][idx2[1]]) {
        pq.add(idx2);
        used[idx2[0]][idx2[1]] = true;
      }
    }

    return output;
  }

}
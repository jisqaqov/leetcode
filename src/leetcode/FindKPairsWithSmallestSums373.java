package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 373. Find K Pairs with Smallest Sums
 * algorithm: Heap
 * time complexity: O(klog(k))
 * space complexity: O(k)
 * Runtime: 4 ms, faster than 77.46%
 * Memory Usage: 40.5 MB, less than 66.67%
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
    if (nums1.length == 0 || nums2.length == 0) {
      return Collections.emptyList();
    }

    List<List<Integer>> output = new ArrayList<>();

    PriorityQueue<int[]> pq = new PriorityQueue<>(
      (p1, p2) -> Integer.compare(p1[2], p2[2]));

    for (int i = 0; i < Math.min(nums1.length, k); i++) {
      pq.add(new int[] {i, 0, nums1[i] + nums2[0]});
    }

    for (; k > 0 && !pq.isEmpty(); k--) {
      int[] vals = pq.poll();

      output.add(Arrays.asList(nums1[vals[0]], nums2[vals[1]]));

      if (vals[1] < nums2.length - 1) {
        pq.add(new int[] {vals[0], vals[1] + 1, nums1[vals[0]] + nums2[vals[1] + 1]});
      }
    }

    return output;
  }

}
package leetcode;

import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 88. Merge Sorted Array
 * algorithm: Array, Two Pointers
 * time complexity: O(n + m)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
 * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Merge Sorted Array.
 */
public class MergeSortedArray88 {

  public static void main(String[] args) {
    MergeSortedArray88 problem = new MergeSortedArray88();
    problem.test();
  }

  private void test() {
    int[] tc1a = {1, 2, 3, 0, 0, 0};
    int[] tc1b = {2, 5, 6};

    merge(tc1a, 3, tc1b, 3);
    TestUtils.printArray(tc1a);
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int k = nums1.length - 1;
    int i = m - 1;
    int j = n - 1;

    while (i >= 0 && j >= 0) {
      if (nums1[i] >= nums2[j]) {
        nums1[k] = nums1[i];

        i--;
        k--;
      } else if (nums1[i] < nums2[j]) {
        nums1[k] = nums2[j];

        j--;
        k--;
      }
    }

    while (i >= 0) {
      nums1[k] = nums1[i];
      k--;
      i--;
    }

    while (j >= 0) {
      nums1[k] = nums2[j];
      k--;
      j--;
    }
  }

  private static class V2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int i = m - 1;
      for (int j = nums1.length - 1; i >= 0; j--, i--) {
        nums1[j] = nums1[i];
      }

      int p = nums1.length - m;
      int q = 0;
      int k = 0;

      while (p < nums1.length && q < nums2.length) {
        if (nums1[p] <= nums2[q]) {
          nums1[k] = nums1[p];
          p++;
          k++;
        } else if (nums2[q] < nums1[p]) {
          nums1[k] = nums2[q];
          q++;
          k++;
        }
      }

      while (p < nums1.length) {
        nums1[k] = nums1[p];
        p++;
        k++;
      }

      while (q < nums2.length) {
        nums1[k] = nums2[q];
        q++;
        k++;
      }
    }
  }

}

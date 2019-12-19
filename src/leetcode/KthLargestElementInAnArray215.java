package leetcode;

import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 215. Kth Largest Element in an Array
 * algorithm: QuickSelect, Sort
 * time complexity: O(n)
 * space complexity: O(log(n))
 * Runtime: 26 ms, faster than 29.10% of Java online submissions for Kth Largest Element in an Array.
 * Memory Usage: 37.5 MB, less than 90.16% of Java online submissions for Kth Largest Element in an Array.
 */
public class KthLargestElementInAnArray215 {

  public static void main(String[] args) {
    KthLargestElementInAnArray215 problem = new KthLargestElementInAnArray215();
    problem.test();
  }

  private void test() {
    int[] tc1a = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    int[] tc2a = {3, 2, 1, 5, 6, 4};
    int[] tc3a = {-1, 2, 0};

    System.out.println(findKthLargest(tc1a, 4));
    System.out.println(findKthLargest(tc2a, 2));
    System.out.println(findKthLargest(tc3a, 1));
  }

  public int findKthLargest(int[] nums, int k) {
    int l = 0;
    int r = nums.length - 1;

    int pos = k - 1;

    while (true) {
      int index = partition(nums, l, r);

      if (index == pos) {
        return nums[index];
      } else if (pos < index) {
        r = index - 1;
      } else {
        l = index + 1;
      }
    }
  }

  private int partition(int[] nums, int l, int r) {
    int pivot = nums[l];
    int i = l + 1;
    int j = r;

    while (true) {
      while (i < r && nums[i] > pivot) {
        i++;
      }

      while (j > l && nums[j] <= pivot) {
        j--;
      }

      if (i >= j) {
        break;
      }

      swap(nums, i, j);

      i++;
      j--;
    }

    swap(nums, l, j);

    return j;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private static class QuickSelectApproach {
    public int findKthLargest(int[] nums, int k) {
      int l = 0, r = nums.length - 1;
      k = nums.length - k;

      while (l < r) {
        int pivotIndex = partition(l, r, nums);

        if (pivotIndex < k) {
          l = pivotIndex + 1;
        } else if (pivotIndex > k) {
          r = pivotIndex - 1;
        } else {
          break;
        }
      }

      return nums[k];
    }

    private int partition(int l, int r, int[] a) {
      int pivot = a[l];
      int i = l + 1, j = r;

      while (true) {
        while (i < r && a[i] < pivot) {
          i++;
        }

        while (j > l && a[j] > pivot) {
          j--;
        }

        if (i >= j) {
          break;
        }

        swap(i, j, a);

        i++;
        j--;
      }

      swap(l, j, a);

      return j;
    }

    private void swap(int i, int j, int[] a) {
      int temp = a[j];
      a[j] = a[i];
      a[i] = temp;
    }
  }

  private static class HeapApproach {

    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> heap = new PriorityQueue<>(k);

      for (int i = 0; i < nums.length; i++) {
        if (heap.size() < k) {
          heap.add(nums[i]);
        } else {
          if (heap.peek() < nums[i]) {
            heap.poll();
            heap.add(nums[i]);
          }
        }
      }

      return heap.poll();
    }
  }

}

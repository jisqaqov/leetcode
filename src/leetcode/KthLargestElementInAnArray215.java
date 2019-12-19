package leetcode;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Jandos Iskakov
 * problem: 215. Kth Largest Element in an Array
 * algorithm: QuickSelect, Sort
 * time complexity: O(n)
 * space complexity: O(n)
 * Runtime: 1 ms, faster than 99.53% of Java online submissions
 * Memory Usage: 36.8 MB, less than 90.16% of Java online submissions
 */
public class KthLargestElementInAnArray215 {

  public static void main(String[] args) {
    KthLargestElementInAnArray215 problem = new KthLargestElementInAnArray215();
    problem.test();
  }

  private void test() {
    int[] tc1a = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    int[] tc2a = {3, 2, 1, 5, 6, 4};
    int[] tc3a = {2, 4, 3};
    int[] tc4a = {3, 1, 2, 4};

    System.out.println(findKthLargest(tc1a, 4));//4
    System.out.println(findKthLargest(tc2a, 2));//5
    System.out.println(findKthLargest(tc3a, 1));//4
    System.out.println(findKthLargest(tc4a, 2));//3
  }

  public int findKthLargest(int[] nums, int k) {
    int low = 0;
    int high = nums.length - 1;

    k = nums.length - k;

    while (low <= high) {
      int pivotIndex = partition(nums, low, high);

      if (pivotIndex < k) {
        low = pivotIndex + 1;
      } else {
        high = pivotIndex - 1;
      }
    }

    return nums[low];
  }

  private int partition(int[] nums, int low, int high) {
    if (low == high) {
      return low;
    }

    Random random = new Random();

    int randomIndex = low + random.nextInt(high - low);
    swap(nums, randomIndex, high);

    int index = low;

    for (int i = low; i < high; i++) {
      if (nums[i] < nums[high]) {
        swap(nums, i, index);
        index++;
      }
    }

    swap(nums, index, high);

    return index;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private class V2 {
    private int partition(int[] nums, int low, int high) {
      if (low == high) {
        return low;
      }

      Random random = new Random();

      int randomIndex = low + random.nextInt(high - low);
      swap(nums, randomIndex, low);

      int i = low + 1;
      int j = high;

      while (true) {
        while (i < high && nums[i] <= nums[low]) {
          i++;
        }

        while (j > low && nums[j] >= nums[low]) {
          j--;
        }

        if (i >= j) {
          break;
        }

        swap(nums, i, j);

        i++;
        j--;
      }

      swap(nums, low, j);

      return j;
    }
  }

  private class V3 {

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

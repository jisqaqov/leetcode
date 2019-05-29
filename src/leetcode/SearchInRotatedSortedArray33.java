package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 33. Search in Rotated Sorted Array
 * time complexity: O(logn)
 * space complexity: O(1)
 * algorithm: Binary Search
 * Runtime: 0 ms, faster than 100.00%.
 * Memory Usage: 39.1 MB, less than 55.18%.
 */
public class SearchInRotatedSortedArray33 {

    public static void main(String[] args) {
        SearchInRotatedSortedArray33 solution = new SearchInRotatedSortedArray33();
        solution.test();
    }

    public void test() {
        System.out.println(search(new int[] {3,1}, 3));
        System.out.println(search(new int[] {3,1}, 1));
        System.out.println(search(new int[] {4,5,6,7,8,9,0,1,2,3}, 0));
        System.out.println(search(new int[] {4,5,6,7,8,9,0,1,2,3}, 3));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;

        int pivot = findPivotIndex(nums);

        if (pivot != -1) {
            if (nums[l] <= target && target <= nums[pivot]) {
                r = pivot;
            } else {
                l = pivot + 1;
            }
        }

        while (l <= r) {
            int m = l + (r - l)/2;

            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    private int findPivotIndex(int[] nums) {
        int l = 0, r = nums.length - 1;

        if (nums[0] <= nums[r]) {
            return -1;
        }

        int pivot = -1;

        while (l <= r) {
            int m = l + (r - l)/2;

            if (nums[m] > nums[nums.length - 1]) {
                pivot = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return pivot;
    }

}


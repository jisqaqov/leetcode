package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 33. Search in Rotated Sorted Array
 * time complexity: O(logn)
 * space complexity: O(1)
 * algorithm: Binary Search
 * Runtime: 0 ms, faster than 100.00%.
 * Memory Usage: 36.6 MB, less than 99.55%.
 */
public class SearchInRotatedSortedArray33v2 {

    public static void main(String[] args) {
        SearchInRotatedSortedArray33v2 solution = new SearchInRotatedSortedArray33v2();
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

        while (l <= r) {
            int m = l + (r - l)/2;

            if (nums[m] == target) {
                return m;
            }

            if (nums[l] <= nums[r]) {
                if (nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (target >= nums[l] && target <= nums[m]) {
                    r = m - 1;
                } else if (target >= nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else if (nums[m] <= nums[r]) {
                    r = m - 1;
                } else if (nums[l] <= nums[m]) {
                    l = m + 1;
                }
            }
        }

        return -1;
    }

}


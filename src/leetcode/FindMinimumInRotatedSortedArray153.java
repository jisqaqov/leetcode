package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 153. Find Minimum in Rotated Sorted Array
 * algorithm: Binary Search
 * time complexity:
 * space complexity:
 */
public class FindMinimumInRotatedSortedArray153 {

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray153 solution = new FindMinimumInRotatedSortedArray153();
        solution.test();
    }

    public void test() {
        System.out.println(findMin(new int[] {3,1,2}));
        System.out.println(findMin(new int[] {3,4,5,1,2}));
        System.out.println(findMin(new int[] {3,4,5,2}));
        System.out.println(findMin(new int[] {4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[] {4,5,6,7,1}));
        System.out.println(findMin(new int[] {1,2,3,4,5,6}));
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
                if (nums[mid] < nums[min]) {
                    min = mid;
                }
            }
        }

        return nums[min];
    }

}

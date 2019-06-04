package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 34. Find First and Last Position of Element in Sorted Array
 * algorithm: Binary Search
 * time complexity: O(log(n))
 * space complexity: O(1)
 */
public class FindFirstAndLastPositionOfElementInSortedArray34 {

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray34 solution = new FindFirstAndLastPositionOfElementInSortedArray34();
        solution.test();
    }

    public void test() {
        int[] tc1a = {5,7,7,8,8,10};
        int[] tc2a = {1};

        printArray(searchRange(tc1a, 8));
        printArray(searchRange(tc1a, 6));
        printArray(searchRange(tc2a, 1));
    }

    private void printArray(int[] array) {
        for (int number : array) {
          System.out.print(number + " ");
        }
        System.out.println();
    }

    public int[] searchRange(int[] nums, int target) {
        int[] solution = {-1, -1};

        if (nums.length == 0) {
            return solution;
        }

        solution = new int[]{findFirstPosition(nums, target), findLastPosition(nums, target)};
        return solution;
    }

    private int findFirstPosition(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        int position = -1;

        while (l <= r && nums[l] <= target && nums[r] >= target) {
            int middle = l + (r - l) / 2;
            if (nums[middle] == target) {
                position = middle;
                r = middle - 1;
            } else if (nums[middle] < target) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }

        return position;
    }

    private int findLastPosition(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        int position = -1;

        while (l <= r && nums[l] <= target && nums[r] >= target) {
            int middle = l + (r - l) / 2;
            if (nums[middle] == target) {
                position = middle;
                l = middle + 1;
            } else if (nums[middle] < target) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }

        return position;
    }

}

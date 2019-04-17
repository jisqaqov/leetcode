package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 239. Sliding Window Maximum
 * algorithm: Sliding Window Technique, Stack
 * time complexity: O(n)
 * space complexity: O(k)
 */
public class SlidingWindowMaximum239 {

    public static void main(String[] args) {
        SlidingWindowMaximum239 solution = new SlidingWindowMaximum239();
        solution.test();
    }

    public void test() {
        int[] tc1a = {1,3,-1,-3,5,3,6,7};
        int[] tc1o = maxSlidingWindow(tc1a, 3);
        printArray(tc1o);
    }

    private void printArray(int[] a) {
        for (int number: a)
            System.out.print(number + " ");

        System.out.println();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return nums;

        int[] windows = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        fillWindow(k - 1, k, deque, nums);

        int w = 0;
        windows[w++] = deque.peek();

        Integer max = null;
        for (int i = k; i < nums.length; i++, w++) {
            deque.pop();

            if (deque.isEmpty()) {
                fillWindow(i, k, deque, nums);
                max = null;
            }

            if (max == null) {
                max = nums[i];
            }

            max = Math.max(max, nums[i]);

            windows[w] = Math.max(deque.peek(), max);
        }

        return windows;
    }

    private void fillWindow(int j, int k, Deque<Integer> deque, int[] nums) {
        for (int i = j; i >= j - k + 1; i--) {
            if (deque.isEmpty()) {
                deque.push(nums[i]);
            } else {
                deque.push(nums[i] > deque.peek()? nums[i]: deque.peek());
            }
        }
    }


}

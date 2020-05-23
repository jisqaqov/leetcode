package leetcode.p0014;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 503. Next Greater Element II
 * algorithm: Stack
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class NextGreaterElementII503 {

    public static void main(String[] args) {
        NextGreaterElementII503 solution = new NextGreaterElementII503();
        solution.test();
    }

    public void test() {
        int[] tc1a = {1, 2, 1};
        int[] tc1o = nextGreaterElements(tc1a);

        printArray(tc1o);
    }

    private void printArray(int[] a) {
        for (int number : a)
            System.out.print(number + " ");

        System.out.println();
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                res[index] = nums[i];
            }

            stack.push(i);
        }

        for (int num : nums) {
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                int index = stack.pop();
                res[index] = num;
            }
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            res[index] = -1;
        }

        return res;
    }



}

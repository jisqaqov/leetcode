package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 198. House Robber
 * algorithm: DP
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class HouseRobber198 {

    public static void main(String[] args) {
        HouseRobber198 solution = new HouseRobber198();
        solution.test();
    }

    public void test() {
        System.out.println(rob(new int[] {2,7,9,3,1}));
        System.out.println(rob(new int[] {1,2,3,1}));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> memo = new HashMap<>();
        return rob(nums, nums.length - 1, memo);
    }

    public int rob(int[] nums, int n, Map<Integer, Integer> memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return nums[n];
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int max = Math.max(rob(nums, n - 1, memo), rob(nums, n - 2, memo) + nums[n]);
        memo.put(n, max);

        return max;
    }

}

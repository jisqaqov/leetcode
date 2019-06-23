package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 213. House Robber II
 * algorithm: DP
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class HouseRobber213 {

    public static void main(String[] args) {
        HouseRobber213 solution = new HouseRobber213();
        solution.test();
    }

    public void test() {
        System.out.println(rob(new int[] {2,3,2}));
        System.out.println(rob(new int[] {1,2,3,1}));
        System.out.println(rob(new int[] {1,1,1,2}));
        System.out.println(rob(new int[] {2,2,4,3,2,5}));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[][] max = new int[nums.length][2];

        for (int k = 0; k < nums.length; k++) {
            if (k == 0) {
                max[k][0] = 0;
                max[k][1] = nums[0];
            } else if (k == 1) {
                max[k][0] = nums[k];
                max[k][1] = Math.max(nums[0], nums[1]);
            } else if (k < nums.length - 1) {
                max[k][0] = Math.max(max[k - 2][0] + nums[k], max[k - 1][0]);
                max[k][1] = Math.max(max[k - 2][1] + nums[k], max[k - 1][1]);
            } else if (k == nums.length - 1) {
                max[k][1] = Math.max(Math.max(max[k - 1][0], max[k - 1][1]),
                        Math.max(max[k - 2][1], max[k - 2][0] + nums[k]));
            }
        }

        return max[nums.length - 1][1];
    }

}

package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 300. Longest Increasing Subsequence
 * algorithm: DP
 * time complexity: O(n^2)
 * space complexity: O(n)
 */
public class LongestIncreasingSubsequence300 {

    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];

        int globalMaxList = 0;
        for (int i = 0; i < nums.length; i++) {
            int localMaxLis = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && lis[j] > localMaxLis)
                    localMaxLis = lis[j];
            }

            lis[i] = localMaxLis + 1;

            if (globalMaxList < lis[i])
                globalMaxList = lis[i];
        }

        return globalMaxList;
    }

}

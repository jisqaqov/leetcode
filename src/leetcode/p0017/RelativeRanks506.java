package leetcode.p0017;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 506. Relative Ranks
 * algorithm: Two Pointer Technique
 * time complexity: O(nlogn)
 * notes: faster than 91.96% of Java online submissions
 */
public class RelativeRanks506 {

    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;

        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);

        Map<Integer, String> map = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            if (i  == n - 1) {
                map.put(sorted[i], "Gold Medal");
            } else if (i == n - 2) {
                map.put(sorted[i], "Silver Medal");
            } else if (i == n - 3) {
                map.put(sorted[i], "Bronze Medal");
            } else {
                map.put(sorted[i], String.valueOf(n - i));
            }
        }

        String[] ranks = new String[nums.length];
        for (int i = 0; i < n; i++)
            ranks[i] = map.get(nums[i]);

        return ranks;
    }

}

package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 1. Two Sum
 * time complexity: O(n)
 * space complexity: O(n)
 * algorithm: used ds as HashTable
 */
public class TwoSum1 {

    public static void main(String[] args) {
        TwoSum1 solution = new TwoSum1();

        solution.test();
    }

    public void test() {
        int[] tc1r = twoSum(new int[] {2, 11, 15, 7}, 9);
        System.out.println(tc1r[0] + " " + tc1r[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int subtr = target - nums[i];

            if (map.containsKey(subtr)) {
                result[0] = map.get(subtr);
                result[1] = i;

                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }

}


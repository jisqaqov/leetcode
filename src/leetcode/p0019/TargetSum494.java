package leetcode.p0019;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 494. Target Sum
 * algorithm: based on recurrence formula f(s) = f(s - a[p0009]) + f(s + a[p0009])
 * variable memo used to memorize results
 * consider every number as +a[p0009] or -a[p0009]
 */
public class TargetSum494 {

    public static void main(String[] args) {
        TargetSum494 solution = new TargetSum494();

        solution.test();
    }

    public void test() {
        int[] tc1a = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(tc1a, 3));
    }

    public int findTargetSumWays(int a[], int s) {
        return findTargetSumWays(a, s, 0, new HashMap<>());
    }

    private int findTargetSumWays(int a[], int s, int i, Map<String, Integer> memo) {
        if (i == a.length - 1)
            return Math.abs(s) == Math.abs(a[i])? (a[i] == 0? 2: 1): 0;

        String hash = s + ":" + i;

        if (memo.containsKey(hash))
            return memo.get(hash);

        int k = findTargetSumWays(a,s - a[i], i + 1, memo) +
                findTargetSumWays(a,s + a[i], i + 1, memo);

        memo.put(hash, k);

        return k;
    }

}


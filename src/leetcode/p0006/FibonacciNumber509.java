package leetcode.p0006;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 509. Fibonacci Number
 * algorithm: DP, Recursion, Array
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 35.8 MB, less than 5.51% of Java online submissions
 */
public class FibonacciNumber509 {

  public int fib(int n) {
    if (n <= 1) {
      return n;
    }

    int f0 = 0;
    int f1 = 1;

    for (int i = 2; i <= n; i++) {
      int fn = f0 + f1;
      f0 = f1;
      f1 = fn;
    }

    return f1;
  }

  private static class RecursionVersion {

    private int[] dp = new int[31];

    public int fib(int n) {
      if (n <= 1) {
        return n;
      }

      if (dp[n] != 0) {
        return dp[n];
      }

      int fn = fib(n - 1) + fib(n - 2);

      dp[n] = fn;

      return fn;
    }

  }


}
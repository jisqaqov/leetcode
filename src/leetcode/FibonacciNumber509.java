package leetcode;

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
    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
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

    private Map<Integer, Integer> dp = new HashMap<>();

    public int fib(int n) {
      if (n == 0) {
        return 0;
      }

      if (n == 1) {
        return 1;
      }

      if (dp.containsKey(n)) {
        return dp.get(n);
      }

      int fn = fib(n - 1) + fib(n - 2);

      dp.put(n, fn);

      return fn;
    }

  }


}
package leetcode;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 1155. Number of Dice Rolls With Target Sum
 * algorithm: DP
 * time complexity: O(d*f*target)
 * space complexity: O(d*target)
 * Runtime: 12 ms, faster than 79.23% of Java online submissions
 * Memory Usage: 38.5 MB, less than 100.00% of Java online submissions
 */
public class NumberOfDiceRollsWithTargetSum1155 {

  public static void main(String[] args) {
    NumberOfDiceRollsWithTargetSum1155 problem = new NumberOfDiceRollsWithTargetSum1155();
    problem.test();
  }

  private void test() {
    System.out.println(numRollsToTarget(1, 6, 3));//1
    System.out.println(numRollsToTarget(2, 6, 7));//6
    System.out.println(numRollsToTarget(30, 30, 500));//222616187
  }

  private static int LIMIT = (int) (Math.pow(10, 9.0) + 7);

  public int numRollsToTarget(int d, int f, int target) {
    int[][] dp = new int[d + 1][target + 1];

    for (int i = 0; i <= d; i++) {
      Arrays.fill(dp[i], -1);
    }

    return helper(dp, d, f, target);
  }

  private int helper(int[][] dp, int d, int f, int target) {
    if (dp[d][target] != -1) {
      return dp[d][target];
    }

    if (d == 1) {
      return f >= target? 1: 0;
    }

    int count = 0;
    for (int face = 1; face <= Math.min(f, target - 1); face++) {
      count += helper(dp, d - 1, f, target - face);
      count %= LIMIT;
    }

    dp[d][target] = count;

    return dp[d][target];
  }

  private static class V2 {

    public int numRollsToTarget(int d, int f, int target) {
      int[][] dp = new int[d + 1][target + 1];

      for (int t = 1; t <= target; t++) {
        dp[1][t] = f >= t? 1: 0;
      }

      for (int dice = 2; dice <= d; dice++) {
        for (int t = 1; t <= target; t++) {
          int count = 0;

          for (int face = 1; face <= Math.min(f, t); face++) {
            count += dp[dice - 1][t - face];
            count %= LIMIT;
          }

          dp[dice][t] = count;
        }
      }

      return dp[d][target];
    }

  }

}
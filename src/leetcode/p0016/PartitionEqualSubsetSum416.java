package leetcode.p0016;

/**
 * @author Jandos Iskakov
 * problem: 416. Partition Equal Subset Sum
 * algorithm: DP
 * time complexity: O(N * SUM)
 * space complexity: O(N * SUM)
 * Runtime: 10 ms, faster than 70.93% of Java online submissions
 * Memory Usage: 37 MB, less than 95.24% of Java online submissions
 */
public class PartitionEqualSubsetSum416 {

  public static void main(String[] args) {
    PartitionEqualSubsetSum416 problem =
      new PartitionEqualSubsetSum416();
    problem.test();
  }

  private void test() {
    System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    System.out.println(canPartition(new int[]{1, 2, 3, 5}));
    System.out.println(canPartition(new int[]{1, 2, 5}));
  }

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }

    if (sum % 2 == 1) {
      return false;
    }

    sum /= 2;

    boolean[] dp = new boolean[sum + 1];
    dp[0] = true;

    for (int num : nums) {
      for (int i = sum; i >= num; i--) {
        if (dp[i - num]) {
          dp[i] = dp[i - num];
        }
      }
    }

    return dp[sum];
  }

  private static class V2 {

    public boolean canPartition(int[] nums) {
      int sum = 0;
      for (int num : nums) {
        sum += num;
      }

      if (sum % 2 == 1) {
        return false;
      }

      sum /= 2;
      int n = nums.length;

      boolean[][] dp = new boolean[n + 1][sum + 1];

      dp[0][0] = true;

      for (int i = 1; i <= n; i++) {
        dp[i][0] = true;
      }

      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= sum; j++) {
          dp[i][j] = dp[i - 1][j];

          if (j >= nums[i - 1]) {
            dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
          }
        }
      }

      return dp[n][sum];
    }

  }


}

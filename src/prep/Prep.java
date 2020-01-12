package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();

    problem.test();
  }

  private void test() {
    System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    System.out.println(canPartition(new int[]{1, 2, 3, 5}));
  }

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }

    if (sum % 2 == 1) {
      return false;
    }

    int n = nums.length;
    sum /= 2;

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
package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(countSubstrings("abc"));
    System.out.println(countSubstrings("aaa"));
  }

  public int countSubstrings(String s) {
    if (s.length() == 0) {
      return 0;
    }

    int n = s.length();

    boolean[][] dp = new boolean[n][n];
    dp[0][0] = true;

    for (int i = 1; i < n; i++) {
      dp[i][i] = true;

      if (s.charAt(i - 1) == s.charAt(i)) {
        dp[i - 1][i] = true;
      }

      for (int j = i - 1; j > 0; j--) {
        if (dp[j][i - 1] && s.charAt(j - 1) == s.charAt(i)) {
          dp[j - 1][i] = true;
        }
      }
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (dp[i][j]) {
          count++;
        }
      }
    }

    return count;
  }

}
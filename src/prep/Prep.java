package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(countSubstrings("babad"));
    System.out.println(countSubstrings("cbbd"));
  }

  public String countSubstrings(String s) {
    if (s.length() == 0) {
      return "";
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

    int maxLen = 0;
    int[] idx = new int[2];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!dp[i][j]) {
          continue;
        }

        int len = j - i + 1;
        if (len > maxLen) {
          maxLen = len;
          idx[0] = i;
          idx[1] = j;
        }
      }
    }

    return s.substring(idx[0], idx[1] + 1);
  }

}
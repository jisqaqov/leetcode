package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();

    problem.test();
  }

  private void test() {
    System.out.println(isMatch("aa", "a"));//false
    System.out.println(isMatch("aa", "a*"));//true
    System.out.println(isMatch("ab", ".*"));//true
    System.out.println(isMatch("aab", "c*a*b"));//true
  }

  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

    dp[0][0] = true;

    for (int j = 2; j <= p.length(); j+= 2) {
      if (p.charAt(j - 1) == '*') {
        dp[0][j] = dp[0][j - 2];
      }
    }

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= p.length(); j++) {
        char chS = s.charAt(i - 1);
        char chP = p.charAt(j - 1);

        if (chS == chP || chP == '.') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (chP == '*') {
          dp[i][j] = dp[i][j - 2];
          if (chS == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
            dp[i][j] = dp[i][j] || dp[i - 1][j];
          }
        }
      }
    }

    return dp[s.length()][p.length()];
  }


}
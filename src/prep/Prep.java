package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }


  private void test() {
    System.out.println(isMatch("aa", "a"));//false
    System.out.println(isMatch("aa", "*"));//true
    System.out.println(isMatch("cb", "?a"));//false
    System.out.println(isMatch("adceb", "*a*b"));//true
    System.out.println(isMatch("acdcb", "a*c?b"));//false
  }

  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;

    for (int i = 1; i <= p.length(); i++) {
      if (p.charAt(i - 1) == '*') {
        dp[0][i] = dp[0][i - 1];
      }
    }

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= p.length(); j++) {
        char sch = s.charAt(i - 1);
        char pch = p.charAt(j - 1);

        if (sch == pch || pch == '?') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (pch == '*') {
          dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
        }
      }
    }

    return dp[s.length()][p.length()];
  }


}
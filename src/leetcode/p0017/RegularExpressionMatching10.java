package leetcode.p0017;

/**
 * @author Jandos Iskakov
 * problem: 10. Regular Expression Matching
 * algorithm: DP
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 * Runtime: 2 ms, faster than 92.59% of Java online submissions
 * Memory Usage: 36.7 MB, less than 100.00% of Java online submissions
 */
public class RegularExpressionMatching10 {

  public static void main(String[] args) {
    RegularExpressionMatching10 problem = new RegularExpressionMatching10();

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
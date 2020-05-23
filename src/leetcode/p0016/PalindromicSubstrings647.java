package leetcode.p0016;

/**
 * @author Jandos Iskakov
 * problem: 647. Palindromic Substrings
 * algorithm: DP
 * time complexity: O(N^2)
 * space complexity: O(N^2)
 * Runtime: 5 ms, faster than 44.24% of Java online submissions for Palindromic Substrings.
 * Memory Usage: 35.8 MB, less than 63.29% of Java online submissions for Palindromic Substrings.
 */
public class PalindromicSubstrings647 {

  public static void main(String[] args) {
    PalindromicSubstrings647 problem = new PalindromicSubstrings647();
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

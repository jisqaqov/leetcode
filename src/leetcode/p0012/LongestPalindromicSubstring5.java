package leetcode.p0012;

/**
 * @author Jandos Iskakov
 * problem: 5. Longest Palindromic Substring
 * algorithm: Dynamic Programming
 * time complexity: O(n^2)
 * space complexity: O(n^2)
 * Runtime: 45 ms, faster than 35.69% of Java online submissions for Longest Palindromic Substring.
 * Memory Usage: 37.2 MB, less than 93.95% of Java online submissions for Longest Palindromic Substring.
 */
public class LongestPalindromicSubstring5 {

  public static void main(String[] args) {
    LongestPalindromicSubstring5 solution = new LongestPalindromicSubstring5();
    solution.test();
  }

  public void test() {
    System.out.println(longestPalindrome("abcd"));
    System.out.println(longestPalindrome("babad"));
    System.out.println(longestPalindrome("cbbd"));
    System.out.println(longestPalindrome("aaabbbbsas"));
    System.out.println(longestPalindrome("bananas"));
    System.out.println(longestPalindrome("aaabaaaa"));
    System.out.println(longestPalindrome("ababababababa"));
    System.out.println(longestPalindrome("tattarrattat"));
    System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaa"));
  }

  public String longestPalindrome(String s) {
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

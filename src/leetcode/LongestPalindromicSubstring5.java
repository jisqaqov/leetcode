package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 5. Longest Palindromic Substring
 * algorithm: Dynamic Programming
 * time complexity: O(n^2)
 * space complexity: O(n^2)
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
    int n = s.length();

    if (n == 0) {
      return s;
    }

    boolean[][] memo = new boolean[n][n];
    memo[0][0] = true;

    for (int i = 1; i < n; i++) {
      char ch = s.charAt(i);

      memo[i][i] = true;

      if (ch == s.charAt(i - 1)) {
        memo[i - 1][i] = true;
      }

      for (int b = 1; b < n; b++) {
        if (memo[b][i - 1] && ch == s.charAt(b - 1)) {
          memo[b - 1][i] = true;
        }
      }
    }

    int[] max = new int[2];
    int k = 1;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (!memo[i][j]) {
          continue;
        }

        if (j - i + 1 > k) {
          k = j - i + 1;
          max[0] = i;
          max[1] = j;
        }
      }
    }

    return s.substring(max[0], max[1] + 1);
  }

}

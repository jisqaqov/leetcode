package leetcode;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 91. Decode Ways
 * algorithm: DP
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 98.54% of Java online submissions for Decode Ways.
 * Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Decode Ways.
 */
public class DecodeWays91 {

  public static void main(String[] args) {
    DecodeWays91 problem = new DecodeWays91();
    problem.test();
  }

  private void test() {
    System.out.println(numDecodings("101"));//1
    System.out.println(numDecodings("100"));//0
    System.out.println(numDecodings("27"));//0
    System.out.println(numDecodings("0"));//0
    System.out.println(numDecodings("00"));//0
    System.out.println(numDecodings("12"));//2
    System.out.println(numDecodings("226"));//3
    System.out.println(numDecodings("1001"));//0

    System.out.println("v2:");
    V2 v2 = new V2();

    System.out.println(v2.numDecodings("101"));//1
    System.out.println(v2.numDecodings("100"));//0
    System.out.println(v2.numDecodings("27"));//0
    System.out.println(v2.numDecodings("0"));//0
    System.out.println(v2.numDecodings("00"));//0
    System.out.println(v2.numDecodings("12"));//2
    System.out.println(v2.numDecodings("226"));//3
    System.out.println(v2.numDecodings("1001"));//0
  }

  public int numDecodings(String s) {
    if (s.isEmpty()) {
      return 0;
    }

    char[] chs = s.toCharArray();

    int[] dp = new int[s.length() + 1];

    dp[0] = 1;
    if (chs[0] > '0') {
      dp[1] = 1;
    }

    for (int i = 2; i <= s.length(); i++) {
      int digit = chs[i - 1] - '0';

      int num = (chs[i - 2] - '0') * 10 + digit;

      if (digit > 0) {
        dp[i] = dp[i - 1];
      }

      if (num >= 10 && num <= 26) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[s.length()];
  }

  private static class V1 {

    public int numDecodings(String s) {
      if (s.isEmpty()) {
        return 0;
      }

      int[] dp = new int[s.length() + 1];
      dp[0] = 1;

      int k = 1;

      for (int i = 0; i < s.length(); i++) {
        int b = Character.getNumericValue(s.charAt(i));

        if (b > 0) {
          dp[k] += dp[k - 1];
        }

        if (i > 0) {
          int a = Character.getNumericValue(s.charAt(i - 1));
          int num = a * 10 + b;
          if (num >= 10 && num <= 26) {
            dp[k] += dp[k - 2];
          }
        }

        k++;
      }

      return dp[s.length()];
    }
  }

  private static class V2 {

    public int numDecodings(String s) {
      int[] dp = new int[s.length()];
      Arrays.fill(dp, -1);

      return numDecodings(s, dp, 0);
    }

    public int numDecodings(String s, int[] dp, int index) {
      if (index >= dp.length) {
        return 1;
      }

      if (dp[index] != -1) {
        return dp[index];
      }

      int num = 0;
      int cnt = 0;

      for (int i = index; i < s.length(); i++) {
        num = num * 10 + (s.charAt(i) - '0');

        if (num > 26 || num == 0) {
          break;
        }

        int k = numDecodings(s, dp, i + 1);
        cnt += k;
      }

      dp[index] = cnt;

      return cnt;
    }
  }

  private static class V3 {
    public int numDecodings(String s) {
      int[] dp = new int[s.length()];
      Arrays.fill(dp, -1);

      return numDecodings(s, 0, dp);
    }

    public int numDecodings(String s, int index, int[] dp) {
      if (index >= s.length()) {
        return 1;
      }

      if (dp[index] != -1) {
        return dp[index];
      }

      dp[index] = 0;

      int a = Character.getNumericValue(s.charAt(index));
      if (a > 0) {
        dp[index] += numDecodings(s, index + 1, dp);
      }

      if (index < s.length() - 1) {
        int b = Character.getNumericValue(s.charAt(index + 1));
        int number = a * 10 + b;
        if (number >= 10 && number <= 26) {
          dp[index] += numDecodings(s, index + 2, dp);
        }
      }

      return dp[index];
    }
  }

}

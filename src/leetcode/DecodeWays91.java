package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 91. Decode Ways
 * algorithm: DP
 * time complexity: O(N^2)
 * space complexity: O(N^2)
 * Runtime: 2 ms, faster than 55.31% of Java online submissions for Decode Ways.
 * Memory Usage: 36.2 MB, less than 70.75% of Java online submissions for Decode Ways.
 */
public class DecodeWays91 {

  public static void main(String[] args) {
    DecodeWays91 problem = new DecodeWays91();
    problem.test();
  }

  private void test() {
//    System.out.println(numDecodings("101"));//1
//    System.out.println(numDecodings("100"));//0
//    System.out.println(numDecodings("27"));//0
//    System.out.println(numDecodings("0"));//0
//    System.out.println(numDecodings("00"));//0
//    System.out.println(numDecodings("12"));//2
//    System.out.println(numDecodings("226"));//3

    System.out.println("v2:");
    V2 v2 = new V2();

    System.out.println(v2.numDecodings("101"));//1
    System.out.println(v2.numDecodings("100"));//0
    System.out.println(v2.numDecodings("27"));//0
    System.out.println(v2.numDecodings("0"));//0
    System.out.println(v2.numDecodings("00"));//0
    System.out.println(v2.numDecodings("12"));//2
    System.out.println(v2.numDecodings("226"));//3
  }

  public int numDecodings(String s) {
    if (s.isEmpty()) {
      return 0;
    }

    int[] dp = new int[s.length()];

    int num = Character.getNumericValue(s.charAt(0));

    if (num >= 1 && num <= 9) {
      dp[0] = 1;
    }

    for (int i = 1; i < s.length(); i++) {
      int n1 = Character.getNumericValue(s.charAt(i - 1));
      int n2 = Character.getNumericValue(s.charAt(i));

      if (n1 == 0 && n2 == 0) {
        return 0;
      }

      int k = n1 * 10 + n2;

      if (i == 1) {
        if (n1 > 0 && n2 > 0 && k <= 26) {
          dp[i] = 2;
        } else {
          dp[i] = dp[i - 1];
        }
      } else {
        dp[i] = dp[i - 1] + dp[i - 2];
      }
    }

    return dp[s.length() - 1];
  }

  private static class V2 {
    public int numDecodings(String s) {
      return numDecodings(s, 0, new HashMap<>());
    }

    public int numDecodings(String s, int index, Map<Integer, Integer> map) {
      if (map.containsKey(index)) {
        return map.get(index);
      }

      int count = 0;
      int number = 0;

      for (int i = index; i < Math.min(s.length(), index + 2); i++) {
        int digit = Character.getNumericValue(s.charAt(i));

        number = number * 10 + digit;

        if (number < 1 || number > 26) {
          break;
        }

        int nextIndex = i + 1;
        if (nextIndex == s.length()) {
          count += 1;
        } else {
          int k = numDecodings(s, i + 1, map);
          if (k > 0) {
            count += k;
          }
        }
      }

      map.put(index, count);

      return map.get(index);
    }
  }

}

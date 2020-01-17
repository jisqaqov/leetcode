package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 1027. Longest Arithmetic Sequence
 * algorithm: DP
 * time complexity: O(N^2)
 * space complexity: O(N^2)
 * Runtime: 373 ms, faster than 25.12% of Java online submissions
 * Memory Usage: 178.7 MB, less than 6.67% of Java online submissions
 */
public class LongestArithmeticSequence1027 {

  public static void main(String[] args) {
    LongestArithmeticSequence1027 problem =
      new LongestArithmeticSequence1027();

    problem.test();
  }

  private void test() {
    System.out.println(longestArithSeqLength(new int[]{3, 6, 9, 12}));//4
    System.out.println(longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));//3
    System.out.println(longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));//4
  }

  public int longestArithSeqLength(int[] a) {
    Map<Integer, Integer>[] dp = new HashMap[a.length];

    int max = 0;

    for (int i = 0; i < a.length; i++) {
      dp[i] = new HashMap<>();

      for (int j = 0; j < i; j++) {
        int d = a[i] - a[j];

        int len = dp[i].getOrDefault(d, 0);
        int newLen = dp[j].getOrDefault(d, 1) + 1;

        if (len < newLen) {
          dp[i].put(d, newLen);
        }

        max = Math.max(max, dp[i].get(d));
      }
    }

    return max;
  }


}
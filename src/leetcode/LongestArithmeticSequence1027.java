package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 1027. Longest Arithmetic Sequence
 * algorithm: DP
 * time complexity: O(N^2)
 * space complexity: O(N)
 * Runtime: 3 ms, faster than 88.19% of Java online submissions for Alien Dictionary.
 * Memory Usage: 35.9 MB, less than 97.30% of Java online submissions for Alien Dictionary.
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

        dp[i].put(d, dp[j].getOrDefault(d, 1) + 1);

        max = Math.max(max, dp[i].get(d));
      }
    }

    return max;
  }


}
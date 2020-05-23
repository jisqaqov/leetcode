package leetcode.p0020;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 139. Word Break
 * algorithm: Recursion with memoization, DP
 * time complexity: O(N^2)
 * space complexity: O(N)
 * Runtime: 5 ms, faster than 57.13% of Java online submissions for Word Break.
 * Memory Usage: 37 MB, less than 81.16% of Java online submissions for Word Break.
 */
public class WordBreak139 {

  public static void main(String[] args) {
    WordBreak139 solution = new WordBreak139();
    solution.test();
  }

  public void test() {
    System.out.println(wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));//true
    System.out.println(wordBreak("a", Collections.singletonList("a")));//true
    System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));//true
    System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));//true
    System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));//false
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> words = new HashSet<>(wordDict);

    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        String word = s.substring(j, i);

        if (words.contains(word) && dp[j]) {
          dp[i] = true;
        }
      }
    }

    return dp[s.length()];
  }

  private static class V3 {
    public boolean wordBreak(String s, List<String> wordDict) {
      Set<String> words = new HashSet<>(wordDict);

      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true;

      for (int i = 0; i < s.length(); i++) {
        for (int j = i + 1; j <= s.length(); j++) {
          String word = s.substring(i, j);

          if (words.contains(word) && dp[i]) {
            dp[j] = true;
          }
        }
      }

      return dp[s.length()];
    }
  }

  private static class V2 {

    public boolean wordBreak(String s, List<String> wordDict) {
      Boolean[] memo = new Boolean[s.length()];
      return wordBreak(s, 0, new HashSet<>(wordDict), memo);
    }

    public boolean wordBreak(String s, int index, Set<String> wordDict, Boolean[] memo) {
      if (index == s.length()) {
        return true;
      }

      if (memo[index] != null) {
        return memo[index];
      }

      for (int i = index; i < s.length(); i++) {
        String prefix = s.substring(index, i + 1);
        if (wordDict.contains(prefix)) {
          if (wordBreak(s, i + 1, wordDict, memo)) {
            memo[index] = true;
            return true;
          }
        }
      }

      memo[index] = false;

      return false;
    }
  }

}

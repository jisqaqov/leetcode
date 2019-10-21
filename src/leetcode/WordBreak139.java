package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 139. Word Break
 * algorithm: Recursion with memoization
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
    System.out.println(wordBreak("aaaaa", new ArrayList<>(Arrays.asList("a", "aa", "aaa"))));
    System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
    System.out.println(wordBreak(
      "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
      new ArrayList<>(Arrays
        .asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
          "aaaaaaaaaa"))));
  }

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

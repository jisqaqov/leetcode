package prep;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();

    problem.test();
  }

  private void test() {
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
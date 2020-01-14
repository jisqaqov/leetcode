package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();

    problem.test();
  }

  private void test() {
    System.out
      .println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    System.out.println(wordBreak(
      "pineapplepenapple",
      Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
  }

  public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> words = new HashSet<>(wordDict);

    boolean[] valid = new boolean[s.length() + 1];
    valid[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        String word = s.substring(j, i);
        if (words.contains(word) && valid[j]) {
          valid[i] = true;
        }
      }
    }

    if (!valid[s.length()]) {
      return new ArrayList<>();
    }

    List<String>[] dp = new ArrayList[s.length() + 1];
    dp[0] = new ArrayList<>();
    dp[0].add("");

    for (int i = 1; i <= s.length(); i++) {
      List<String> list = new ArrayList<>();

      for (int j = 0; j < i; j++) {
        String word = s.substring(j, i);

        if (words.contains(word) && !dp[j].isEmpty()) {
          for (String prefix : dp[j]) {
            if (prefix.isEmpty()) {
              list.add(word);
            } else {
              list.add(prefix + " " + word);
            }
          }
        }
      }

      dp[i] = list;
    }

    return dp[s.length()];
  }

}
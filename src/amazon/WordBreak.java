package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import leetcode.WordBreak139;

/**
 * @author Jandos Iskakov
 * problem: variation of 140. Word Break II
 * algorithm: DP, Recursion with memoization
 * time complexity: O(N^2)
 * space complexity: O(N)
 */
public class WordBreak {

  public static void main(String[] args) {
    WordBreak139 solution = new WordBreak139();
    solution.test();
  }

  public void test() {
    System.out.println(wordBreak(
      new ArrayList<>(Arrays.asList("leet", "code", "rock", "star", "rockstarcode", "leetcode"))));
  }

  public List<List<String>> wordBreak(List<String> wordDict) {
    Set<String> wordSet = new HashSet<>(wordDict);

    List<List<String>> solution = new ArrayList<>();

    for (String word : wordDict) {
      LinkedList<String> list = new LinkedList<>();
      Boolean[] memo = new Boolean[word.length()];

      wordBreak(word, 0, wordSet, list, memo);

      solution.add(list);
    }

    return solution;
  }

  private boolean wordBreak(String s, int index, Set<String> wordDict, LinkedList<String> list,
    Boolean[] memo) {
    if (index == s.length()) {
      return true;
    }

    if (memo[index] != null) {
      return memo[index];
    }

    for (int i = index; i < s.length(); i++) {
      String prefix = s.substring(index, i + 1);

      if (wordDict.contains(prefix)) {
        list.add(prefix);

        memo[index] = wordBreak(s, i + 1, wordDict, list, memo);

        if (memo[index] && prefix.length() < s.length()) {
          return true;
        }

        list.removeLast();
      }
    }

    memo[index] = false;

    return false;
  }


}

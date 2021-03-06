package leetcode.p0003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 472. Concatenated Words
 * algorithm: Backtracking, Trie
 * time complexity: O(M*N^2)
 * space complexity: O(M)
 */
public class ConcatenatedWords472 {

  public static void main(String[] args) {
    ConcatenatedWords472 solution = new ConcatenatedWords472();
    solution.test();
  }

  public void test() {
    String[] tc1a = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};

    TrieApproach problem = new TrieApproach();

    System.out.println(problem.findAllConcatenatedWordsInADict(tc1a).size());
  }

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Set<String> dict = new HashSet<>();

    Arrays.sort(words, (w1, w2) -> Integer.compare(w1.length(), w2.length()));

    List<String> output = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      if (isConcatenated(words[i], dict)) {
        output.add(words[i]);
      }

      dict.add(words[i]);
    }

    return output;
  }

  private boolean isConcatenated(String word, Set<String> dict) {
    if (dict.isEmpty()) {
      return false;
    }

    boolean[] dp = new boolean[word.length() + 1];
    dp[0] = true;

    for (int i = 1; i <= word.length(); i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (!dp[j]) {
          continue;
        }

        String substr = word.substring(j, i);
        if (dict.contains(substr)) {
          dp[i] = true;
        }
      }
    }

    return dp[word.length()];
  }

  private static class BacktrackingApproach {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
      Set<String> hash = new HashSet<>(Arrays.asList(words));

      List<String> list = new ArrayList<>();
      for (String word : words) {
        if (concatenated(word, 0, hash)) {
          list.add(word);
        }
      }

      return list;
    }

    private boolean concatenated(String word, int i, Set<String> words) {
      StringBuilder sb = new StringBuilder();

      for (int k = i; k < word.length(); k++) {
        sb.append(word.charAt(k));
        if (words.contains(sb.toString())) {
          if (concatenated(word, k + 1, words)) {
            return true;
          }
        }
      }

      return sb.length() > 0 && sb.length() < word.length() && words.contains(sb.toString());
    }
  }

  private static class TrieApproach {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
      Trie trie = new Trie();

      for (String word : words) {
        trie.addWord(word);
      }

      List<String> solution = new ArrayList<>();

      for (String word : words) {
        if (isConcatenated(trie.root, word, 0)) {
          solution.add(word);
        }
      }

      return solution;
    }

    private boolean isConcatenated(TrieNode root, String word, int index) {
      int counter = 0;

      TrieNode node = root;

      for (int i = index; i < word.length(); i++) {
        counter++;

        char ch = word.charAt(i);

        if (!node.map.containsKey(ch)) {
          return false;
        }

        node = node.map.get(ch);
        if (node.isWord) {
          if (i == word.length() - 1 && counter < word.length()) {
            return true;
          } else if (i < word.length() - 1 && isConcatenated(root, word, i + 1)) {
            return true;
          }
        }
      }

      return false;
    }

    private static class Trie {
      private TrieNode root = new TrieNode();

      private void addWord(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
          char ch = word.charAt(i);

          if (node.map.containsKey(ch)) {
            node = node.map.get(ch);
          } else {
            node.map.put(ch, new TrieNode());
            node = node.map.get(ch);
          }
        }

        node.isWord = true;
      }
    }

    private static class TrieNode {
      Map<Character, TrieNode> map = new HashMap<>();
      boolean isWord = false;
    }

  }

}

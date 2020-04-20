package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 676. Implement Magic Dictionary
 * algorithm: Trie
 * time complexity:
 *  search - O(N*K), k - search word length
 * space complexity: O(N) - n - all words
 * Runtime: 9 ms, faster than 97.85% of Java online submissions
 * Memory Usage: 37.7 MB, less than 6.67% of Java online submissions
 */
public class ImplementMagicDictionary676 {

  public static void main(String[] args) {
    ImplementMagicDictionary676 problem = new ImplementMagicDictionary676();
    problem.test();
  }

  private void test() {
    MagicDictionaryWithTrie dictionary = new MagicDictionaryWithTrie();
    dictionary.buildDict(new String[] {"hello", "hallo", "leetcode"});
    System.out.println(dictionary.search("hhllo"));
  }

  class MagicDictionary {
    private final Map<Integer, List<String>> map;

    /** Initialize your data structure here. */
    public MagicDictionary() {
      map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
      for (String word : dict) {
        map.putIfAbsent(word.length(), new ArrayList<>());
        map.get(word.length()).add(word);
      }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
      if (!map.containsKey(word.length())) {
        return false;
      }

      List<String> dictWords = map.get(word.length());

      for (String dictWord : dictWords) {
        int diff = 0;
        for (int i = 0; i < word.length() && diff <= 1; i++) {
          if (dictWord.charAt(i) != word.charAt(i)) {
            diff++;
          }
        }

        if (diff == 1) {
          return true;
        }
      }

      return false;
    }
  }

  class MagicDictionaryWithTrie {
    private final Trie trie;

    /** Initialize your data structure here. */
    public MagicDictionaryWithTrie() {
      trie = new Trie();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
      for (String word : dict) {
        trie.addWord(word);
      }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
      return helper(0, false, word, trie.root);
    }

    private boolean helper(int index, boolean modified, String word, TrieNode node) {
      if (index == word.length()) {
        return modified && node.isWordEnd;
      }

      char wordChar = word.charAt(index);
      if (modified) {
        if (!node.map.containsKey(wordChar)) {
          return false;
        }

        return helper(index + 1, true, word, node.map.get(wordChar));
      }

      for (char dictChar : node.map.keySet()) {
        if (helper(index + 1, wordChar != dictChar, word, node.map.get(dictChar))) {
          return true;
        }
      }

      return false;
    }

    private class Trie {
      TrieNode root = new TrieNode();

      private void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
          char ch = word.charAt(i);

          if (!node.map.containsKey(ch)) {
            node.map.put(ch, new TrieNode());
          }

          node = node.map.get(ch);
        }

        node.isWordEnd = true;
      }
    }

    private class TrieNode {
      Map<Character, TrieNode> map = new HashMap<>();
      boolean isWordEnd = false;
    }
  }

}
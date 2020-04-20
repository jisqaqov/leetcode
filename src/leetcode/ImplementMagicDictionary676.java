package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 676. Implement Magic Dictionary
 * algorithm: Trie
 * time complexity: O(M)
 * space complexity: O(N)
 * Runtime: 11 ms, faster than 37.12% of Java online submissions
 * Memory Usage: 39.3 MB, less than 6.67% of Java online submissions
 */
public class ImplementMagicDictionary676 {

  public static void main(String[] args) {
    ImplementMagicDictionary676 problem = new ImplementMagicDictionary676();
    problem.test();
  }

  private void test() {
    MagicDictionary dictionary = new MagicDictionary();
    dictionary.buildDict(new String[] {"hello", "hallo", "leetcode"});
    System.out.println(dictionary.search("hhllo"));
  }

  class MagicDictionary {
    private final Trie trie;

    /** Initialize your data structure here. */
    public MagicDictionary() {
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
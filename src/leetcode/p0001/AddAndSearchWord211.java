package leetcode.p0001;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 211. Add and Search Word - Data structure design
 * algorithm: Backtracking, Design, Trie
 * time complexity: O(M) - M- total number of characters
 * space complexity: O(N) - N- length of new word
 * addWord() - O(n), n = length of the new word
 * search() - Worst case: O(m), m = the total number of characters in the Trie
 * Runtime: 50 ms, faster than 65.98% of Java online submissions
 * Memory Usage: 55.2 MB, less than 81.82% of Java online submissions
 */
public class AddAndSearchWord211 {

  public static void main(String[] args) {
    AddAndSearchWord211 problem = new AddAndSearchWord211();
    problem.test();
  }

  private void test() {
    WordDictionary wd = new WordDictionary();
    wd.addWord("bad");
    wd.addWord("dad");
    wd.addWord("mad");

    System.out.println(wd.search("m.d"));//true
    System.out.println(wd.search("bad"));//true
    System.out.println(wd.search("dad"));//true
    System.out.println(wd.search("baz"));//false
    System.out.println(wd.search("baddy"));//false
  }

  class WordDictionary {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
      root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
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

    /**
     * Returns if the word is in the data structure.
     * A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
      return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] word, int index, TrieNode node) {
      if (index == word.length) {
        return node.isWord;
      }

      if (word[index] != '.') {
        if (!node.map.containsKey(word[index])) {
          return false;
        }

        return search(word, index + 1, node.map.get(word[index]));
      } else {
        for (TrieNode adj : node.map.values()) {
          if (search(word, index + 1, adj)) {
            return true;
          }
        }
      }

      return false;
    }

  }

  private static class V2 {
    private boolean search(char[] word, int index, TrieNode root) {
      TrieNode node = root;

      for (; index < word.length; index++) {
        if (word[index] != '.') {
          if (!node.map.containsKey(word[index])) {
            return false;
          }

          node = node.map.get(word[index]);
        } else {
          for (TrieNode adj : node.map.values()) {
            if (search(word, index + 1, adj)) {
              return true;
            }
          }

          return false;
        }
      }

      return node.isWord && index == word.length;
    }
  }

  private class TrieNode {

    private Map<Character, TrieNode> map = new HashMap<>();
    private boolean isWord = false;
  }

}

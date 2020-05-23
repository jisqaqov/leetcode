package leetcode.p0020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * based on solutions from discussions:
 * https://leetcode.com/problems/word-search-ii/discuss/59784/My-simple-and-clean-Java-code-using-DFS-and-Trie
 * https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
 * problem: 212. Word Search II
 * algorithm: Array, Backtracking
 */
public class WordSearchII212 {

  public static void main(String[] args) {
    WordSearchII212 solution = new WordSearchII212();
    solution.test();
  }

  public void test() {
    char[][] tc1board = {
      {'o', 'a', 'a', 'n'},
      {'e', 't', 'a', 'e'},
      {'i', 'h', 'k', 'r'},
      {'i', 'f', 'l', 'v'}
    };

    String[] tc1words = {"oathv", "oath", "pea", "eat", "rain"};

    System.out.println(findWords(tc1board, tc1words));

    char[][] tc2board = {
      {'a', 'a'}
    };

    String[] tc2words = {"aaa"};

    System.out.println(findWords(tc2board, tc2words));
  }

  public List<String> findWords(char[][] board, String[] words) {
    List<String> solution = new ArrayList<>();
    if (words.length == 0) {
      return solution;
    }

    Trie trie = new Trie();
    for (String word : words) {
      trie.add(word);
    }

    int n = board.length, m = board[0].length;

    boolean[][] used = new boolean[n][m];

    Set<String> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        exist(i, j, board, used, trie.root, set);
      }
    }

    return new ArrayList<>(set);
  }

  private void exist(int i, int j, char[][] board, boolean[][] used, TrieNode trieNode,
    Set<String> set) {
    int n = board.length, m = board[0].length;

    if (i < 0 || i >= n || j < 0 || j >= m || used[i][j] || !trieNode.map
      .containsKey(board[i][j])) {
      return;
    }

    trieNode = trieNode.map.get(board[i][j]);
    if (trieNode.isWord) {
      set.add(trieNode.word);
    }

    used[i][j] = true;

    exist(i, j + 1, board, used, trieNode, set);
    exist(i, j - 1, board, used, trieNode, set);
    exist(i + 1, j, board, used, trieNode, set);
    exist(i - 1, j, board, used, trieNode, set);

    used[i][j] = false;
  }

  private static class TrieNode {

    Character ch;
    boolean isWord = false;
    String word;
    Map<Character, TrieNode> map = new HashMap<>();

    TrieNode() {
    }

    TrieNode(char ch) {
      this.ch = ch;
    }
  }

  private static class Trie {

    private TrieNode root = new TrieNode();

    void add(String word) {
      TrieNode node = root;

      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);

        if (node.map.containsKey(ch)) {
          node = node.map.get(ch);
        } else {
          node.map.put(ch, new TrieNode(ch));
          node = node.map.get(ch);
        }
      }

      node.isWord = true;
      node.word = word;
    }
  }

}

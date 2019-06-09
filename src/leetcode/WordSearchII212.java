package leetcode;

import java.util.*;

/**
 * based on solution from discussions:
 * https://leetcode.com/problems/word-search-ii/discuss/59784/My-simple-and-clean-Java-code-using-DFS-and-Trie
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

        String[] tc1words = {"oathv", "oath", "pea","eat","rain"};

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
                exist("", i, j, board, used, trie, set);
            }
        }

        return new ArrayList<>(set);
    }

    private void exist(String word, int i, int j, char[][] board, boolean[][] used, Trie trie, Set<String> set) {
        int n = board.length, m = board[0].length;

        if (i < 0 || i >= n || j < 0 || j >= m || used[i][j]) {
            return;
        }

        word += board[i][j];

        if (!trie.startsWith(word)) {
            return;
        }

        if (trie.search(word)) {
            set.add(word);
        }

        used[i][j] = true;

        exist(word, i, j + 1, board, used, trie, set);
        exist(word, i, j - 1, board, used, trie, set);
        exist(word, i + 1, j, board, used, trie, set);
        exist(word, i - 1, j, board, used, trie, set);

        used[i][j] = false;
    }

    private static class TrieNode {
        Character ch;
        boolean isWord = false;
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
        }

        boolean startsWith(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!node.map.containsKey(ch)) {
                    return false;
                }

                node = node.map.get(ch);
            }

            return true;
        }

        boolean search(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!node.map.containsKey(ch)) {
                    return false;
                }

                node = node.map.get(ch);
            }

            return node.isWord;
        }
    }

}

package leetcode;

import java.util.*;

/**
 * @author Jandos Iskakov
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

        Arrays.sort(words, Comparator.comparingInt(String::length));

        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }

        int n = board.length, m = board[0].length;

        for (String word : words) {
            int existsPrefix = trie.search(word);
            if (existsPrefix == -1) {
                continue;
            }

            if (existsPrefix == 2) {
                solution.add(word);
            } else {
                if (exist(n, m, board, word, trie)) {
                    solution.add(word);
                }
            }
        }

        return solution;
    }

    private boolean exist(int n, int m, char[][] board, String word, Trie trie) {
        boolean[][] used = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }

                used[i][j] = true;
                if (exist(board, word, 0, i, j, used, trie.root)) {
                    return true;
                }
                used[i][j] = false;
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int pos, int i, int j, boolean[][] used, TrieNode trieNode) {
        int n = board.length, m = board[0].length;

        trieNode = trieNode.map.get(word.charAt(pos));
        if (trieNode.exists == null || !trieNode.exists) {
            trieNode.exists = word.charAt(pos) == board[i][j];
        }

        if (word.charAt(pos) != board[i][j]) {
            return false;
        }

        if (pos == word.length() - 1) {
            return true;
        }

        if (j < m - 1 && !used[i][j + 1]) {
            used[i][j + 1] = true;
            if (exist(board, word, pos + 1, i, j + 1, used, trieNode)) {
                return true;
            }
            used[i][j + 1] = false;
        }

        if (j > 0 && !used[i][j - 1]) {
            used[i][j - 1] = true;

            if (exist(board, word, pos + 1, i, j - 1, used, trieNode)) {
                return true;
            }

            used[i][j - 1] = false;
        }

        if (i > 0 && !used[i - 1][j]) {
            used[i - 1][j] = true;
            if (exist(board, word, pos + 1, i - 1, j, used, trieNode)) {
                return true;
            }
            used[i - 1][j] = false;
        }

        if (i < n - 1 && !used[i + 1][j]) {
            used[i + 1][j] = true;
            if (exist(board, word, pos + 1, i + 1, j, used, trieNode)) {
                return true;
            }
            used[i + 1][j] = false;
        }

        return false;
    }

    private static class TrieNode {
        Character ch;
        Boolean exists;
        Map<Character, TrieNode> map = new HashMap<>();

        public TrieNode() {
        }

        public TrieNode(char ch) {
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
        }

        int search(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                node = node.map.get(word.charAt(i));
                if (node.exists == null) {
                    return 1;
                }

                if (!node.exists) {
                    return -1;
                }
            }

            return 2;
        }
    }

}

package leetcode;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: 648. Replace Words
 * algorithm: Trie, Hash Table
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class ReplaceWords648 {

    public static void main(String[] args) {
        ReplaceWords648 solution = new ReplaceWords648();
        solution.test();
    }

    public void test() {
        System.out.println(replaceWords(Arrays.asList("cat", "bat", "rat"),"the cattle was rattled by the battery"));
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.addWord(word);
        }

        String[] words = sentence.split(" ");

        String[] roots = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            String root = trie.search(words[i]);
            roots[i] = root != null? root: words[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }

            sb.append(roots[i]);
        }

        return sb.toString();
    }

    private static class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (node.map.containsKey(ch)) {
                    node = node.map.get(ch);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.map.put(ch, newNode);
                    node = newNode;
                }
            }

            node.isWordEnd = true;
        }

        private String search(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!node.map.containsKey(ch)) {
                    return null;
                }

                node = node.map.get(ch);

                if (node.isWordEnd) {
                    return word.substring(0, i + 1);
                }
            }

            return null;
        }

        private class TrieNode {
            Map<Character, TrieNode> map = new HashMap<>();
            boolean isWordEnd = false;

            TrieNode() {
            }
        }
    }

}

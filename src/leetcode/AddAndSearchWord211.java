package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 211. Add and Search Word - Data structure design
 * algorithm: Backtracking, Design, Trie
 */
public class AddAndSearchWord211 {
    class WordDictionary {
        private TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            this.root = new TrieNode();
        }

        /** Adds a word into the data structure. */
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

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(word, 0, root);
        }

        private boolean search(String word, int i, TrieNode node) {
            if (i == word.length())
                return node.isWordEnd;

            char ch = word.charAt(i);

            if (ch == '.') {
                for (Character character : node.map.keySet()) {
                    if (search(word, i + 1, node.map.get(character)))
                        return true;
                }

                return false;
            } else {
                if (node.map.containsKey(ch)) {
                    return search(word, i + 1, node.map.get(ch));
                }
            }

            return false;
        }

        class TrieNode {
            Map<Character, TrieNode> map = new HashMap<>();
            boolean isWordEnd = false;

            TrieNode() {
            }
        }

    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
    
    
}

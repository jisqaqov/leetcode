package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 208. Implement Trie (Prefix Tree)
 * category: Design
 */
public class ImplementTrie208 {
    private TrieNode root;

    public static void main(String[] args) {
        ImplementTrie208 solution = new ImplementTrie208();

        solution.test();
    }

    public ImplementTrie208() {
        this.root = new TrieNode();
    }

    public void test() {
        ImplementTrie208 trie = new ImplementTrie208();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    public void insert(String word) {
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

    public boolean startsWith(String word) {
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

    public boolean search(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!node.map.containsKey(ch)) {
                return false;
            }

            node = node.map.get(ch);
        }

        return node.isWordEnd;
    }

    private class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        boolean isWordEnd = false;
    }

}


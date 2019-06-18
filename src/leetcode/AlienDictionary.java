package leetcode;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: Alien Dictionary 269
 * algorithm: Graph, Topological Sort
 * time complexity: O(n + k)
 * space complexity: O(n + k)
 * notes: need to be submitted
 */
public class AlienDictionary {

    public static void main(String[] args) {
        AlienDictionary problem = new AlienDictionary();
        problem.test();
    }

    private void test() {
        String[] tc1dict = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(printOrder(tc1dict, 4));
    }

    public String printOrder(String dict[], int k) {
        Map<Character, Set<Character>> adjList = new HashMap<>();

        for (int i = 1; i < dict.length; i++) {
            int len = Math.min(dict[i - 1].length(), dict[i].length());

            for (int t = 0; t < len; t++) {
                char ch1 = dict[i - 1].charAt(t);
                char ch2 = dict[i].charAt(t);

                if (ch1 != ch2) {
                    adjList.putIfAbsent(ch1, new HashSet<>());
                    adjList.get(ch1).add(ch2);

                    break;
                }
            }
        }

        Set<Character> visited = new HashSet<>();
        Deque<Character> deque = new ArrayDeque<>();

        for (Character ch : adjList.keySet()) {
            if (visited.contains(ch)) {
                continue;
            }

            tsort(ch, visited, adjList, deque);
        }

        int t = 0;

        for (char ch = 'a'; ch <= 'z' && t < k; ch++, t++) {
            if (visited.contains(ch)) {
                continue;
            }

            deque.addLast(ch);
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return sb.toString();
    }

    private void tsort(Character ch, Set<Character> visited, Map<Character, Set<Character>> adjList, Deque<Character> deque) {
        visited.add(ch);

        if (adjList.containsKey(ch)) {
            for (Character adj : adjList.get(ch)) {
                if (visited.contains(adj)) {
                    continue;
                }

                tsort(adj, visited, adjList, deque);
            }
        }

        deque.addFirst(ch);
    }

}

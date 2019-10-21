package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 127. Word Ladder
 * algorithm: BFS
 * time complexity: O(N^2)
 * space complexity: O(N)
 * Runtime: 744 ms, faster than 6.89% of Java online submissions for Word Ladder.
 * Memory Usage: 50.7 MB, less than 5.11% of Java online submissions for Word Ladder.
 */
public class WordLadder127 {

  public static void main(String[] args) {
    WordLadder127 problem = new WordLadder127();

    System.out.println(problem.ladderLength("hit", "cog",
      Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    System.out.println(problem.ladderLength("hit", "cog",
      Arrays.asList("hot", "dot", "dog", "lot", "log")));
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Map<String, Set<String>> adjList = new HashMap<>();

    adjList.put(beginWord, new HashSet<>());
    for (String word : wordList) {
      adjList.put(word, new HashSet<>());
    }

    for (String word : adjList.keySet()) {
      for (String adj : wordList) {
        int diff = 0;
        for (int i = 0; i < word.length() && diff <= 1; i++) {
          if (word.charAt(i) != adj.charAt(i)) {
            diff++;
          }
        }

        if (diff == 1) {
          adjList.get(word).add(adj);

          if (!word.equals(beginWord)) {
            adjList.get(adj).add(word);
          }
        }
      }
    }

    Map<String, Integer> dis = new HashMap<>();
    dis.put(beginWord, 1);

    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);

    Set<String> used = new HashSet<>();

    while (!queue.isEmpty()) {
      String node = queue.poll();

      if (node.equals(endWord)) {
        return dis.get(endWord);
      }

      used.add(node);

      for (String adj : adjList.get(node)) {
        if (used.contains(adj)) {
          continue;
        }

        if (dis.get(node) + 1 < dis.getOrDefault(adj, Integer.MAX_VALUE)) {
          queue.add(adj);
          dis.put(adj, dis.get(node) + 1);
        }
      }
    }

    return 0;
  }

}

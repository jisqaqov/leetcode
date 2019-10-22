package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 126. Word Ladder II
 * algorithm: BFS, Backtracking, Graph, Queue, Hash Map, Array
 * time complexity: O(n)
 * space complexity: O(n)
 * Runtime: 84 ms, faster than 70.99% of Java online submissions for Word Ladder II.
 * Memory Usage: 51.6 MB, less than 34.61% of Java online submissions for Word Ladder II.
 */
public class WordLadderII126 {

  public static void main(String[] args) {
    WordLadderII126 solution = new WordLadderII126();
    solution.test();
  }

  public void test() {
    System.out.println(findLadders("hit", "cog",
      Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    System.out.println(findLadders("hot", "dog", Arrays.asList("hot", "dog")));
    System.out.println(findLadders("hot", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    System.out.println(findLadders("a", "c", Arrays.asList("a", "b", "c")));
    System.out.println(findLadders("red", "tax",
      Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee")));
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> solution = new ArrayList<>();

    Set<String> dict = new HashSet<>(wordList);
    Set<String> visited = new HashSet<>();

    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);

    Map<String, Integer> dis = new HashMap<>();
    dis.put(beginWord, 0);

    Map<String, Set<String>> adjList = new HashMap<>();

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int q = 0; q < size; q++) {
        String node = queue.poll();

        for (int i = 0; i < node.length(); i++) {
          char[] chars = node.toCharArray();

          for (char c = 'a'; c <= 'z'; c++) {
            chars[i] = c;

            String word = new String(chars);

            if (!dict.contains(word) || word.equals(node)) {
              continue;
            }

            if (dis.get(node) + 1 <= dis.getOrDefault(word, Integer.MAX_VALUE)) {
              dis.put(word, dis.get(node) + 1);

              adjList.putIfAbsent(word, new HashSet<>());
              adjList.get(word).add(node);

              if (!word.equals(endWord) && !visited.contains(word)) {
                queue.add(word);
              }

              visited.add(word);
            }
          }
        }
      }

      if (visited.contains(endWord)) {
        break;
      }
    }

    if (visited.contains(endWord)) {
      backtrack(endWord, beginWord, adjList,
        new LinkedList<>(Collections.singletonList(endWord)),
        solution);
    }

    return solution;
  }

  private void backtrack(String node, String beginWord, Map<String, Set<String>> adjList,
    LinkedList<String> list, List<List<String>> solution) {

    if (node.equals(beginWord)) {
      solution.add(new ArrayList<>(list));
      return;
    }

    for (String adj : adjList.get(node)) {
      list.addFirst(adj);
      backtrack(adj, beginWord, adjList, list, solution);
      list.removeFirst();
    }
  }

}

package leetcode.p0022;

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
 * Runtime: 82 ms, faster than 71.90% of Java online submissions for Word Ladder II.
 * Memory Usage: 51.1 MB, less than 36.54% of Java online submissions for Word Ladder II.
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
    List<List<String>> output = new ArrayList<>();

    Set<String> dict = new HashSet<>(wordList);

    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);

    Map<String, List<String>> graph = new HashMap<>();
    for (String word : dict) {
      graph.put(word, new ArrayList<>());
    }

    while (!queue.isEmpty()) {
      int size = queue.size();

      Set<String> level = new HashSet<>();

      for (int q = 0; q < size; q++) {
        String node = queue.poll();

        List<String> candidates = getCandidateWords(node, dict);
        for (String candidate : candidates) {
          if (visited.contains(candidate)) {
            continue;
          }

          graph.get(candidate).add(node);

          if (!level.contains(candidate)) {
            queue.add(candidate);
          }
        }

        level.addAll(candidates);
      }

      visited.addAll(level);

      if (visited.contains(endWord)) {
        break;
      }
    }

    if (visited.contains(endWord)) {
      buildPath(endWord, beginWord, graph,
        new LinkedList<>(Collections.singletonList(endWord)),
        output);
    }

    return output;
  }

  private List<String> getCandidateWords(String word, Set<String> dict) {
    List<String> output = new ArrayList<>();

    char[] chs = word.toCharArray();

    for (int i = 0; i < word.length(); i++) {
      char oldChar = chs[i];

      for (char ch = 'a'; ch <= 'z'; ch++) {
        chs[i] = ch;

        if (ch != oldChar) {
          String candidate = String.valueOf(chs);
          if (dict.contains(candidate)) {
            output.add(candidate);
          }
        }
      }

      chs[i] = oldChar;
    }

    return output;
  }

  private void buildPath(String node, String beginWord, Map<String, List<String>> adjList,
    LinkedList<String> list, List<List<String>> solution) {

    if (node.equals(beginWord)) {
      solution.add(new ArrayList<>(list));
      return;
    }

    for (String adj : adjList.get(node)) {
      list.addFirst(adj);
      buildPath(adj, beginWord, adjList, list, solution);
      list.removeFirst();
    }
  }

}

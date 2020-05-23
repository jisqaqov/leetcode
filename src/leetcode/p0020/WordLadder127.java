package leetcode.p0020;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 127. Word Ladder
 * algorithm: BFS
 * time complexity: O(M*N)
 * space complexity: O(M*N)
 * Runtime: 60 ms, faster than 55.20% of Java online submissions for Word Ladder.
 * Memory Usage: 41.7 MB, less than 56.21% of Java online submissions for Word Ladder.
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
    Set<String> dict = new HashSet<>(wordList);

    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);

    Set<String> visited = new HashSet<>();

    int level = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      level++;

      for (int q = 0; q < size; q++) {
        String node = queue.poll();

        for (int i = 0; i < node.length(); i++) {
          char[] chars = node.toCharArray();

          for (char c = 'a'; c <= 'z'; c++) {
            chars[i] = c;

            String word = new String(chars);

            if (!dict.contains(word)) {
              continue;
            }

            if (word.equals(endWord)) {
              return level + 1;
            }

            if (!visited.contains(word)) {
              queue.add(word);
              visited.add(word);
            }
          }
        }
      }
    }

    return 0;
  }

}

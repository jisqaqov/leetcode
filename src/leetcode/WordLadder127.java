package leetcode;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: 127. Word Ladder
 * algorithm: BFS
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class WordLadder127 {

    public static void main(String[] args) {
        WordLadder127 problem = new WordLadder127();

        System.out.println(problem.ladderLength("hit", "cog",
                Arrays.asList("hot","dot","dog","lot","log","cog")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        Map<String, Integer> path = new HashMap<>();
        path.put(beginWord, 1);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            String currWord = queue.poll();

            Iterator<String> it = wordSet.iterator();
            while (it.hasNext()) {
                String nextWord = it.next();
                if (!wordSet.contains(beginWord) && currWord.equals(beginWord) && nextWord.equals(endWord)) {
                    continue;
                }

                int differs = 0;
                for (int i = 0; i < currWord.length(); i++) {
                    if (nextWord.charAt(i) != currWord.charAt(i)) {
                        differs++;
                    }
                }

                if (differs == 1) {
                    if (nextWord.equals(endWord)) {
                        return path.get(currWord) + 1;
                    }

                    queue.add(nextWord);
                    path.put(nextWord, path.get(currWord) + 1);

                    it.remove();
                }
            }
        }

        return 0;

    }

}

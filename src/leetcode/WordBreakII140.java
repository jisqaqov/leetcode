package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 140. Word Break II
 * algorithm: Recursion with memoization
 * time complexity: O(|S|^3*N)
 * space complexity: O(|S|^3*N)
 * Runtime: 7 ms, faster than 52.60% of Java online submissions for Word Break II.
 * Memory Usage: 40.8 MB, less than 8.20% of Java online submissions for Word Break II.
 */
public class WordBreakII140 {

  public static void main(String[] args) {
    WordBreakII140 solution = new WordBreakII140();
    solution.test();
  }

  public void test() {
    System.out.println(
      wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));

    System.out.println(wordBreak("abcd", new ArrayList<>(Arrays.asList("a", "abc", "b", "cd"))));
  }

  public List<String> wordBreak(String s, List<String> words) {
    Set<String> set = new HashSet<>(words);

    List<String> solution = new ArrayList<>();

    Map<Integer, List<List<String>>> memo = new HashMap<>();

    wordBreak(s, 0, set, memo);

    if (memo.get(0) != null) {
      for (List<String> list : memo.get(0)) {
        StringBuilder sb = new StringBuilder();
        for (String word : list) {
          if (sb.length() > 0) {
            sb.append(" ");
          }

          sb.append(word);
        }
        solution.add(sb.toString());
      }
    }

    return solution;
  }

  private List<List<String>> wordBreak(String word, int index, Set<String> set,
    Map<Integer, List<List<String>>> memo) {

    if (memo.containsKey(index)) {
      return memo.get(index);
    }

    if (index == word.length()) {
      List<List<String>> temp = new ArrayList<>();
      temp.add(new ArrayList<>());
      return temp;
    }

    for (int i = index; i < word.length(); i++) {
      String prefix = word.substring(index, i + 1);

      if (!set.contains(prefix)) {
        continue;
      }

      List<List<String>> sub = wordBreak(word, i + 1, set, memo);
      if (sub != null) {
        for (List<String> temp : sub) {
          List<String> solution = new ArrayList<>();

          solution.add(prefix);
          solution.addAll(temp);

          memo.putIfAbsent(index, new ArrayList<>());
          memo.get(index).add(solution);
        }
      } else {
        if (!memo.containsKey(index)) {
          memo.put(index, null);
        }
      }
    }

    return memo.get(index);
  }

}

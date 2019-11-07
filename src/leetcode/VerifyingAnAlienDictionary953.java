package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 953. Verifying an Alien Dictionary
 * algorithm: Hash Table
 * time complexity: O(|order| + |words| + 26^26)
 * space complexity: O(N)
 * Runtime: 3 ms, faster than 7.50% of Java online submissions for Verifying an Alien Dictionary.
 * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Verifying an Alien Dictionary.
 */
public class VerifyingAnAlienDictionary953 {

  public static void main(String[] args) {
    VerifyingAnAlienDictionary953 problem = new VerifyingAnAlienDictionary953();
    problem.test();
  }

  private void test() {
    System.out
      .println(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    System.out
      .println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
    System.out
      .println(isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
  }

  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Set<Character>> adjList = new HashMap<>();

    for (int i = 1; i < words.length; i++) {
      int n = Math.min(words[i].length(), words[i - 1].length());

      for (int t = 0; t < n; t++) {
        if (words[i].charAt(t) == words[i - 1].charAt(t)) {
          continue;
        }

        adjList.putIfAbsent(words[i - 1].charAt(t), new HashSet<>());
        adjList.get(words[i - 1].charAt(t)).add(words[i].charAt(t));

        break;
      }
    }

    if (adjList.isEmpty()) {
      return false;
    }

    Map<Character, Integer> indexes = new HashMap<>();

    for (int i = 0; i < order.length(); i++) {
      indexes.put(order.charAt(i), i);
    }

    for (Character ch : adjList.keySet()) {
      for (Character adj : adjList.get(ch)) {
        if (indexes.get(ch) > indexes.get(adj)) {
          return false;
        }
      }
    }

    return true;
  }

}

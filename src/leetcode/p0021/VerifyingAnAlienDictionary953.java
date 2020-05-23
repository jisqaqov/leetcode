package leetcode.p0021;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 953. Verifying an Alien Dictionary
 * algorithm: Hash Table
 * time complexity: O(C)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 40.42% of Java online submissions for Verifying an Alien Dictionary.
 * Memory Usage: 35.6 MB, less than 100.00% of Java online submissions for Verifying an Alien Dictionary.
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
    Map<Character, Integer> indexes = new HashMap<>();

    for (int i = 0; i < order.length(); i++) {
      indexes.put(order.charAt(i), i);
    }

    for (int i = 0; i < words.length - 1; i++) {
      int n = Math.min(words[i].length(), words[i + 1].length());

      int t = 0;
      for (; t < n; t++) {
        if (words[i].charAt(t) != words[i + 1].charAt(t)) {
          if (indexes.get(words[i].charAt(t)) > indexes.get(words[i + 1].charAt(t))) {
            return false;
          }

          break;
        }
      }

      if (t == n && words[i].length() > words[i + 1].length()) {
        return false;
      }
    }

    return true;
  }

}

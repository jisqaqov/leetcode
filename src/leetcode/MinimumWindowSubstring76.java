package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 76. Minimum Window Substring
 * algorithm: Hash Table, Two Pointers, Sliding Window, String
 * time complexity: O(|s| + |t|)
 * space complexity: O(|t|)
 * Runtime: 14 ms, faster than 66.68% of Java online submissions for Minimum Window Substring.
 * Memory Usage: 37.9 MB, less than 93.62% of Java online submissions for Minimum Window Substring.
 */
public class MinimumWindowSubstring76 {

  public static void main(String[] args) {
    MinimumWindowSubstring76 problem = new MinimumWindowSubstring76();
    problem.test();
  }

  public void test() {
    System.out.println(minWindow("yadobecodebanc", "abc"));//banc
  }

  public String minWindow(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
    }

    int diff = t.length();

    int minLen = -1;

    int[] indexes = new int[2];

    int start = 0;

    for (int end = 0; end < s.length(); end++) {
      char lastChar = s.charAt(end);

      if (map.containsKey(lastChar)) {
        map.put(lastChar, map.getOrDefault(lastChar, 0) - 1);
        if (map.get(lastChar) >= 0) {
          diff--;
        }
      }

      while (start <= end && diff == 0) {
        int len = end - start + 1;
        if (minLen == -1 || len < minLen) {
          minLen = len;

          indexes[0] = start;
          indexes[1] = end;
        }

        char startChar = s.charAt(start);

        if (map.containsKey(startChar)) {
          map.put(startChar, map.get(startChar) + 1);
          if (map.get(startChar) > 0) {
            diff++;
          }
        }

        start++;
      }
    }

    return minLen < 0 ? "" : s.substring(indexes[0], indexes[1] + 1);
  }

}

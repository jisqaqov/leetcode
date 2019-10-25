package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 76. Minimum Window Substring
 * algorithm: Sliding Window Technique
 * time complexity: O(|s| + |t|)
 * space complexity: O(|s| + |t|)
 * Runtime: 19 ms, faster than 48.68% of Java online submissions for Minimum Window Substring.
 * Memory Usage: 37.2 MB, less than 98.94% of Java online submissions for Minimum Window Substring.
 */
public class MinimumWindowSubstring76 {

  public static void main(String[] args) {
    MinimumWindowSubstring76 problem = new MinimumWindowSubstring76();
    problem.test();
  }

  public void test() {
    System.out.println(minWindow("yadobecodebanc", "abc"));
  }

  public String minWindow(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
    }

    int counter = map.size();
    int start = -1, minLen = -1;
    int[] index = new int[2];

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (map.containsKey(ch)) {
        if (start == -1) {
          start = i;
        }

        map.put(ch, map.get(ch) - 1);

        if (map.get(ch) == 0) {
          counter--;
        }
      }

      while (counter == 0) {
        int len = i - start + 1;
        if (minLen == -1 || len < minLen) {
          minLen = len;
          index[0] = start;
          index[1] = i;
        }

        char prefix = s.charAt(start);
        map.put(prefix, map.get(prefix) + 1);
        if (map.get(prefix) > 0) {
          counter++;
        }

        start++;
        while (start < i && !map.containsKey(s.charAt(start))) {
          start++;
        }
      }
    }

    return minLen > 0 ? s.substring(index[0], index[1] + 1) : "";
  }

}

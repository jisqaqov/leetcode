package leetcode.p0012;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 3. Longest Substring Without Repeating Characters
 * algorithm: Sliding Window Technique
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class LengthOfLongestSubstring3 {

  public static void main(String[] args) {
    LengthOfLongestSubstring3 solution = new LengthOfLongestSubstring3();
    solution.test();
  }

  public void test() {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
    System.out.println(lengthOfLongestSubstring("bbbbb"));
    System.out.println(lengthOfLongestSubstring("pwwkew"));
  }

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    Map<Character, Integer> map = new HashMap<>();
    int start = 0, max = -1;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (map.containsKey(ch) && map.get(ch) >= start) {
        start = map.get(ch) + 1;
      }

      map.put(ch, i);

      int len = i - start + 1;
      max = Math.max(max, len);
    }

    return max;
  }

}

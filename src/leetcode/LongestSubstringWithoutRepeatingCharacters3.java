package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 3. Longest Substring Without Repeating Characters
 * algorithm: Hash Table, Sliding Window
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 7 ms, faster than 82.30% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 36.1 MB, less than 99.76% of Java online submissions for Longest Substring Without Repeating Characters.
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters3 problem = new LongestSubstringWithoutRepeatingCharacters3();
    problem.test();
  }

  private void test() {
    System.out.println(lengthOfLongestSubstring("abba"));//2
    System.out.println(lengthOfLongestSubstring("abcabcbb"));//3
    System.out.println(lengthOfLongestSubstring("bbbbb"));//1
    System.out.println(lengthOfLongestSubstring("pwwkew"));//3
  }

  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();

    int start = 0;
    int len = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (map.containsKey(ch) && map.get(ch) >= start) {
        start = map.get(ch) + 1;
      }

      map.put(ch, i);

      len = Math.max(len, i - start + 1);
    }

    return len;
  }


}

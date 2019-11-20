package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 340. Longest Substring with At Most K Distinct Characters
 * algorithm: Sliding Window, Hash Table, String
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 15 ms, faster than 47.67% of Java online submissions for Longest Substring with At Most K Distinct Characters.
 * Memory Usage: 38.5 MB, less than 61.70% of Java online submissions for Longest Substring with At Most K Distinct Characters.
 */
public class LongestSubstringWithAtMostKDistinctCharacters340 {

  public static void main(String[] args) {
    LongestSubstringWithAtMostKDistinctCharacters340 problem = new LongestSubstringWithAtMostKDistinctCharacters340();
    problem.test();
  }

  private void test() {
    System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
    System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
  }

  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int len = 0;
    int start = 0;
    int end = 0;

    Map<Character, Integer> map = new HashMap<>();

    while (end < s.length()) {
      while (end < s.length() && map.size() <= k) {
        char ch = s.charAt(end);

        map.put(ch, map.getOrDefault(ch, 0) + 1);

        if (map.size() <= k) {
          len = Math.max(len, end - start + 1);
        }

        end++;
      }

      char ch = s.charAt(start);
      map.put(ch, map.get(ch) - 1);

      if (map.get(ch) == 0) {
        map.remove(ch);
      }

      start++;
    }

    return len;
  }

}

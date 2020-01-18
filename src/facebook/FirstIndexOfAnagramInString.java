package facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem:
 *
 * Simplified version of https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * Find the first index of anagram within a given string.
 *
 * Example 1:
 *
 * Input: s = "hello", p = "lo"
 * Output: 3
 * Explanation: the returned value would be 3 because the smallest index of "lo" is 3.
 * Example 2:
 *
 * Input: s = "hehehe", p = "eh"
 * Output: 0
 * Explanation: the returned value would be 0 because "he" which is an anagram can be found in index 0.
 *
 * algorithm: Sliding Window
 * time complexity: O(|S| + |P|)
 * space complexity: O(|P|)
 */
public class FirstIndexOfAnagramInString {

  public static void main(String[] args) {
    FirstIndexOfAnagramInString problem = new FirstIndexOfAnagramInString();
    problem.test();
  }

  private void test() {
    System.out.println(findFirstAnagram("hello".toCharArray(), "lo".toCharArray()));//3
    System.out.println(findFirstAnagram("hehehe".toCharArray(), "eh".toCharArray()));//0
  }

  private int findFirstAnagram(char[] s, char[] p) {
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : p) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    int diff = p.length;

    for (int i = 0; i < s.length; i++) {
      if (map.containsKey(s[i])) {
        map.put(s[i], map.get(s[i]) - 1);

        if (map.get(s[i]) >= 0) {
          diff--;
        }
      }

      if (i >= p.length) {
        int start = i - p.length;
        
        if (map.containsKey(s[start])) {
          map.put(s[start], map.get(s[start]) + 1);
          
          if (map.get(s[start]) > 0) {
            diff++;
          }
        }
      }

      if (diff == 0) {
        return i - p.length + 1;
      }
    }

    return -1;
  }

}
package facebook;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * algorithm: Two Pointers
 * time complexity: O(|S| + |T|)
 * space complexity: O(|T|)
 * problem:
 * You are given a set of unique characters and a string.
 * Find the smallest substring of the string containing all the characters in the set.
 * example:
 * Set : [a, b, c]
 * String : "abbcbcba"
 * Result: "cba
 */
public class MinimumWindowSubstring {

  public static void main(String[] args) {
    MinimumWindowSubstring problem = new MinimumWindowSubstring();
    problem.test();
  }

  public void test() {
    System.out.println(minWindow("byadobecodebankc",
      new HashSet<>(Arrays.asList('a', 'b', 'c'))));//bankc
  }

  public String minWindow(String s, Set<Character> set) {
    Map<Character, Integer> map = new HashMap<>();

    int minLen = -1;
    int start = 0;

    int diff = set.size();

    int[] indexes = new int[2];

    for (int i = 0; i < s.length(); i++) {
      char lastChar = s.charAt(i);

      if (set.contains(lastChar)) {
        if (!map.containsKey(lastChar)) {
          diff--;
        }

        map.put(lastChar, i);
      }

      while (start <= i && diff == 0) {
        int len = i - start + 1;
        if (minLen == -1 || len < minLen) {
          minLen = len;
          indexes[0] = start;
          indexes[1] = i;
        }

        char startChar = s.charAt(start);

        if (set.contains(startChar) && map.get(startChar) == start) {
          map.remove(startChar);
          diff++;
        }

        start++;
      }
    }

    return minLen < 0? "": s.substring(indexes[0], indexes[1] + 1);
  }


}

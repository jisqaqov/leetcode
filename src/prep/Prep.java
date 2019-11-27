package prep;

import java.util.HashMap;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    System.out.println(minWindow("A", "A"));
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

      map.put(lastChar, map.getOrDefault(lastChar, 0) - 1);
      if (map.get(lastChar) >= 0) {
        diff--;
      }

      while (start <= end && diff == 0) {
        int len = end - start + 1;
        if (minLen == -1 || len < minLen) {
          minLen = len;

          indexes[0] = start;
          indexes[1] = end;
        }

        char startChar = s.charAt(start);

        map.put(startChar, map.get(startChar) + 1);
        if (map.get(startChar) > 0) {
          diff++;
        }

        start++;
      }
    }

    return minLen < 0 ? "" : s.substring(indexes[0], indexes[1] + 1);
  }

}

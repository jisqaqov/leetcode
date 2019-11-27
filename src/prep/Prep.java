package prep;

import java.util.HashMap;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
    System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
  }

  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int len = 0;

    Map<Character, Integer> map = new HashMap<>();
    int start = 0;

    for (int end = 0; end < s.length(); end++) {
      char currChar = s.charAt(end);
      map.put(currChar, map.getOrDefault(currChar, 0) + 1);

      while (start <= end && map.size() > k) {
        char startChar = s.charAt(start);

        map.put(startChar, map.get(startChar) - 1);
        if (map.get(startChar) == 0) {
          map.remove(startChar);
        }

        start++;
      }

      len = Math.max(len, end - start + 1);
    }

    return len;
  }

}

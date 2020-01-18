package prep;

import java.util.HashMap;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(findFirstAnagram("hello".toCharArray(), "lo".toCharArray()));//3
    System.out.println(findFirstAnagram("hehehe".toCharArray(), "eh".toCharArray()));//0
  }

  private int findFirstAnagram(char[] s, char[] p) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < p.length; i++) {
      map.put(p[i], map.getOrDefault(p[i], 0) + 1);
    }

    int diff = p.length;
    int start = 0;

    for (int i = 0; i < s.length; i++) {
      if (map.containsKey(s[i])) {
        map.put(s[i], map.getOrDefault(s[i], 0) - 1);

        if (map.get(s[i]) >= 0) {
          diff--;
        }
      }

      if (i >= p.length) {
        if (map.containsKey(s[start])) {
          map.put(s[start], map.get(s[start]) + 1);

          if (map.get(s[start]) > 0) {
            diff++;
          }
        }

        start++;
      }

      if (diff == 0) {
        return i - p.length + 1;
      }
    }

    return -1;
  }

}
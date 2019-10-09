package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 121. Best Time to Buy and Sell Stock
 * algorithm: Hash Table, SLiding Window
 * time complexity: O(n)
 * space complexity: O(n)
 */
@SuppressWarnings("DuplicatedCode")
public class FindAllAnagramsInAString438 {

  public static void main(String[] args) {
    FindAllAnagramsInAString438 solution = new FindAllAnagramsInAString438();
    solution.test();
  }

  public void test() {
    System.out.println(findAnagrams("xcbaebabacd", "abc"));
    System.out.println(findAnagrams("abab", "ab"));

    DiscussionsApproach problem = new DiscussionsApproach();

    System.out.println(problem.findAnagrams("xcbaebabacd", "abc"));
    System.out.println(problem.findAnagrams("abab", "ab"));
  }

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> indexes = new ArrayList<>();

    if (s == null || p == null || s.length() < p.length()) {
      return indexes;
    }

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
      char ch = p.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    Set<Character> pattern = new HashSet<>(map.keySet());
    Set<Character> balance = new HashSet<>(map.keySet());

    for (int i = 0; i < p.length(); i++) {
      char ch = s.charAt(i);

      if (pattern.contains(ch)) {
        map.put(ch, map.get(ch) - 1);
        track(map, balance, ch);
      } else {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
        balance.add(ch);
      }
    }

    if (balance.isEmpty()) {
      indexes.add(0);
    }

    for (int i = p.length(); i < s.length(); i++) {
      char charLast = s.charAt(i);
      char charFirst = s.charAt(i - p.length());

      if (charFirst != charLast) {

        if (pattern.contains(charLast)) {
          map.put(charLast, map.get(charLast) - 1);
        } else {
          map.put(charLast, map.getOrDefault(charLast, 0) + 1);
        }

        if (pattern.contains(charFirst)) {
          map.put(charFirst, map.get(charFirst) + 1);
        } else {
          map.put(charFirst, map.getOrDefault(charFirst, 0) - 1);
        }

        track(map, balance, charLast);
        track(map, balance, charFirst);
      }

      if (balance.isEmpty()) {
        indexes.add(i - p.length() + 1);
      }
    }

    return indexes;
  }

  private static class DiscussionsApproach {
    public List<Integer> findAnagrams(String s, String p) {
      List<Integer> indexes = new ArrayList<>();

      if (s == null || p == null || s.length() < p.length()) {
        return indexes;
      }

      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < p.length(); i++) {
        char ch = p.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
      }

      int start = 0, diff = p.length();

      for (int i = 0; i < s.length(); i++) {
        if (i >= p.length()) {
          char firstChar = s.charAt(start);

          if (map.get(firstChar) >= 0) {
            diff++;
          }

          map.put(firstChar, map.getOrDefault(firstChar, 0) + 1);
          start++;
        }

        char ch = s.charAt(i);

        map.put(ch, map.getOrDefault(ch, 0) - 1);
        if (map.get(ch) >= 0) {
          diff--;
        }

        if (diff == 0) {
          indexes.add(start);
        }
      }

      return indexes;
    }
  }

  private void track(Map<Character, Integer> map, Set<Character> balance, char ch) {
    if (map.get(ch) == 0) {
      balance.remove(ch);
    } else {
      balance.add(ch);
    }
  }

}

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

    System.out.println(problem.findAnagrams("aaaaaaaaaaxcbaebabacd", "abc"));
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

      int start = 0, counter = p.length();

      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        if (map.containsKey(ch)) {
          if (map.get(ch) >= 0) {
            map.put(ch, map.get(ch) - 1);
            counter--;
          }
        }

        if (i - start == p.length()) {
          if (map.containsKey(s.charAt(start))) {
            map.put(s.charAt(start), map.get(s.charAt(start)) + 1);

            if (map.get(s.charAt(start)) > 0) {
              counter++;
            }
          }

          start++;
        }

        if (counter == 0) {
          indexes.add(start);
        }
      }

      return indexes;
    }


    /*public List<Integer> findAnagrams(String s, String p) {
      List<Integer> list = new ArrayList<>();
      if (s == null || s.length() == 0 || p == null || p.length() == 0)
        return list;
      int[] hash = new int[256]; //character hash
      //record each character in p to hash
      for (char c : p.toCharArray()) {
        hash[c]++;
      }
      //two points, initialize count to p's length
      int left = 0, right = 0, count = p.length();
      while (right < s.length()) {
        //move right everytime, if the character exists in p's hash, decrease the count
        //current hash value >= 1 means the character is existing in p
        if (hash[s.charAt(right++)]-- >= 1)
          count--;

        //when the count is down to 0, means we found the right anagram
        //then add window's left to result list
        if (count == 0)
          list.add(left);

        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
        //++ to reset the hash because we kicked out the left
        //only increase the count if the character is in p
        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
          count++;
      }
      return list;
    }*/
  }

  private void track(Map<Character, Integer> map, Set<Character> balance, char ch) {
    if (map.get(ch) == 0) {
      balance.remove(ch);
    } else {
      balance.add(ch);
    }
  }

}

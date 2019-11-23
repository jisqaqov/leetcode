package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 438. Find All Anagrams in a String
 * algorithm: Hash Table
 * time complexity: O(n)
 * space complexity: O(n)
 * Runtime: 30 ms, faster than 26.19% of Java online submissions for Find All Anagrams in a String.
 * Memory Usage: 38.9 MB, less than 92.00% of Java online submissions for Find All Anagrams in a String.
 */
public class FindAllAnagramsInAString438 {

  public static void main(String[] args) {
    FindAllAnagramsInAString438 solution = new FindAllAnagramsInAString438();
    solution.test();
  }

  public void test() {
    System.out.println(findAnagrams("cbaebabacd", "abc"));
    System.out.println(findAnagrams("abab", "ab"));
  }

  public List<Integer> findAnagrams(String s, String p) {
    Map<Character, Integer> counter = new HashMap<>();

    for (int i = 0; i < p.length(); i++) {
      char ch = p.charAt(i);
      counter.put(ch, counter.getOrDefault(ch, 0) + 1);
    }

    List<Integer> list = new ArrayList<>();

    int diff = p.length();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      counter.put(ch, counter.getOrDefault(ch, 0) - 1);
      if (counter.get(ch) >= 0) {
        diff--;
      }

      int start = i - p.length() + 1;

      if (diff == 0) {
        list.add(start);
      }

      if (start >= 0) {
        char charStart = s.charAt(start);
        counter.put(charStart, counter.get(charStart) + 1);

        if (counter.get(charStart) > 0) {
          diff++;
        }
      }
    }

    return list;
  }

}

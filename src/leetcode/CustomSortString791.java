package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 791. Custom Sort String
 * algorithm: String
 * time complexity: O(|S| + |T|)
 * space complexity: O(|S| + |T|)
 * Runtime: 2 ms, faster than 46.91% of Java online submissions for Custom Sort String.
 * Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Custom Sort String.
 */
public class CustomSortString791 {

  public static void main(String[] args) {
    CustomSortString791 problem = new CustomSortString791();
    problem.test();
  }

  private void test() {
    System.out.println(customSortString("cba", "abcd"));
  }

  public String customSortString(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
    }

    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      set.add(s.charAt(i));
    }

    StringBuilder output = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if (!map.containsKey(s.charAt(i))) {
        continue;
      }

      int n = map.get(s.charAt(i));
      while (n > 0) {
        output.append(s.charAt(i));
        n--;
      }
    }

    for (int i = 0; i < t.length(); i++) {
      if (!set.contains(t.charAt(i))) {
        output.append(t.charAt(i));
      }
    }

    return output.toString();
  }

}

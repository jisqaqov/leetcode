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
 * space complexity: O(|T|)
 * Runtime: 2 ms, faster than 50.23% of Java online submissions
 * Memory Usage: 41 MB, less than 6.06% of Java online submissions
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

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      int cnt = map.getOrDefault(s.charAt(i), 0);
      for (int k = cnt; k > 0; k--) {
        sb.append(s.charAt(i));
      }

      map.remove(s.charAt(i));
    }

    for (char ch : map.keySet()) {
      for (int k = map.get(ch); k > 0; k--) {
        sb.append(ch);
      }
    }

    return sb.toString();
  }

}

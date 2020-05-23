package leetcode.p0007;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 249. Group Shifted Strings
 * algorithm: Hash Table
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 2 ms, faster than 79.98% of Java online submissions
 * Memory Usage: 36.4 MB, less than 100.00% of Java online submissions
 */
public class GroupShiftedStrings249 {

  public static void main(String[] args) {
    GroupShiftedStrings249 problem = new GroupShiftedStrings249();
    problem.test();
  }

  private void test() {
    String[] tc1a = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
    System.out.println(groupStrings(tc1a));
  }

  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();

    for (String str : strings) {
      StringBuilder kb = new StringBuilder();

      for (int i = 1; i < str.length(); i++) {
        int offset = str.charAt(i) - str.charAt(i - 1);

        if (offset < 0) {
          offset += 26;
        }

        kb.append(offset).append(":");
      }

      String key = kb.toString();

      map.putIfAbsent(key, new ArrayList<>());
      map.get(key).add(str);
    }

    return new ArrayList<>(map.values());
  }

  private static class V2 {
    public List<List<String>> groupStrings(String[] strings) {
      Map<String, List<String>> map = new HashMap<>();

      for (String str : strings) {
        String enc = encrypt(str.toCharArray());

        map.putIfAbsent(enc, new ArrayList<>());
        map.get(enc).add(str);
      }

      return new ArrayList<>(map.values());
    }

    private String encrypt(char[] s) {
      int inc = 'z' - s[0];

      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < s.length; i++) {
        int index = s[i] - 'a';
        int letter = (index + inc) % 26;
        sb.append((char) ('a' + letter));
      }

      return sb.toString();
    }
  }

}
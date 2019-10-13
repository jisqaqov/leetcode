package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 49. Group Anagrams
 * algorithm: Hash Table
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class GroupAnagrams49 {

  public static void main(String[] args) {
    GroupAnagrams49 problem = new GroupAnagrams49();
    problem.test();
  }

  private void test() {
    String[] t1a = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(groupAnagrams(t1a));
    System.out.println(new SolutionV2().groupAnagrams(t1a));
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);

      StringBuilder sb = new StringBuilder();
      for (char ch : chars) sb.append(ch);

      String key = sb.toString();

      map.putIfAbsent(key, new ArrayList<>());
      map.get(key).add(str);
    }

    List<List<String>> list = new ArrayList<>();
    for (String key : map.keySet()) {
      list.add(map.get(key));
    }

    return list;
  }

  private static class SolutionV2 {

    public List<List<String>> groupAnagrams(String[] strs) {
      Map<Map<Character, Integer>, List<String>> counter = new HashMap<>();

      for (String str : strs) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
          char ch = str.charAt(i);
          map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        counter.putIfAbsent(map, new ArrayList<>());
        counter.get(map).add(str);
      }

      return new ArrayList<>(counter.values());
    }

  }

}

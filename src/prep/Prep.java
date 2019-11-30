package prep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
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

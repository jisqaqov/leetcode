package prep;

import java.util.HashMap;
import java.util.Map;

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

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      int cnt = map.getOrDefault(s.charAt(i), 0);
      for (int k = 0; k < cnt; k++) {
        sb.append(s.charAt(i));
      }

      map.remove(s.charAt(i));
    }

    for (char ch : map.keySet()) {
      for (int k = 0; k < map.get(ch); k++) {
        sb.append(ch);
      }
    }

    return sb.toString();
  }

}
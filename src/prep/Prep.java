package prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(findAnagrams("cbaebabacd", "abc"));
    System.out.println(findAnagrams("abab", "ab"));
  }

  public List<Integer> findAnagrams(String s, String p) {
    Map<Character, Integer> counter = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
      counter.put(p.charAt(i), counter.getOrDefault(p.charAt(i), 0) + 1);
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

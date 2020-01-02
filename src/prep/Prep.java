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
    String[] tc1a = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
    System.out.println(groupStrings(tc1a));
  }

  private String encrypt(char[] s) {
    int shift = 'z' - s[0];

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length; i++) {
      int index = s[i] - 'a';

      if (index + shift > 25) {
        sb.append((char) ('a' + (index + shift - 1) % 25));
      } else {
        sb.append((char) ('a' + index + shift));
      }
    }

    return sb.toString();
  }

  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();

    for (String s : strings) {
      String enc = encrypt(s.toCharArray());

      map.putIfAbsent(enc, new ArrayList<>());
      map.get(enc).add(s);
    }

    return new ArrayList<>(map.values());
  }

}
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 809. Expressive Words
 * algorithm: Graph, Topological Sort
 * time complexity: O(|C|)
 * space complexity: O(|C|)
 * Runtime: 9 ms, faster than 15.44% of Java online submissions
 * Memory Usage: 41.4 MB, less than 5.88% of Java online submissions
 */
public class ExpressiveWords809 {

  public static void main(String[] args) {
    ExpressiveWords809 problem = new ExpressiveWords809();
    problem.test();
  }

  private void test() {
    System.out.println(expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
  }

  public int expressiveWords(String s, String[] words) {
    List<Stat> stat = stat(s);

    int count = 0;

    for (String word : words) {
      List<Stat> stat2 = stat(word);

      if (stat.size() != stat2.size()) {
        continue;
      }

      boolean stretch = true;
      for (int i = 0; i < stat.size(); i++) {
        if (stat.get(i).ch != stat2.get(i).ch ||
          stat.get(i).count < stat2.get(i).count ||
          (stat.get(i).count > stat2.get(i).count && stat.get(i).count < 3)) {
          stretch = false;
        }
      }

      if (stretch) {
        count++;
      }
    }

    return count;
  }

  private List<Stat> stat(String s) {
    if (s.isEmpty()) {
      return Collections.emptyList();
    }

    List<Stat> list = new ArrayList<>();
    list.add(new Stat(s.charAt(0), 1));

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        list.get(list.size() - 1).count++;
      } else {
        list.add(new Stat(s.charAt(i), 1));
      }
    }

    return list;
  }

  private class Stat {

    private char ch;
    private int count;

    Stat(char ch, int count) {
      this.ch = ch;
      this.count = count;
    }
  }

}
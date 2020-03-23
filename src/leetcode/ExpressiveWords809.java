package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 809. Expressive Words
 * algorithm: Graph, Topological Sort
 * time complexity: O(|C|)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 97.64% of Java online submissions
 * Memory Usage: 38.2 MB, less than 82.35% of Java online submissions
 */
public class ExpressiveWords809 {

  public static void main(String[] args) {
    ExpressiveWords809 problem = new ExpressiveWords809();
    problem.test();
  }

  private void test() {
    System.out.println(new V2().expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));//1
  }

  public int expressiveWords(String s, String[] words) {
    int count = 0;

    for (String word : words) {
      if (stretchy(s, word)) {
        count++;
      }
    }

    return count;
  }

  private boolean stretchy(String s, String t) {
    int n = s.length();
    int m = t.length();

    int i = 0, j = 0;

    while (i < n && j < m) {
      if (s.charAt(i) != t.charAt(j)) {
        return false;
      }

      int len1 = getRepeatedLength(s, i);
      int len2 = getRepeatedLength(t, j);

      if (len1 < len2 || (len1 > len2 && len1 < 3)) {
        return false;
      }

      i += len1;
      j += len2;
    }

    return i == n && j == m;
  }

  private int getRepeatedLength(String s, int i) {
    int j = i;

    while (j < s.length() && s.charAt(j) == s.charAt(i)) {
      j++;
    }

    return j - i;
  }

  private static class V2 {

    public int expressiveWords(String s, String[] words) {
      RLE template = new RLE(s);

      int count = 0;

      for (String word : words) {
        RLE candidate = new RLE(word);
        if (stretchy(template, candidate)) {
          count++;
        }
      }

      return count;
    }

    private boolean stretchy(RLE template, RLE candidate) {
      if (!template.key.equals(candidate.key)) {
        return false;
      }

      for (int i = 0; i < template.len.size(); i++) {
        int len1 = template.len.get(i);
        int len2 = candidate.len.get(i);

        if (len1 < len2 || (len1 > len2 && len1 < 3)) {
          return false;
        }
      }

      return true;
    }

    private static class RLE {

      private String key;
      private List<Integer> len;

      public RLE(String s) {
        StringBuilder key = new StringBuilder();
        len = new ArrayList<>();

        int prev = -1;

        for (int i = 0; i < s.length(); i++) {
          if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
            key.append(s.charAt(i));
            len.add(i - prev);

            prev = i;
          }
        }

        this.key = key.toString();
      }

    }

  }

}
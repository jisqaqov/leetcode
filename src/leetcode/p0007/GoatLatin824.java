package leetcode.p0007;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 824. Goat Latin
 * algorithm: String
 * time complexity: O(N^2)
 * space complexity: O(N^2)
 * Runtime: 4 ms, faster than 75.97% of Java online submissions for Alien Dictionary.
 * Memory Usage: 35.9 MB, less than 97.30% of Java online submissions for Alien Dictionary.
 */
public class GoatLatin824 {

  private static final Set<Character> VOWELS = new HashSet<>(
    Arrays.asList('a', 'e', 'i', 'o', 'u'));

  public static void main(String[] args) {
    GoatLatin824 problem = new GoatLatin824();
    problem.test();
  }

  private void test() {
    V2 v2 = new V2();

    System.out
      .println(toGoatLatin("I speak Goat Latin").equals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa"));
    System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog").equals(
      "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"));

    System.out
      .println(v2.toGoatLatin("I speak Goat Latin").equals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa"));
    System.out.println(v2.toGoatLatin("The quick brown fox jumped over the lazy dog").equals(
      "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"));
  }

  public String toGoatLatin(String s) {
    String t = "";

    String[] words = s.split(" ");

    for (int i = 0; i < words.length; i++) {
      String word = words[i];

      char firstChar = word.charAt(0);
      if (VOWELS.contains(Character.toLowerCase(firstChar))) {
        word = word + "ma";
      } else {
        word = word.substring(1) + word.charAt(0) + "ma";
      }

      for (int k = 0; k <= i; k++) {
        word = word + "a";
      }

      t = t + " " + word;
    }

    return t.trim();
  }

  private static class V2 {

    public String toGoatLatin(String s) {
      StringBuilder t = new StringBuilder();

      StringBuilder suffix = null;
      int wordIndex = 0;

      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        if (i == 0 || s.charAt(i - 1) == ' ') {
          if (suffix != null) {
            t.append(suffix);
          }

          if (i > 0 && s.charAt(i - 1) == ' ') {
            t.append(" ");
          }

          if (VOWELS.contains(Character.toLowerCase(ch))) {
            t.append(ch);

            suffix = new StringBuilder("ma");
          } else {
            suffix = new StringBuilder(ch + "ma");
          }

          for (int k = 0; k <= wordIndex; k++) {
            suffix.append("a");
          }

          wordIndex++;
        } else if (ch != ' ') {
          t.append(ch);
        }
      }

      t.append(suffix);

      return t.toString().trim();
    }

  }

}

package prep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prep {

  private static final Set<Character> VOWELS = new HashSet<>(
    Arrays.asList('a', 'e', 'i', 'o', 'u'));

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    V2 v2 = new V2();

    System.out
      .println(toGoatLatin("I speak Goat Latin").equals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa"));
    System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog").equals(
      "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"));
  }

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

  private static class V2 {

    public String toGoatLatin(String s) {
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

        words[i] = word;
      }

      String t = "";

      for (String word : words) {
        t = t + " " + word;
      }

      return t.trim();
    }
  }

}

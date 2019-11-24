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
    System.out.println(validPalindrome("aba"));
    System.out.println(validPalindrome("tcaac"));
    System.out.println(validPalindrome("acbad"));
  }

  public boolean validPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return isPalindrome(s, i, j - 1) ||
          isPalindrome(s, i + 1, j);
      }

      i++;
      j--;
    }

    return true;
  }

  private boolean isPalindrome(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }

      i++;
      j--;
    }

    return true;
  }



}

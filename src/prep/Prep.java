package prep;

import java.util.Arrays;
import utils.TestUtils;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    char[] tc1a = "the sky is blue".toCharArray();

    reverseWords(tc1a);

    System.out.println(Arrays.toString(tc1a));
  }

  public void reverseWords(char[] s) {
    reverse(s, 0, s.length - 1);

    int start = 0;

    for (int i = 0; i <= s.length; i++) {
      if (i == s.length || s[i] == ' ') {
        reverse(s, start, i - 1);

        start = i + 1;
      }
    }
  }

  private void reverse(char[] s, int l, int r) {
    while (l < r) {
      swap(s, l, r);

      l++;
      r--;
    }
  }

  private void swap(char[] s, int i, int j) {
    char temp = s[j];
    s[j] = s[i];
    s[i] = temp;
  }

}
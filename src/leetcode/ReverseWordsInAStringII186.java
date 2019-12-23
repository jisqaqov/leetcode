package leetcode;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * algorithm: String
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 2 ms, faster than 36.49% of Java online submissions
 * Memory Usage: 43.2 MB, less than 92.31% of Java online submissions
 */
public class ReverseWordsInAStringII186 {

  public static void main(String[] args) {
    ReverseWordsInAStringII186 problem = new ReverseWordsInAStringII186();
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
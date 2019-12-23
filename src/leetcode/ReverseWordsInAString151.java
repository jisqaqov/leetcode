package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 151. Reverse Words in a String
 * algorithm: String, Two Pointers
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 4 ms, faster than 66.46% of Java online submissions
 * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions
 */
public class ReverseWordsInAString151 {

  public static void main(String[] args) {
    ReverseWordsInAString151 problem = new ReverseWordsInAString151();
    problem.test();
  }

  private void test() {
    System.out.println(reverseWords("I  wish   you   a   merry   Christmas")
      .equals("Christmas merry a you wish I"));
    System.out.println(reverseWords("  I   wish    you   a    merry    Christmas   ")
      .equals("Christmas merry a you wish I"));
    System.out.println(reverseWords("I   wish    you   a    merry    Christmas   ")
      .equals("Christmas merry a you wish I"));
    System.out.println(reverseWords("  I   wish    you   a    merry    Christmas")
      .equals("Christmas merry a you wish I"));
    System.out.println(reverseWords("I wish you a merry Christmas")
      .equals("Christmas merry a you wish I"));
  }

  public String reverseWords(String s) {
    char[] t = s.toCharArray();

    int pivot = moveSpaces(t);

    reverseWords(t, pivot);

    return new String(t, 0, pivot);
  }

  private int moveSpaces(char[] t) {
    int pivot = 0;

    for (int i = 0; i < t.length; i++) {
      if (t[i] != ' ') {
        // add space between words
        if (i > 0 && t[i - 1] == ' ' && pivot > 0 && t[pivot - 1] != ' ') {
          t[pivot] = ' ';
          pivot++;
        }

        t[pivot] = t[i];
        pivot++;
      }
    }

    return pivot;
  }

  private void reverseWords(char[] s, int n) {
    reverse(s, 0, n - 1);

    int start = 0;

    for (int i = 0; i <= n; i++) {
      if (i == n || s[i] == ' ') {
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

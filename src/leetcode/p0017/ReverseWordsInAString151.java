package leetcode.p0017;

/**
 * @author Jandos Iskakov
 * problem: 151. Reverse Words in a String
 * algorithm: String, Two Pointers
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 2 ms, faster than 86.36% of Java online submissions
 * Memory Usage: 37.1 MB, less than 100.00% of Java online submissions
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

    reverse(t, 0, t.length - 1);

    int pivot = 0;

    for (int i = 0; i < t.length; i++) {
      if (t[i] == ' ') {
        continue;
      }

      if (pivot > 0) {
        t[pivot] = ' ';
        pivot++;
      }

      int start = pivot;
      int end = i;

      while (end < t.length && t[end] != ' ') {
        t[pivot] = t[end];

        pivot++;
        end++;
      }

      reverse(t, start, pivot - 1);

      i = end - 1;
    }

    return new String(t, 0, pivot);
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

package leetcode.p0017;

/**
 * @author Jandos Iskakov
 * problem: 344. Reverse String
 * algorithm: String
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse String.
 * Memory Usage: 52.4 MB, less than 6.51% of Java online submissions for Reverse String.
 */
public class ReverseString344 {

  public void reverseString(char[] s) {
    int l = 0;
    int r = s.length - 1;

    while (l < r) {
      char temp = s[l];
      s[l] = s[r];
      s[r] = temp;

      l++;
      r--;
    }
  }

  private static class V2 {
    public void reverseString(char[] s) {
      helper(s, 0, s.length - 1);
    }

    public void helper(char[] s, int l, int r) {
      if (l >= r) {
        return;
      }

      char temp = s[l];
      s[l] = s[r];
      s[r] = temp;

      helper(s, l + 1, r - 1);

    }
  }

}

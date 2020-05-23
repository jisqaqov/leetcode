package leetcode.p0021;

/**
 * @author Jandos Iskakov
 * problem: 680. Valid Palindrome II
 * algorithm: String
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 8 ms, faster than 63.63% of Java online submissions for Valid Palindrome II.
 * Memory Usage: 38.6 MB, less than 100.00% of Java online submissions for Valid Palindrome II.
 */
public class ValidPalindromeII680 {

  public static void main(String[] args) {
    ValidPalindromeII680 problem = new ValidPalindromeII680();
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

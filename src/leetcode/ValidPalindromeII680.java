package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 680. Valid Palindrome II
 * algorithm: String
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 13 ms, faster than 9.43% of Java online submissions for Valid Palindrome II.
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
    for (int i = 0; i < s.length()/2; i++) {
      int j = s.length() - i - 1;
      if (s.charAt(i) != s.charAt(j)) {
        return isPalindrome(s.substring(i + 1, j + 1)) ||
          isPalindrome(s.substring(i, j));
      }
    }

    return true;
  }

  private boolean isPalindrome(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }

    return true;
  }



}

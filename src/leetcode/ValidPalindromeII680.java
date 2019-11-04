package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 680. Valid Palindrome II
 * algorithm: String
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 10 ms, faster than 30.76% of Java online submissions for Valid Palindrome II.
 * Memory Usage: 38.8 MB, less than 97.22% of Java online submissions for Valid Palindrome II.
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
        return isPalindrome(i + 1, j, s) ||
          isPalindrome(i, j - 1, s);
      }
    }

    return true;
  }

  private boolean isPalindrome(int i, int j, String s) {
    int n = j - i + 1;
    for (int k = i; k < i + n/2; k++) {
      if (s.charAt(k) != s.charAt(j)) {
        return false;
      }

      j--;
    }

    return true;
  }

}

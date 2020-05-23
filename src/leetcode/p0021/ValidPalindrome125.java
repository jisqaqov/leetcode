package leetcode.p0021;

/**
 * @author Jandos Iskakov
 * problem: 125. Valid Palindrome
 * algorithm: Two Pointers, String
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 3 ms, faster than 96.09% of Java online submissions for Valid Palindrome.
 * Memory Usage: 38.1 MB, less than 83.04% of Java online submissions for Valid Palindrome.
 */
public class ValidPalindrome125 {

  public static void main(String[] args) {
    ValidPalindrome125 problem = new ValidPalindrome125();
    problem.test();
  }

  private void test() {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(isPalindrome("race a car"));
  }

  public boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;

    while (true) {
      while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }

      while (j > 0 && !Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      }

      if (i >= j) {
        break;
      }

      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        return false;
      }

      i++;
      j--;
    }

    return true;
  }

}

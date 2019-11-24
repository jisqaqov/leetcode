package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(isPalindrome("race a car"));
  }

  public boolean isPalindrome(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        sb.append(Character.toLowerCase(ch));
      }
    }

    int i = 0;
    int j = sb.length() - 1;

    while (i < j) {
      if (sb.charAt(i) != sb.charAt(j)) {
        return false;
      }

      i++;
      j--;
    }

    return true;
  }


}

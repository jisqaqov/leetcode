package leetcode.p0001;

/**
 * @author Jandos Iskakov
 * problem: 415. Add Strings
 * algorithm: String
 * time complexity: O(N+M)
 * space complexity: O(N+M)
 * Runtime: 11 ms, faster than 14.25% of Java online submissions for Add Strings.
 * Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Add Strings.
 */
public class AddStrings415 {

  public static void main(String[] args) {
    AddStrings415 problem = new AddStrings415();
    problem.test();
  }

  private void test() {
    System.out.println(addStrings("5435", "987"));
    System.out.println(addStrings("1", "9"));
  }

  public String addStrings(String num1, String num2) {
    String c = "";

    int carry = 0;
    int i = num1.length() - 1;
    int j = num2.length() - 1;

    while (i >= 0 || j >= 0 || carry > 0) {
      int n1 = 0;
      if (i >= 0) {
        char ch1 = num1.charAt(i);
        n1 = Character.getNumericValue(ch1);
      }

      int n2 = 0;
      if (j >= 0) {
        char ch2 = num2.charAt(j);
        n2 = Character.getNumericValue(ch2);
      }

      int n3 = n1 + n2 + carry;
      carry = n3 / 10;
      int k = n3 % 10;

      c = k + c;

      i--;
      j--;
    }

    return c;
  }


}

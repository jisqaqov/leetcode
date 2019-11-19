package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 67. Add Binary
 * algorithm: String, Math
 * time complexity: O(|a| + |b|)
 * space complexity: O(|a| + |b|)
 * Runtime: 2 ms, faster than 66.26% of Java online submissions for Add Binary.
 * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Add Binary.
 */
public class AddBinary67 {

  public static void main(String[] args) {
    AddBinary67 problem = new AddBinary67();
    problem.test();
  }

  private void test() {
    System.out.println(addBinary("1010", "1011"));
  }

  public String addBinary(String a, String b) {
    int i = a.length() - 1;
    int j = b.length() - 1;

    int carry = 0;
    String s = "";

    while (i >= 0 || j >= 0) {
      int num1 = 0;
      int num2 = 0;

      if (i >= 0) {
        char c1 = a.charAt(i);
        num1 = Character.getNumericValue(c1);
      }

      if (j >= 0) {
        char c2 = b.charAt(j);
        num2 = Character.getNumericValue(c2);
      }

      int k = num1 + num2 + carry;
      carry = k / 2;
      int c = k % 2;

      s = c + s;

      i--;
      j--;
    }

    if (carry != 0) {
      s = carry + s;
    }

    return s;
  }

}

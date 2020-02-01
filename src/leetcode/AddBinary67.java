package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 67. Add Binary
 * algorithm: String, Math
 * time complexity: O(|a| + |b|)
 * space complexity: O(|a| + |b|)
 * Runtime: 2 ms, faster than 64.31% of Java online submissions
 * Memory Usage: 38 MB, less than 5.62% of Java online submissions
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
    StringBuilder sb = new StringBuilder();

    while (i >= 0 || j >= 0 || carry > 0) {
      int d1 = i>= 0? a.charAt(i) - '0': 0;
      int d2 = j >= 0? b.charAt(j) - '0': 0;

      int k = d1 + d2 + carry;

      int c = k % 2;
      carry = k / 2;

      sb.append(c);

      i--;
      j--;
    }

    return sb.reverse().toString();
  }

}

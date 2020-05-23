package leetcode.p0021;

/**
 * @author Jandos Iskakov
 * problem: 65. Valid Number
 * algorithm: Math, String
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 2 ms, faster than 67.41% of Java online submissions
 * Memory Usage: 42.2 MB, less than 6.25% of Java online submissions
 */
public class ValidNumber65 {

  public static void main(String[] args) {
    ValidNumber65 problem = new ValidNumber65();
    problem.test();
  }

  private void test() {
    System.out.println(isNumber("0"));//true
    System.out.println(isNumber(" 0.1 "));//true
    System.out.println(!isNumber("abc"));//false
    System.out.println(!isNumber("1 a"));//false
    System.out.println(isNumber("2e10"));//true*/
    System.out.println(isNumber(" -90e3   "));//true
    System.out.println(!isNumber(" 1e"));//false
    System.out.println(!isNumber("e3"));//false
    System.out.println(isNumber(" 6e-1"));//true
    System.out.println(!isNumber(" 99e2.5 "));//false
    System.out.println(isNumber("53.5e93"));//true
    System.out.println(!isNumber(" --6 "));//false
    System.out.println(!isNumber("-+3"));//false
    System.out.println(!isNumber("95a54e53"));//false
    System.out.println(isNumber(".1"));//true
    System.out.println(isNumber("3."));//true
    System.out.println(!isNumber("."));//false
    System.out.println(!isNumber(".e1"));//false
    System.out.println(!isNumber(" -."));//false
    System.out.println(!isNumber(" +0e-"));//false
    System.out.println(isNumber("46.e3"));//true
    System.out.println(isNumber("-.3e6"));//true
    System.out.println(!isNumber("-e58 "));//false
    System.out.println(isNumber(" 005047e+6"));//true
    System.out.println(!isNumber("459277e38+"));//false
    System.out.println(!isNumber("2e+60++604"));//false
  }

  public boolean isNumber(String s) {
    s = s.trim();

    boolean numbers = false;
    boolean dot = false;
    boolean exp = false;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch == '-' || ch == '+') {
        if (i > 0 && s.charAt(i - 1) != 'e') {
          return false;
        }
      } else if (ch == 'e') {
        if (exp || !numbers) {
          return false;
        }

        exp = true;
        numbers = false;
      } else if (ch == '.') {
        if (dot || exp) {
          return false;
        }
        dot = true;
      } else if (ch >= '0' && ch <= '9') {
        numbers = true;
      } else {
        return false;
      }
    }

    return numbers;
  }

}
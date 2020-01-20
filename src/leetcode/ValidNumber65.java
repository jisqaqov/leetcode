package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 65. Valid Number
 * algorithm: Math, String
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 3 ms, faster than 88.19% of Java online submissions for Alien Dictionary.
 * Memory Usage: 35.9 MB, less than 97.30% of Java online submissions for Alien Dictionary.
 */
public class ValidNumber65 {

  public static void main(String[] args) {
    ValidNumber65 problem = new ValidNumber65();
    problem.test();
  }

  private void test() {
    System.out.println(isNumber("0"));
    System.out.println(isNumber(" 0.1 "));
    System.out.println(!isNumber("abc"));
    System.out.println(!isNumber("1 a"));
    System.out.println(isNumber("2e10"));
    System.out.println(isNumber(" -90e3   "));
    System.out.println(!isNumber(" 1e"));
    System.out.println(!isNumber("e3"));
    System.out.println(isNumber(" 6e-1"));
    System.out.println(!isNumber(" 99e2.5 "));
    System.out.println(isNumber("53.5e93"));
    System.out.println(!isNumber(" --6 "));
    System.out.println(!isNumber("-+3"));
    System.out.println(!isNumber("95a54e53"));
    System.out.println(isNumber(".1"));
    System.out.println(isNumber("3."));
    System.out.println(!isNumber("."));
    System.out.println(!isNumber(".e1"));
    System.out.println(!isNumber(" -."));
    System.out.println(!isNumber(" +0e-"));
    System.out.println(isNumber("46.e3"));
    System.out.println(isNumber("-.3e6"));
    System.out.println(!isNumber("-e58 "));
    System.out.println(isNumber(" 005047e+6"));
    System.out.println(!isNumber("459277e38+"));
    System.out.println(!isNumber("2e+60++604"));
  }

  public boolean isNumber(String s) {
    System.out.print(s + " -> ");

    s = s.trim();

    if (s.isEmpty()) {
      return false;
    }

    return isValid(s);
  }

  private boolean isValid(String s) {
    int numbers = 0;
    int fractions = 0;
    int expNumbers = 0;

    boolean negative = false;
    boolean positive = false;
    boolean positiveExp = false;
    boolean exp = false;
    boolean decimal = false;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch == '-') {
        if (i > 0 && !exp) {
          return false;
        }

        negative = true;
      } else if (ch == '+') {
        if ((i > 0 && !exp) || i == s.length() - 1 || (positiveExp && exp)) {
          return false;
        }

        if (exp) {
          positiveExp = true;
        } else {
          positive = true;
        }
      } else if (ch == 'e') {
        if (i == 0 || i == s.length() - 1 || exp) {
          return false;
        }

        exp = true;
      } else if (ch == '.') {
        if (exp || decimal) {
          return false;
        }

        decimal = true;
      } else if (ch >= '0' && ch <= '9') {
        if (exp) {
          expNumbers++;
        } else if (decimal) {
          fractions++;
        } else {
          numbers++;
        }
      } else {
        return false;
      }

      if (i == s.length() - 1) {
        if ((exp && expNumbers == 0) || ((exp || decimal) && numbers == 0 && fractions == 0)) {
          return false;
        }
      }
    }

    return true;
  }

}
package leetcode;

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
    System.out.print(s + " -> ");

    int n = s.length();
    if (n == 0) {
      return false;
    }

    int nums = 0, fracs = 0;
    boolean decimal = false;

    int expN = 0;
    boolean exp = false;
    boolean expSign = false;

    int startIndex = 0;
    while (startIndex < n && s.charAt(startIndex) == ' ') {
      startIndex++;
    }

    int endIndex = n - 1;
    while (endIndex > startIndex && s.charAt(endIndex) == ' ') {
      endIndex--;
    }

    for (int i = startIndex; i <= endIndex; i++) {
      char ch = s.charAt(i);

      if (ch == '-' || ch == '+') {
        if ((i > startIndex && !exp) || i == endIndex || (exp && expSign)) {
          return false;
        }

        if (exp) {
          expSign = true;
        }
      } else if (ch == 'e') {
        if (exp) {
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
          expN++;
        } else if (decimal) {
          fracs++;
        } else {
          nums++;
        }
      } else {
        return false;
      }
    }

    if ((exp && expN == 0) || (nums == 0 && fracs == 0)) {
      return false;
    }

    return true;
  }

}
package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 8. String to Integer (atoi)
 * algorithm: Math, String
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 2 ms, faster than 56.90% of Java online submissions for String to Integer (atoi).
 * Memory Usage: 35.6 MB, less than 100.00% of Java online submissions for String to Integer (atoi).
 */
public class StringToInteger8 {

  public static void main(String[] args) {
    StringToInteger8 problem = new StringToInteger8();
    problem.test();
  }

  private void test() {
    System.out.println(myAtoi("42"));//42
    System.out.println(myAtoi("   -42"));//-42
    System.out.println(myAtoi("4193 with words"));//4193
    System.out.println(myAtoi("words and 987"));//0
    System.out.println(myAtoi("-91283472332"));//-2147483648
    System.out.println(myAtoi("  3322147483647"));//2147483647
  }

  public int myAtoi(String str) {
    int i = 0;
    while (i < str.length() && str.charAt(i) == ' ') {
      i++;
    }

    if (i == str.length()) {
      return 0;
    }

    char startChar = str.charAt(i);

    int sign = 1;
    if (startChar == '+') {
      i++;
    } else if (startChar == '-') {
      sign = -1;
      i++;
    } else if (!Character.isDigit(startChar)) {
      return 0;
    }

    int num = 0;
    int len = 0;

    for (int j = i; j < str.length(); j++) {
      char ch = str.charAt(j);

      if (!Character.isDigit(ch)) {
        break;
      }

      int digit = Character.getNumericValue(ch);
      if (sign == -1) {
        digit *= -1;
      }

      // check for overflow on multiplication
      if (sign == -1 && num < Integer.MIN_VALUE / 10) {
        return Integer.MIN_VALUE;
      } else if (sign == 1 && num > Integer.MAX_VALUE / 10) {
        return Integer.MAX_VALUE;
      }

      num = num * 10;

      // check for overflow on multiplication
      if (sign == -1 && num < Integer.MIN_VALUE - digit) {
        return Integer.MIN_VALUE;
      } else if (sign == 1 && num > Integer.MAX_VALUE - digit) {
        return Integer.MAX_VALUE;
      }

      num += digit;

      len++;
    }

    if (len == 0) {
      return 0;
    }

    return num;
  }

}

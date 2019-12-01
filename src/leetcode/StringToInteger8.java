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
    System.out.println(myAtoi("   "));//0
    System.out.println(myAtoi("42"));//42
    System.out.println(myAtoi("   -42"));//-42
    System.out.println(myAtoi("4193 with words"));//4193
    System.out.println(myAtoi("words and 987"));//0
    System.out.println(myAtoi("-91283472332"));//-2147483648
    System.out.println(myAtoi("-2147483648"));//-2147483648
    System.out.println(myAtoi("  3322147483647"));//2147483647
  }

  public int myAtoi(String str) {
    str = str.trim();
    if (str.isEmpty()) {
      return 0;
    }

    int i = 0;

    int sign = 1;
    if (str.charAt(i) == '+' || str.charAt(i) == '-') {
      sign = str.charAt(i) == '+'? 1: -1;
      i++;
    }

    int number = 0;

    while (i < str.length() && Character.isDigit(str.charAt(i))) {
      char ch = str.charAt(i);

      int digit = Character.getNumericValue(ch);

      // check for overflow
      // another option to check for overflow number == Integer.MAX_VALUE / 10 && digit > 7
      if (number > Integer.MAX_VALUE / 10 || (number > (Integer.MAX_VALUE - digit) / 10)) {
        return sign == -1? Integer.MIN_VALUE: Integer.MAX_VALUE;
      }

      number = number * 10 + digit;

      i++;
    }

    return number * sign;
  }

}

package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 171. Excel Sheet Column Number
 * algorithm: Math, String
 * time complexity: O(n)
 * space complexity: O(1)
 */
public class ExcelSheetColumnNumber171 {

  public static void main(String[] args) {
    ExcelSheetColumnNumber171 problem = new ExcelSheetColumnNumber171();
    problem.test();
  }

  private void test() {
    System.out.println(titleToNumber("K"));
    System.out.println(titleToNumber("ABB"));
    System.out.println(titleToNumber("ZY"));
  }

  public int titleToNumber(String s) {
    int number = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      int index = ch - 'A' + 1;

      number = number + index * (int)Math.pow(26, s.length() - i - 1);
    }

    return number;
  }

}

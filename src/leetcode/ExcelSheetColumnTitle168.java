package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 168. Excel Sheet Column Title
 * algorithm: Math, String time
 * complexity: O(n)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Title.
 * Memory Usage: 33.7 MB, less than 100.00% of Java online submissions for Excel Sheet Column Title.
 */
public class ExcelSheetColumnTitle168 {

  public static void main(String[] args) {
    ExcelSheetColumnTitle168 problem = new ExcelSheetColumnTitle168();
    problem.test();
  }

  private void test() {
    System.out.println(convertToTitle(26));
    System.out.println(convertToTitle(731));
    System.out.println(convertToTitle(52));
  }

  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();

    while (n > 0) {
      int number = (n - 1) % 26;
      n = (n - 1) / 26;

      char ch = (char) (number + 'A');

      sb.append(ch);
    }

    return sb.reverse().toString();
  }

}

package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 273. Integer to English Words
 * algorithm: Math, String
 * time complexity: O(1)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Integer to English Words.
 * Memory Usage: 35.7 MB, less than 100.00% of Java online submissions for Integer to English Words.
 */
public class IntegerToEnglishWords273 {

  private static final String[] NUMS = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
    "Eight", "Nine", "Ten",
    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
    "Nineteen"};

  private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
    "Seventy", "Eighty", "Ninety"};

  private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

  public static void main(String[] args) {
    IntegerToEnglishWords273 problem = new IntegerToEnglishWords273();
    problem.test();
  }

  private void test() {
    System.out.println(numberToWords(50868));
  }

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }

    String s = "";
    int i = 0;

    while (num > 0) {
      if (num % 1000 != 0) {
        s = convertLessThan1000(num % 1000).trim() + " " + THOUSANDS[i] + " " + s;
      }

      i++;
      num /= 1000;
    }

    return s.trim();
  }

  private String convertLessThan1000(int n) {
    if (n == 0) {
      return "";
    } else if (n < 20) {
      return NUMS[n] + " ";
    } else if (n < 100) {
      return TENS[n / 10] + " " + convertLessThan1000(n % 10);
    } else {
      return NUMS[n / 100] + " Hundred " + convertLessThan1000(n % 100);
    }
  }


}

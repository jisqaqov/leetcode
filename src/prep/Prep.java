package prep;

public class Prep {

  private static final String[] LESS_20 = {"", "One", "Two", "Three", "Four", "Five", "Six",
    "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
    "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

  private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
    "Seventy", "Eighty", "Ninety"};

  private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(numberToWords(1000000));
//    System.out.println(numberToWords(50868));
    //System.out.println(numberToWords(42562690));
  }

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }

    String s = "";

    int d = 0;

    while (num > 0) {
      int k = num % 1000;

      if (k != 0) {
        s = helper(k).trim() + " " + THOUSANDS[d] + " " + s;
      }

      d++;
      num = num / 1000;
    }

    return s.trim();
  }

  private String helper(int num) {
    if (num == 0) {
      return "";
    }

    if (num < 20) {
      return LESS_20[num];
    } else if (num < 100) {
      return TENS[num / 10] + " " + helper(num % 10);
    } else {
      return helper(num / 100) + " Hundred " + helper(num % 100);
    }
  }

}

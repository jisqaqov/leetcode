package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 50. Pow(x, n)
 * algorithm: Binary Search
 * https://en.wikipedia.org/wiki/Exponentiation_by_squaring
 * time complexity: O(log(n))
 * space complexity: O(log(n))
 * Runtime: 1 ms, faster than 61.30% of Java online submissions for Pow(x, n).
 * Memory Usage: 33.5 MB, less than 5.88% of Java online submissions for Pow(x, n).
 */
public class PowXn50 {

  public static void main(String[] args) {
    PowXn50 problem = new PowXn50();
    problem.test();
  }

  public void test() {
    System.out.println(myPow(2.00000, -2147483648));
    System.out.println(myPow(0.44528, 0));
    System.out.println(myPow(2, 3));
    System.out.println(myPow(2, 10));
    System.out.println(myPow(2.1, 3));
    System.out.println(myPow(2, -2));
    System.out.println(myPow(-2, 3));

    System.out.println(myPow(0.00001, 2147483647));
    System.out.println(myPow(-1, 3));
    System.out.println(myPow(-1, 4));
    System.out.println(myPow(1, 3));
    System.out.println(myPow(1, 2));
  }

  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }

    double y = myPow(x, n / 2);

    if (n % 2 == 0) {
      return y * y;
    } else {
      if (n < 0) {
        return y * y * 1 / x;
      } else {
        return y * y * x;
      }
    }
  }

}

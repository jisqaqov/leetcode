package leetcode.p0017;

/**
 * @author Jandos Iskakov
 * problem: 7. Reverse Integer
 * algorithm: Math
 * time complexity: O(1)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 33.8 MB, less than 11.11% of Java online submissions
 */
public class ReverseInteger7 {

  public static void main(String[] args) {
    ReverseInteger7 problem = new ReverseInteger7();
    problem.test();
  }

  private void test() {
    System.out.println(reverse(123));//321
    System.out.println(reverse(-123));//-321
    System.out.println(reverse(120));//21
    System.out.println(reverse(1534236469));//0
    System.out.println(reverse(-2147483648));//0
  }

  public int reverse(int x) {
    int y = 0;

    while (x != 0) {
      int d = x % 10;

      if ((d > 0 && y > (Integer.MAX_VALUE - d) / 10) ||
          (d < 0 && y < (Integer.MIN_VALUE - d) / 10)) {
        return 0;
      }

      y = y * 10 + d;

      x /= 10;
    }

    return y;
  }

}

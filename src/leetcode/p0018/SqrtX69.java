package leetcode.p0018;

/**
 * @author Jandos Iskakov
 * problem: 69. Sqrt(x)
 * algorithm: Binary Search
 * time complexity: O(log(n))
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 33.4 MB, less than 5.00% of Java online submissions
 */
public class SqrtX69 {

  public static void main(String[] args) {
    SqrtX69 problem = new SqrtX69();
    problem.test();
  }

  private void test() {
    System.out.println(mySqrt(0));//0
    System.out.println(mySqrt(1));//1
    System.out.println(mySqrt(4));//2
    System.out.println(mySqrt(8));//2
    System.out.println(mySqrt(9));//3
    System.out.println(mySqrt(10));//3
    System.out.println(mySqrt(2147395599));//46339
  }

  public int mySqrt(int x) {
    int l = 1;
    int r = x;

    while (l <= r) {
      int m = l + (r - l) / 2;

      // avoid integer overflow, m * m < x => m < x / m
      if (m < x / m) {
        l = m + 1;
      } else if (m > x / m) {
        r = m - 1;
      } else {
        return m;
      }
    }

    return r;
  }

}

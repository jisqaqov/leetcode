package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
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
    int output = 0;

    while (x != 0) {
      int d = x % 10;

      if ((d > 0 && output > (Integer.MAX_VALUE - d) / 10) ||
          (d < 0 && output < (Integer.MIN_VALUE - d) / 10)) {
        return 0;
      }

      output = output * 10 + d;

      x /= 10;
    }

    return output;
  }

}
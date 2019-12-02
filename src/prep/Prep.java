package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(myPow(2.00000,-2147483648));
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
    if (n < 0) {
      x = 1 / x;
      n = -1 * n;
    }

    return squaring(x, n);
  }

  private double squaring(double x, int n) {
    if (n == 0) {
      return 1;
    }

    double h = squaring(x, n / 2);

    if (n % 2 == 0) {
      return h * h;
    } else {
      return h * h * x;
    }
  }


}
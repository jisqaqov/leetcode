package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 50. Pow(x, n)
 * algorithm: Binary Search
 * search for the number it's root n equals x
 */
public class PowXn50 {

    public static void main(String[] args) {
        PowXn50 solution = new PowXn50();
        solution.test();
    }

    public void test() {
        System.out.println(pow(2.00000,-2147483648));
        System.out.println(pow(0.44528, 0));
        System.out.println(pow(2, 3));
        System.out.println(pow(2, 10));
        System.out.println(pow(2.1, 3));
        System.out.println(pow(2, -2));
        System.out.println(pow(-2, 3));

        System.out.println(pow(0.00001, 2147483647));
        System.out.println(pow(-1, 3));
        System.out.println(pow(-1, 4));
        System.out.println(pow(1, 3));
        System.out.println(pow(1, 2));
    }

    public double pow(double x, int n) {
        if (n == 0)
            return 1;

        if (Math.abs(x) == 1)
            return n % 2 > 0? x: 1;

        double l = 0, r = Double.MAX_VALUE;

        double result = 0, prev = 0;

        while (l <= r) {
            double mid = l + (r - l) / 2;
            double root = Math.pow(mid, 1.0/Math.abs(n));

            if (mid == 0 || root == 0 || root == prev) {
                return 0;
            } else if (root == Math.abs(x)) {
                result = mid;
                break;
            } else if (root > Math.abs(x)) {
                r = mid;
            } else {
                l = mid;
            }

            prev = root;
        }

        if (n < 0)
            result = 1 / result;

        if (x < 0 && n % 2 > 0)
            result *= -1;

        return result;
    }

}

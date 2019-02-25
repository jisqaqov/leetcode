package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 367. Valid Perfect Square
 * time complexity: O(log(n))
 * algorithm: based on Binary Search
 * check number^2 if equals target
 * notes: runtime beats 100% of java submissions
 */
public class ValidPerfectSquare367 {

    public static void main(String[] args) {
        ValidPerfectSquare367 solution = new ValidPerfectSquare367();

        solution.test();
    }

    public void test() {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(25));
        System.out.println(isPerfectSquare(14));
    }

    public boolean isPerfectSquare(int num) {
        if (num == 0)
            return true;

        int l = 1, r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            // number could to too large, hence store in double rather in int
            double square = Math.pow(mid, 2);

            if (square == num)
                return true;
            else if (square < num)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return false;
    }

}


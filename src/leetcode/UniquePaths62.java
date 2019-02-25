package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 62. Unique Paths
 * time complexity: O(m*n)
 * space complexity: O(m*n)
 * algorithm: based on dynamic programming
 * i>0, j>0 => f(i, j) = f(i - 1, j) + f(i, j - 1)
 * i=0 or j=0 f(i, j) = 1
 * notes: faster than 100% of Java online submissions
 */
public class UniquePaths62 {

    public static void main(String[] args) {
        UniquePaths62 solution = new UniquePaths62();

        solution.test();
    }

    public void test() {
        System.out.print(uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {
        int[][] h = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    h[i][j] = 1;
                else
                    h[i][j] = h[i - 1][j] + h[i][j - 1];
            }
        }

        return h[m - 1][n - 1];
    }

}


package leetcode.p0020;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 63. Unique Paths II
 * algorithm: DP
 * time complexity: O(n*m)
 * space complexity: O(n*m)
 */
public class UniquePathsII63 {

    public static void main(String[] args) {
        UniquePathsII63 problem = new UniquePathsII63();
        problem.test();
    }

    public void test() {
        int[][] tc1a = {{0,0,0},
                {0,1,0},
                {0,0,0}};

        System.out.println(uniquePathsWithObstacles(tc1a));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0)
            return 0;

        int n = obstacleGrid.length, m = obstacleGrid[0].length;

        int[][] memo = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);

        return uniquePathsWithObstacles(obstacleGrid, n - 1, m - 1, memo);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j, int[][] memo) {
        if (obstacleGrid[i][j] == 1)
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        if (i == 0 && j == 0)
            return 1;

        int paths = 0;
        if (i == 0)
            paths = uniquePathsWithObstacles(obstacleGrid, i, j - 1, memo);
        else if (j == 0)
            paths = uniquePathsWithObstacles(obstacleGrid, i - 1, j, memo);
        else
            paths = uniquePathsWithObstacles(obstacleGrid, i - 1, j, memo) +
                    uniquePathsWithObstacles(obstacleGrid, i, j - 1, memo);

        memo[i][j] = paths;

        return paths;
    }

}

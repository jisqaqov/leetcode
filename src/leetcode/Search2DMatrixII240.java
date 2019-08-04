package leetcode;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 240. Search a 2D Matrix II
 * algorithm: Binary Search
 * time complexity: O(n*log(n)+n*log(m))
 * space complexity: O(1)
 * Runtime: 5 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix II.
 * Memory Usage: 43.3 MB, less than 99.35% of Java online submissions for Search a 2D Matrix II.
 */
public class Search2DMatrixII240 {

    public static void main(String[] args) {
        Search2DMatrixII240 problem = new Search2DMatrixII240();
        problem.test();
    }

    private void test() {
        int[][] tc1matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        System.out.println(searchMatrix(tc1matrix, 5));
        System.out.println(searchMatrix(tc1matrix, 20));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int n = matrix.length, m = matrix[0].length;
        if (m == 0) {
            return false;
        }

        int lastRowIndex = getLastRowIndex(matrix, target, 0, n - 1);
        if (lastRowIndex == -1) {
            return false;
        }

        int firstRowIndex = getFirstRowIndex(matrix, target, 0, lastRowIndex);
        if (firstRowIndex == -1) {
            return false;
        }

        for (int i = firstRowIndex; i <= lastRowIndex; i++) {
            if (Arrays.binarySearch(matrix[i], target) >= 0) {
                return true;
            }
        }

        return false;
    }

    private int getLastRowIndex(int[][] a, int target, int start, int end) {
        int lastRowIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid][0] <= target) {
                lastRowIndex = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return lastRowIndex;
    }

    private int getFirstRowIndex(int[][] a, int target, int start, int end) {
        int m = a[0].length;
        int firstRowIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid][m - 1] < target) {
                start = mid + 1;
            } else {
                firstRowIndex = mid;
                end = mid - 1;
            }
        }

        return firstRowIndex;

    }

}

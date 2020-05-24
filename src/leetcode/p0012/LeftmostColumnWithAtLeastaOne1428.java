package leetcode.p0012;

import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 1428. Leftmost Column with at Least a One
 * algorithm: Array
 * time complexity: O(N+M)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 40.2 MB, less than 100.00%
 */
public class LeftmostColumnWithAtLeastaOne1428 {

  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    List<Integer> dims = binaryMatrix.dimensions();

    int n = dims.get(0);
    int m = dims.get(1);

    int row = 0;
    int col = m - 1;

    int leftColumn = -1;

    while (row < n && col >= 0) {
      int val = binaryMatrix.get(row, col);

      if (val == 0) {
        row++;
      } else {
        leftColumn = col;
        col--;
      }
    }

    return leftColumn;
  }

  // This is the BinaryMatrix's API interface.
  // You should not implement it, or speculate about its implementation
  interface BinaryMatrix {

    List<Integer> dimensions();

    int get(int row, int col);

  }


}
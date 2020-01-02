package facebook;

/**
 * @author Jandos Iskakov
 * algorithm: Two Pointers
 * https://leetcode.com/discuss/interview-question/341247/Facebook-or-Leftmost-column-index-of-1
 * In a binary matrix (all elements are 0 and 1), every row is sorted in ascending order
 * (0 to the left of 1). Find the leftmost column index with a 1 in it.
 *
 * Example 1:
 * Input: [[0, 0, 0, 1], [0, 0, 1, 1], [0, 1, 1, 1], [0, 0, 0, 0]]
 * Output: 1
 *
 * Example 2:
 * Input: [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
 * Output: -1
 * Expected solution better than O(r * c).
 *
 * time complexity: O(N + M)
 * space complexity: O(1)
 */
public class LeftMostIndex {

  public static void main(String[] args) {
    LeftMostIndex problem = new LeftMostIndex();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{0, 0, 0, 1},
      {0, 0, 1, 1},
      {0, 1, 1, 1},
      {0, 0, 0, 0}};

    System.out.println(leftMostIndex(tc1a));//1

    int[][] tc2a = {{0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0}};

    System.out.println(leftMostIndex(tc2a));//-1

    int[][] tc3a = {{0, 1, 1, 1},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {1, 1, 1, 1}};

    System.out.println(leftMostIndex(tc3a));//0
  }

  public int leftMostIndex(int[][] matrix) {
    int index = -1;

    int n = matrix.length;
    int m = matrix[0].length;

    int i = 0;
    int j = m - 1;

    while (i < n && j >= 0) {
      if (matrix[i][j] == 0) {
        i++;
      } else {
        index = j;
        j--;
      }
    }

    return index;
  }

  private static class V2 {

    public int leftMostIndex(int[][] matrix) {
      int index = -1;

      int n = matrix.length;
      int m = matrix[0].length;

      for (int i = 0, j = m - 1; i < n && j >= 0; ) {
        if (matrix[i][j] == 0) {
          i++;
        } else {
          index = j;
          j--;
        }
      }

      return index;
    }
  }


}
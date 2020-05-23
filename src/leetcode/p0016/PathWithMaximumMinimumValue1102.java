package leetcode.p0016;

import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 1102. Path With Maximum Minimum Value
 * algorithm: BFS, Heap, Greedy
 * time complexity: O(n*m*log(n*m))
 * space complexity: O(n*m)
 * Runtime: 82 ms, faster than 80.37% of Java online submissions
 * Memory Usage: 41.9 MB, less than 100.00% of Java online submissions
 */
public class PathWithMaximumMinimumValue1102 {

  private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) {
    PathWithMaximumMinimumValue1102 problem = new PathWithMaximumMinimumValue1102();
    problem.test();
  }

  private void test() {
    System.out.println(maximumMinimumPath(
      new int[][]{
        {5, 4, 5},
        {1, 2, 6},
        {7, 4, 6}}));//4
    System.out.println(maximumMinimumPath(
      new int[][]{
        {2, 2, 1, 2, 2, 2},
        {1, 2, 2, 2, 1, 2}}));//2
    System.out.println(maximumMinimumPath(
      new int[][]{
        {3, 4, 6, 3, 4},
        {0, 2, 1, 1, 7},
        {8, 8, 3, 2, 7},
        {3, 2, 4, 9, 8},
        {4, 1, 2, 0, 0},
        {4, 6, 5, 4, 3}}));//3
  }

  public int maximumMinimumPath(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    int maxScore = a[0][0];

    PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a2[2] - a1[2]);
    pq.add(new int[]{0, 0, a[0][0]});

    boolean[][] visited = new boolean[n][m];
    visited[0][0] = true;

    while (!pq.isEmpty()) {
      int[] node = pq.poll();

      int x = node[0];
      int y = node[1];

      maxScore = Math.min(maxScore, node[2]);

      if (x == n - 1 && y == m - 1) {
        break;
      }

      for (int[] dir : DIRS) {
        int x2 = x + dir[0];
        int y2 = y + dir[1];

        if (x2 >= 0 && y2 >= 0 && x2 < n && y2 < m && !visited[x2][y2]) {
          pq.add(new int[]{x2, y2, a[x2][y2]});
          visited[x2][y2] = true;
        }
      }
    }

    return maxScore;
  }

}
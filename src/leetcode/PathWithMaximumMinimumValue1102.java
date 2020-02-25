package leetcode;

import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 1102. Path With Maximum Minimum Value
 * algorithm: Greedy (Dijkstra),
 * time complexity: O(n*m*log(n*m))
 * space complexity: O(n*m)
 * Runtime: 79 ms, faster than 86.02% of Java online submissions
 * Memory Usage: 42.3 MB, less than 100.00% of Java online submissions
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

    int[][] score = new int[n][m];

    PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a2[2] - a1[2]);
    pq.add(new int[]{0, 0, a[0][0]});

    boolean[][] visited = new boolean[n][m];

    while (!pq.isEmpty()) {
      int[] node = pq.poll();
      int x = node[0], y = node[1];

      if (visited[x][y]) {
        continue;
      }

      visited[x][y] = true;

      for (int[] dir : DIRS) {
        int x2 = node[0] + dir[0];
        int y2 = node[1] + dir[1];

        if (x2 >= 0 && y2 >= 0 && x2 < n && y2 < m) {
          int newScore = Math.min(node[2], a[x2][y2]);
          if (score[x2][y2] < newScore) {
            pq.add(new int[]{x2, y2, newScore});
            score[x2][y2] = newScore;
          }
        }
      }
    }

    return score[n - 1][m - 1];
  }

}
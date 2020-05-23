package leetcode.p0003;

/**
 * @author Jandos Iskakov
 * problem: 1267. Count Servers that Communicate
 * algorithm: Graph
 * time complexity: O(N*M)
 * space complexity: O(N+M)
 * Runtime: 2 ms, faster than 97.57% of Java online submissions
 * Memory Usage: 46.4 MB, less than 100.00% of Java online submissions
 */
public class CountServersThatCommunicate1267 {

  public int countServers(int[][] grid) {
    if (grid.length == 0) {
      return 0;
    }

    int n = grid.length;
    int m = grid[0].length;

    int[] rows = new int[n];
    int[] cols = new int[m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          rows[i]++;
          cols[j]++;
        }
      }
    }

    int servers = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) {
          servers++;
        }
      }
    }

    return servers;
  }

}
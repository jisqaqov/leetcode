package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 463. Island Perimeter
 * algorithm: Array
 * time complexity: O(N*M)
 * space complexity: O(1)
 * Runtime: 7 ms, faster than 74.95% of Java online submissions
 * Memory Usage: 59 MB, less than 97.92% of Java online submissions
 */
public class IslandPerimeter463 {

  public static void main(String[] args) {
    IslandPerimeter463 problem = new IslandPerimeter463();
    problem.test();
  }

  private void test() {
    int[][] grid = {{0, 1, 0, 0},
      {1, 1, 1, 0},
      {0, 1, 0, 0},
      {1, 1, 0, 0}};

    System.out.println(islandPerimeter(grid));
  }

  public int islandPerimeter(int[][] grid) {
    int p = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          p += 4;

          if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
            p -= 2;
          }
          if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            p -= 2;
          }
        }
      }
    }

    return p;
  }

  private static class V2 {

    public int islandPerimeter(int[][] grid) {
      int p = 0;

      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if (grid[i][j] == 0) {
            continue;
          }

          if (i == 0 || grid[i - 1][j] == 0) p++;
          if (j == 0 || grid[i][j - 1] == 0) p++;
          if (j == grid[i].length - 1 || grid[i][j + 1] == 0) p++;
          if (i == grid.length - 1 || grid[i + 1][j] == 0) p++;
        }
      }

      return p;
    }
  }

}

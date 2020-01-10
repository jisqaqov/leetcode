package prep;

/**
 * @author Jandos Iskakov
 * problem: 463. Island Perimeter
 * algorithm: Graph, Topological Sort
 * time complexity: O(N*M)
 * space complexity: O(1)
 * Runtime: 7 ms, faster than 74.95% of Java online submissions
 * Memory Usage: 59 MB, less than 97.92% of Java online submissions
 */
public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
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
    int perimeter = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 0) {
          continue;
        }

        if (i == 0 || grid[i - 1][j] == 0) {
          perimeter++;
        }

        if (j == 0 || grid[i][j - 1] == 0) {
          perimeter++;
        }

        if (j == grid[i].length - 1 || grid[i][j + 1] == 0) {
          perimeter++;
        }

        if (i == grid.length - 1 || grid[i + 1][j] == 0) {
          perimeter++;
        }
      }
    }

    return perimeter;
  }

}
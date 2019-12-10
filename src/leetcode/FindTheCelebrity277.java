package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 277. Find the Celebrity
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 7 ms, faster than 74.16% of Java online submissions for Find the Celebrity.
 * Memory Usage: 45.3 MB, less than 58.33% of Java online submissions for Find the Celebrity.
 */
public class FindTheCelebrity277 {

  public static void main(String[] args) {
    FindTheCelebrity277 problem = new FindTheCelebrity277();
    problem.test();
  }

  private void test() {
    Solution solution = new Solution();
    solution.init(new int[][]{{1, 1}, {1, 1}});
    System.out.println(solution.findCelebrity(2));

    solution.init(new int[][]{{1, 1, 0}, {0, 1, 0}, {1, 1, 1}});
    System.out.println(solution.findCelebrity(3));//1
  }

  /* The knows API is defined in the parent class Relation.*/
  private class Relation {

    private int[][] adjMatrix;

    void init(int[][] adjMatrix) {
      this.adjMatrix = adjMatrix;
    }

    boolean knows(int a, int b) {
      return adjMatrix[a][b] == 1;
    }
  }

  public class Solution extends Relation {

    public int findCelebrity(int n) {
      int celebrity = 0;

      for (int i = 0; i < n; i++) {
        if (knows(celebrity, i)) {
          celebrity = i;
        }
      }

      for (int i = 0; i < n; i++) {
        if (i != celebrity && (knows(celebrity, i) || !knows(i, celebrity))) {
          return -1;
        }
      }

      return celebrity;
    }

  }

}

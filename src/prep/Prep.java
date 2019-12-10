package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
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
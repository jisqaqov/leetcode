package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders909 {

  public static void main(String[] args) {
    SnakesAndLadders909 problem = new SnakesAndLadders909();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {
      {-1, -1, -1, -1, -1, -1},
      {-1, -1, -1, -1, -1, -1},
      {-1, -1, -1, -1, -1, -1},
      {-1, 35, -1, -1, 13, -1},
      {-1, -1, -1, -1, -1, -1},
      {-1, 15, -1, -1, -1, -1}};

    int[][] tc2a = {{-1, 4, -1}, {6, 2, 6}, {-1, 3, -1}};
    int[][] tc3a = {{-1, 7, -1}, {-1, 6, 9}, {-1, -1, 2}};
    int[][] tc4a = {{-1, -1, -1}, {-1, 9, 8}, {-1, 8, 9}};
    int[][] tc5a = {{-1,1,2,-1},{2,13,15,-1},{-1,10,-1,-1},{-1,6,2,8}};

    System.out.println(snakesAndLadders(tc1a));
//    System.out.println(snakesAndLadders(tc2a));
//    System.out.println(snakesAndLadders(tc3a));
//    System.out.println(snakesAndLadders(tc4a));
//    System.out.println(snakesAndLadders(tc5a));
  }

  public int snakesAndLadders(int[][] board) {
    int n = board.length;

    int m = n * n;
    int[] dis = new int[m + 1];
    Arrays.fill(dis, Integer.MAX_VALUE);
    dis[1] = 0;

    boolean[] visited = new boolean[m + 1];

    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);

    while (!queue.isEmpty()) {
      int s = queue.remove();

      if (s == m) {
        return dis[m];
      }

      for (int x = s + 1; x <= Math.min(x + 6, m); x++) {
        if (visited[x]) {
          continue;
        }

        int[] rc = getRowCol(x, n);
        int row = rc[0];
        int col = rc[1];

        int s2 = board[row][col] == -1? x: board[row][col];

        queue.add(s2);
        dis[s2] = dis[s] + 1;
        visited[s2] = true;
      }
    }

    return -1;
  }

  private int[] getRowCol(int s, int n) {
    int quot = (s-1) / n;
    int rem = (s-1) % n;
    int row = n - 1 - quot;
    int col = row % 2 != n % 2 ? rem : n - 1 - rem;
    return new int[] {row, col};
  }


}

package prep;

import java.util.PriorityQueue;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{1, 3}, {2, 4, 6}, {0, 9, 10, 11}};

    System.out.println(kthSmallest(tc1a, 5));//4

    int[][] tc2a = {{1, 3, 20}, {2, 4, 6}};

    System.out.println(kthSmallest(tc2a, 2));//2
  }

  public int kthSmallest(int[][] a, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((t1, t2) -> t2 - t1);

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        pq.add(a[i][j]);

        if (pq.size() > k) {
          pq.poll();
        }
      }
    }

    return pq.poll();
  }

}
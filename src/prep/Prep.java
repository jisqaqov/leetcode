package prep;

import java.util.PriorityQueue;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(connectSticks(new int[]{2, 4, 3}));//14
    System.out.println(connectSticks(new int[]{1, 8, 3, 5}));//30
  }

  public int connectSticks(int[] sticks) {
    if (sticks.length == 0) {
      return 0;
    } else if (sticks.length <= 1) {
      return sticks[0];
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int len : sticks) {
      pq.add(len);
    }

    int cost = 0;

    while (!pq.isEmpty()) {
      int a = pq.poll();
      int b = pq.poll();

      int c = a + b;
      if (!pq.isEmpty()) {
        pq.add(c);
      }

      cost += c;
    }

    return cost;
  }

}
package leetcode;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 973. K Closest Points to Origin
 * algorithm: Heap
 * time complexity: O(nlog(k))
 * space complexity: O(nlog(k))
 */
public class KClosestPointsToOrigin973 {

  public static void main(String[] args) {
    KClosestPointsToOrigin973 problem = new KClosestPointsToOrigin973();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{3,3},{5,-1},{-2,4}};
    printArray(kClosest(tc1a, 2));
  }

  private void printArray(int[][] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i][0] + " " + a[i][1]);
    }
    System.out.println();
  }

  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<double[]> heap =
      new PriorityQueue<>((o1, o2) -> Double.compare(o2[2], o1[2]));

    for (int[] point : points) {
      int x = point[0], y = point[1];
      double d = Math.sqrt(x * x + y * y);

      if (heap.size() < k) {
        heap.add(new double[]{x, y, d});
      } else {
        double[] peek = heap.peek();
        if (peek[2] > d) {
          heap.poll();
          heap.add(new double[]{x, y, d});
        }
      }
    }

    int[][] result = new int[k][2];

    Iterator<double[]> it = heap.iterator();
    for (int i = 0; it.hasNext() && i < k; i++) {
      result[i] = new int[2];
      double[] items = it.next();

      result[i][0] = (int)items[0];
      result[i][1] = (int)items[1];
    }

    return result;
  }


}

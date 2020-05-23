package leetcode.p0011;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 973. K Closest Points to Origin
 * algorithm: Sort, Heap, Divide And Conquer
 * time complexity: O(nlog(k))
 * space complexity: O(k)
 * Runtime: 4 ms, faster than 99.72% of Java online submissions for K Closest Points to Origin.
 * Memory Usage: 58.6 MB, less than 77.02% of Java online submissions for K Closest Points to Origin.
 */
public class KClosestPointsToOrigin973 {

  public static void main(String[] args) {
    KClosestPointsToOrigin973 problem = new KClosestPointsToOrigin973();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{-95,76},{17,7},{-55,-58},{53,20},{-69,-8},{-57,87},{-2,-42},{-10,-87},{-36,-57},{97,-39},{97,49}};

    printArray(kClosest(tc1a, 5));
  }

  private void printArray(int[][] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i][0] + " " + a[i][1]);
    }
    System.out.println();
  }

  public int[][] kClosest(int[][] points, int k) {
    int pos = k - 1;

    int l = 0;
    int r = points.length - 1;

    while (l <= r) {
      int pivotIndex = partition(l, r, points);

      if (pivotIndex == pos) {
        break;
      } else if (pivotIndex < pos) {
        l = pivotIndex + 1;
      } else {
        r = pivotIndex - 1;
      }
    }

    return Arrays.copyOf(points, k);
  }

  private int partition(int l, int r, int[][] points) {
    int i = l + 1;
    int j = r;

    while (true) {
      while (i < r && dist(i, points) <= dist(l, points)) {
        i++;
      }

      while (j > l && dist(j, points) >= dist(l, points)) {
        j--;
      }

      if (i >= j) {
        break;
      }

      swap(i, j, points);

      i++;
      j--;
    }

    swap(l, j, points);

    return j;
  }

  private void swap(int i, int j, int[][] points) {
    int tempX = points[j][0];
    int tempY = points[j][1];

    points[j][0] = points[i][0];
    points[j][1] = points[i][1];

    points[i][0] = tempX;
    points[i][1] = tempY;
  }

  private int dist(int index, int[][] points) {
    return points[index][0] * points[index][0] + points[index][1] * points[index][1];
  }

  private static class HeapVersion {
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

  private static class V2 {
    public int[][] kClosest(int[][] points, int k) {
      sort(0, points.length - 1, k, points);

      int[][] solution = new int[k][2];

      for (int i = 0; i < k; i++) {
        solution[i][0] = points[i][0];
        solution[i][1] = points[i][1];
      }

      return solution;
    }

    private void sort(int l, int r, int k, int[][] points) {
      if (l >= r) {
        return;
      }

      int pivotIndex = partition(points, l, r);

      int len = pivotIndex - l + 1;
      if (len < k) {
        sort(pivotIndex + 1, r, k - len, points);
      } else if (len > k) {
        sort(l, pivotIndex - 1, k, points);
      }
    }

    private int partition(int[][] points, int start, int end) {
      int pivot = dist(points, start);

      int i = start + 1;
      int j = end;

      while (true) {
        while (i < end && dist(points, i) < pivot) {
          i++;
        }

        while (j > start && dist(points, j) > pivot) {
          j--;
        }

        if (i >= j) {
          break;
        }

        swap(points, i, j);

        i++;
        j--;
      }

      swap(points, start, j);

      return j;
    }

    private void swap(int[][] points, int i, int j) {
      int temp0 = points[i][0];
      int temp1 = points[i][1];

      points[i][0] = points[j][0];
      points[i][1] = points[j][1];

      points[j][0] = temp0;
      points[j][1] = temp1;
    }

    private int dist(int[][] points, int i) {
      return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }
  }


}

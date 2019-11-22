package prep;

import java.util.Arrays;
import utils.TestUtils;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{3,3},{5,-1},{-2,4}};
    TestUtils.printArray(kClosest(tc1a, 2));
  }

  public int[][] kClosest(int[][] points, int k) {
    int len = k - 1;

    int l = 0;
    int r = points.length - 1;

    while (l <= r) {
      int pivotIndex = partition(l, r, points);

      if (pivotIndex == len) {
        break;
      } else if (pivotIndex < len) {
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
      while (i <= j && dist(i, points) <= dist(l, points)) {
        i++;
      }

      while (j >= i && dist(j, points) >= dist(l, points)) {
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

}

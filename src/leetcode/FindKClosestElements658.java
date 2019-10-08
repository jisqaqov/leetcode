package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jandos Iskakov
 * problem: 658. Find K Closest Elements
 * algorithm: Binary Search, Sort time
 * complexity: O(log(n) + klog(k))
 * space complexity: O(k)
 */
public class FindKClosestElements658 {

  public static void main(String[] args) {
    FindKClosestElements658 problem = new FindKClosestElements658();
    problem.test();
  }

  private void test() {
    int[] tc1a = {1, 2, 3, 4, 5};
    System.out.println(findClosestElements(tc1a, 4, 3));
  }

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int n = arr.length;

    List<Integer> list = new ArrayList<>();
    if (n == 0) {
      return list;
    }

    if (arr[0] > x) {
      list = Arrays.stream(Arrays.copyOfRange(arr, 0, k))
          .boxed()
          .collect(Collectors.toList());
    } else if (arr[n - 1] < x) {
      list = Arrays.stream(Arrays.copyOfRange(arr, n - k, n))
          .boxed()
          .collect(Collectors.toList());
    } else {
      int p = -1;
      int l = 0, r = n - 1;

      while (l <= r) {
        int mid = l + (r - l) / 2;

        if (arr[mid] == x) {
          p = mid;
          r = mid - 1;
        } else if (arr[mid] < x) {
          l = mid + 1;
        } else if (arr[mid] > x) {
          p = mid;
          r = mid - 1;
        }
      }

      int start = p < k ? 0 : p - k;
      int end = Math.min(p + k, n);

      int[] tempArray = Arrays.copyOfRange(arr, start, end);
      list = Arrays.stream(tempArray)
          .boxed()
          .sorted((a, b) -> {
            int d1 = Math.abs(x - a);
            int d2 = Math.abs(x - b);

            if (d1 - d2 == 0) {
              return a - b;
            } else {
              return d1 - d2;
            }
          }).limit(k)
          .sorted(Comparator.comparingInt(e -> e))
          .collect(Collectors.toList());
    }

    return list;
  }

}

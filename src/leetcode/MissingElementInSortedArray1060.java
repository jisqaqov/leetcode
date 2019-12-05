package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 1060. Missing Element in Sorted Array
 * algorithm: Binary Search
 * time complexity: O(log(N))
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Element in Sorted Array.
 * Memory Usage: 48.5 MB, less than 100.00% of Java online submissions for Missing Element in Sorted Array.
 */
public class MissingElementInSortedArray1060 {

  public static void main(String[] args) {
    MissingElementInSortedArray1060 problem = new MissingElementInSortedArray1060();
    problem.test();
  }

  private void test() {
    int[] tc1a = {4, 7, 9, 10};
    int[] tc2a = {4, 7, 9, 10};
    int[] tc3a = {1, 2, 4};
    int[] tc4a = {1, 4};

    System.out.println(missingElement(tc1a, 1));//5
    System.out.println(missingElement(tc2a, 3));//8
    System.out.println(missingElement(tc3a, 3));//6
    System.out.println(missingElement(tc4a, 3));//5
  }

  public int missingElement(int[] a, int k) {
    int l = 0;
    int r = a.length - 1;

    while (l < r) {
      int m = l + (r - l) / 2;

      int d1 = a[m] - a[l] - m + l;
      if (d1 > 0 && d1 >= k) {
        r = m - 1;
      } else {
        k -= d1;
        int d2 = a[r] - a[m] - r + m;
        if (d2 < k) {
          k -= d2;
          l = r;
        } else if (l < m) {
          l = m;
        } else {
          r = l;
        }
      }
    }

    return a[l] + k;
  }

}

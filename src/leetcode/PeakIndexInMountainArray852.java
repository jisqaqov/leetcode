package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 852. Peak Index in a Mountain Array
 * algorithm: Binary Search
 * time complexity: O(log(N))
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 38.5 MB, less than 100.00% of Java online submissions
 */
public class PeakIndexInMountainArray852 {

  public static void main(String[] args) {
    PeakIndexInMountainArray852 problem = new PeakIndexInMountainArray852();
    problem.test();
  }

  private void test() {
    System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}));//1
    System.out.println(peakIndexInMountainArray(new int[]{0, 2, 1, 0}));//1
  }

  public int peakIndexInMountainArray(int[] a) {
    int l = 0;
    int r = a.length - 1;

    while (l < r) {
      int m = l + (r - l) / 2;

      if (a[m] < a[m + 1]) {
        l = m + 1;
      } else {
        r = m;
      }
    }

    return l;
  }

  private static class V2 {

    // check
    public int peakIndexInMountainArray(int[] a) {
      int l = 0;
      int r = a.length - 1;

      while (l < r) {
        int m = l + (r - l) / 2;

        if (a[m] < a[m + 1]) {
          l = m + 1;
        } else if (a[m] < a[m - 1]) {
          r = m;
        } else {
          return m;
        }
      }

      return -1;
    }
  }

}

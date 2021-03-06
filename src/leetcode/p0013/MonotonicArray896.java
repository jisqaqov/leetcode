package leetcode.p0013;

/**
 * @author Jandos Iskakov
 * problem: 896. Monotonic Array
 * algorithm: Array
 * time complexity: O(n)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Monotonic Array.
 * Memory Usage: 48.8 MB, less than 100.00% of Java online submissions for Monotonic Array.
 */
public class MonotonicArray896 {

  public static void main(String[] args) {
    MonotonicArray896 problem = new MonotonicArray896();
    problem.test();
  }

  private void test() {
    int[] tc1 = new int[] {1,2,2,3};
    int[] tc2 = new int[] {6,5,4,4};
    int[] tc3 = new int[] {1,3,2};
    int[] tc4 = new int[] {1,2,4,5};
    int[] tc5 = new int[] {1,1,1};

    System.out.println("v1:");
    System.out.println(isMonotonic(tc1));
    System.out.println(isMonotonic(tc2));
    System.out.println(isMonotonic(tc3));
    System.out.println(isMonotonic(tc4));
    System.out.println(isMonotonic(tc5));

    V2 v2 = new V2();
    System.out.println("v2:");
    System.out.println(v2.isMonotonic(tc1));
    System.out.println(v2.isMonotonic(tc2));
    System.out.println(v2.isMonotonic(tc3));
    System.out.println(v2.isMonotonic(tc4));
    System.out.println(v2.isMonotonic(tc5));

    V3 v3 = new V3();
    System.out.println("v3:");
    System.out.println(v3.isMonotonic(tc1));
    System.out.println(v3.isMonotonic(tc2));
    System.out.println(v3.isMonotonic(tc3));
    System.out.println(v3.isMonotonic(tc4));
    System.out.println(v3.isMonotonic(tc5));
  }

  public boolean isMonotonic(int[] a) {
    boolean increasing = true;
    boolean decreasing = true;

    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] < a[i + 1]) {
        decreasing = false;
      } else if (a[i] > a[i + 1]) {
        increasing = false;
      }
    }

    return increasing || decreasing;
  }

  private static class V3 {
    public boolean isMonotonic(int[] a) {
      int oldDiff = 0;

      for (int i = 0; i < a.length - 1; i++) {
        int diff = a[i] - a[i + 1];
        if (diff != 0) {
          if ((diff > 0 && oldDiff < 0) || (diff < 0 && oldDiff > 0)) {
            return false;
          }

          oldDiff = diff;
        }
      }

      return true;
    }
  }

  private static class V2 {
    public boolean isMonotonic(int[] a) {
      if (a.length <= 1) {
        return true;
      }

      int inc = 0;
      int dec = 0;

      for (int i = 1; i < a.length; i++) {
        if (a[i] >= a[i - 1]) {
          inc++;
        }

        if (a[i] <= a[i - 1]) {
          dec++;
        }
      }

      return inc == a.length - 1 || dec == a.length - 1;
    }
  }

}

package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
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

}
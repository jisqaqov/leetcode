package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
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
      int d2 = a[r] - a[m] - r + m;

      if (r - l == 1) {
        if (d2 >= k) {
          r = l;
        } else {
          l = r;
          k = k - d2;
        }
      } else {
        if (d1 > 0) {
          if (d1 >= k) {
            r = m - 1;
          } else {
            k = k - d1;
            l = m;   
          }
        } else {
          if (d2 >= k) {
            l = m;
          } else {
            l = r;
            k = k - d2;
          }
        }
      }
    }

    return a[l] + k;
  }

}
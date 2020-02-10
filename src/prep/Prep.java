package prep;

import java.util.ArrayList;
import java.util.List;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(pancakeSort(new int[] {4, 1, 3, 2}));
  }

  public List<Integer> pancakeSort(int[] a) {
    List<Integer> flips = new ArrayList<>();

    for (int i = a.length - 1; i > 0; i--) {
      int maxIndex = findMax(a, i);
      reverse(a, maxIndex);
      reverse(a, i);

      flips.add(maxIndex + 1);
      flips.add(i + 1);
    }

    return flips;
  }

  private int findMax(int[] a, int n) {
    int maxIndex = n;

    for (int i = 0; i <= n; i++) {
      if (a[i] > a[maxIndex]) {
        maxIndex = i;
      }
    }

    return maxIndex;
  }

  private void reverse(int[] a, int n) {
    int i = 0, j = n;

    while (i < j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;

      i++;
      j--;
    }
  }

}
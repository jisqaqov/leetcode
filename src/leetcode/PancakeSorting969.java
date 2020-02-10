package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 969. Pancake Sorting
 * algorithm: Array
 * time complexity: O(N^2)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 38.8 MB, less than 5.26% of Java online submissions
 */
public class PancakeSorting969 {

  public static void main(String[] args) {
    PancakeSorting969 problem = new PancakeSorting969();
    problem.test();
  }

  private void test() {
    System.out.println(pancakeSort(new int[] {4, 1, 3, 2}));
  }

  public List<Integer> pancakeSort(int[] a) {
    List<Integer> flips = new ArrayList<>();

    for (int i = a.length - 1; i > 0; i--) {
      int maxIndex = findMax(a, i);

      if (maxIndex != i) {
        reverse(a, maxIndex);
        reverse(a, i);

        flips.add(maxIndex + 1);
        flips.add(i + 1);
      }
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
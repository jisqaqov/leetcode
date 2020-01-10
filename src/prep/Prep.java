package prep;

import java.util.ArrayList;
import java.util.List;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(arraysIntersection(
      new int[]{1, 2, 3, 4, 5},
      new int[]{1, 2, 5, 7, 9},
      new int[]{1, 3, 4, 5, 8}
    ));
  }

  public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
    List<Integer> output = new ArrayList<>();

    int i = 0, j = 0, k = 0;

    while (i < arr1.length && j < arr2.length && k < arr3.length) {
      if (arr1[i] < arr2[j] || arr1[i] < arr3[k]) {
        i++;
      } else if (arr2[j] < arr1[i] || arr2[j] < arr3[k]) {
        j++;
      } else if (arr3[k] < arr1[i] || arr3[k] < arr2[j]) {
        k++;
      } else {
        output.add(arr1[i]);

        i++;
        j++;
        k++;
      }
    }

    return output;
  }

}
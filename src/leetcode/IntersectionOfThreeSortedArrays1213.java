package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 1213. Intersection of Three Sorted Arrays
 * algorithm: Two Pointers
 * time complexity: O(N+M+K)
 * space complexity: O(MIN(N, M, K))
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 39.4 MB, less than 100.00% of Java online submissions
 */
public class IntersectionOfThreeSortedArrays1213 {

  public static void main(String[] args) {
    IntersectionOfThreeSortedArrays1213 problem = new IntersectionOfThreeSortedArrays1213();
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
      if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
        output.add(arr1[i]);

        i++;
        j++;
        k++;
      } else if (arr1[i] < arr2[j]) {
        i++;
      } else if (arr2[j] < arr3[k]) {
        j++;
      } else {
        k++;
      }
    }

    return output;
  }

  private static class V3 {
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

  private static class V2 {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
      Map<Integer, Integer> map1 = new HashMap<>();
      for (int i = 0; i < arr1.length; i++) {
        map1.put(arr1[i], map1.getOrDefault(arr1[i], 0) + 1);
      }

      Map<Integer, Integer> map2 = new HashMap<>();
      for (int i = 0; i < arr2.length; i++) {
        map2.put(arr2[i], map2.getOrDefault(arr2[i], 0) + 1);
      }

      List<Integer> output = new ArrayList<>();

      for (int num : arr3) {
        if (map1.getOrDefault(num, 0) == 0 || map2.getOrDefault(num, 0) == 0) {
          continue;
        }

        output.add(num);

        map1.put(num, map1.get(num) - 1);
        map2.put(num, map2.get(num) - 1);
      }

      return output;
    }


  }

}
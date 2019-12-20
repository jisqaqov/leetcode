package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Given 2 lists a and b. Each element is a pair of integers where the first integer represents the
 * unique id and the second integer represents a value. Your task is to find an element from a and
 * an element form b such that the sum of their values is less or equal to target and as close to
 * target as possible. Return a list of ids of selected elements. If no pair is possible, return an
 * empty list.
 *
 * Example 1:
 *
 * Input: a = [[1, 2], [2, 4], [3, 6]] b = [[1, 2]] target = 7
 *
 * Output: [[2, 1]]
 *
 * Explanation: There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum
 * of 4, 6 and 8, respectively. Since 6 is the largest sum that does not exceed 7, [2, 1] is the
 * optimal pair. Example 2:
 *
 * Input: a = [[1, 3], [2, 5], [3, 7], [4, 10]] b = [[1, 2], [2, 3], [3, 4], [4, 5]] target = 10
 *
 * Output: [[2, 4], [3, 2]]
 *
 * Explanation: There are two pairs possible. Element with id = 2 from the list `a` has a value 5,
 * and element with id = 4 from the list `b` also has a value 5. Combined, they add up to 10.
 * Similarly, element with id = 3 from `a` has a value 7, and element with id = 2 from `b` has a
 * value 3. These also add up to 10. Therefore, the optimal pairs are [2, 4] and [3, 2].
 */
public class OptimalUtilization {

  public static void main(String[] args) {
    OptimalUtilization problem = new OptimalUtilization();
    problem.test();
  }

  private void test() {
    List<List<Integer>> tc1a = Arrays
      .asList(Arrays.asList(1, 2), Arrays.asList(2, 4), Arrays.asList(3, 6));
    List<List<Integer>> tc1b = Collections.singletonList(Arrays.asList(1, 2));

    System.out.println(maxPairs(tc1a, tc1b, 7));//[2, 1]

    List<List<Integer>> tc2a = Arrays
      .asList(Arrays.asList(1, 3), Arrays.asList(2, 5), Arrays.asList(3, 7), Arrays.asList(4, 10));
    List<List<Integer>> tc2b = Arrays
      .asList(Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(3, 4), Arrays.asList(4, 5));

    System.out.println(maxPairs(tc2a, tc2b, 10));//[2, 4], [3, 2]
  }

  public List<List<Integer>> maxPairs(List<List<Integer>> a, List<List<Integer>> b, int target) {
    List<List<Integer>> output = new ArrayList<>();

    TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
    for (List<Integer> list : b) {
      int id = list.get(0);
      int value = list.get(1);

      tree.putIfAbsent(value, new ArrayList<>());
      tree.get(value).add(id);
    }

    int max = -1;
    for (List<Integer> list : a) {
      int value = list.get(1);

      Integer floor = tree.floorKey(target - value);
      if (floor == null) {
        continue;
      }

      if (value + floor > max) {
        max = value + floor;
      }
    }

    if (max == -1) {
      return output;
    }

    for (List<Integer> list : a) {
      int id = list.get(0);
      int value = list.get(1);

      Entry<Integer, List<Integer>> floor = tree.floorEntry(target - value);
      if (floor == null) {
        continue;
      }

      if (value + floor.getKey() == max) {
        for (int id2 : floor.getValue()) {
          output.add(Arrays.asList(id, id2));
        }
      }
    }

    return output;
  }


}
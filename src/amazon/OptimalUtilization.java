package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import utils.TestUtils;

/**
 * @author Jandos Iskakov problem:
 *
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
 *
 * algorithm: Two Pointers
 *
 * time complexity: O(nlog(n) + mlog(m))
 *
 * space complexity: O(1)
 */
public class OptimalUtilization {

  public static void main(String[] args) {
    OptimalUtilization problem = new OptimalUtilization();
    problem.test();
  }

  private void test() {
    int[][] tc1a = {{1, 2}, {2, 4}, {3, 6}};
    int[][] tc1b = {{1, 2}};

    TestUtils.printArray(maxPairs(tc1a, tc1b, 7));//[2, 1]

    int[][] tc2a = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
    int[][] tc2b = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};

    TestUtils.printArray(maxPairs(tc2a, tc2b, 10));//[2, 4], [3, 2]

    int[][] tc3a = {{1, 8}, {2, 7}, {3, 14}};
    int[][] tc3b = {{1, 5}, {2, 10}, {3, 14}};

    TestUtils.printArray(maxPairs(tc3a, tc3b, 20));//[3, 1]

    int[][] tc4a = {{1, 8}, {2, 15}, {3, 9}};
    int[][] tc4b = {{1, 8}, {2, 11}, {3, 12}};

    TestUtils.printArray(maxPairs(tc4a, tc4b, 20));//[1, 3], [3, 2]
  }

  public int[][] maxPairs(int[][] a, int[][] b, int target) {
    Arrays.sort(a, Comparator.comparingInt(t -> t[1]));
    Arrays.sort(b, Comparator.comparingInt(t -> t[1]));

    List<int[]> list = new ArrayList<>();

    int max = Integer.MIN_VALUE;

    int i = 0;
    int j = b.length - 1;

    while (i < a.length && j >= 0) {
      int id1 = a[i][0];
      int id2 = b[j][0];

      int s = a[i][1] + b[j][1];

      if (s <= target) {
        if (s > max) {
          max = s;

          list.clear();
          list.add(new int[]{id1, id2});
        } else if (s == max) {
          list.add(new int[]{id1, id2});
        }

        i++;
      } else {
        j--;
      }
    }

    int[][] output = new int[list.size()][2];
    for (int k = 0; k < list.size(); k++) {
      output[k] = list.get(k);
    }

    return output;
  }


}
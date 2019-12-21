package amazon;

import java.util.HashMap;
import java.util.Map;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 *
 * Given a list of positive integers nums and an int target, return indices of the two numbers such
 * that they add up to a target - 30.
 *
 * Conditions:
 *
 * You will pick exactly 2 numbers. You cannot pick the same element twice. If you have muliple
 * pairs, select the pair with the largest number.
 *
 * Example 1:
 *
 * Input: nums = [1, 10, 25, 35, 60], target = 90
 * Output: [2, 3]
 * Explanation: nums[2] + nums[3] = 25 + 35 = 60 = 90 - 30
 *
 * algorithm: Hash Table
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class FindPairWithGivenSum {

  public static void main(String[] args) {
    FindPairWithGivenSum problem = new FindPairWithGivenSum();
    problem.test();
  }

  private void test() {
    TestUtils.printArray(findPairWithGivenSum(new int[]{1, 10, 25, 35, 60}, 90));//[2, 3]
    TestUtils.printArray(findPairWithGivenSum(new int[]{20, 50, 40, 25, 30, 10}, 90));//[1, 5]
  }

  public int[] findPairWithGivenSum(int[] nums, int target) {
    int[] idx = {-1, -1};

    target -= 30;

    int largest = Integer.MIN_VALUE;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int num = target - nums[i];

      if (map.containsKey(num) && Math.max(nums[i], num) > largest) {
        idx[0] = map.get(num);
        idx[1] = i;

        largest = Math.max(num, i);
      }

      map.put(nums[i], i);
    }

    return idx;
  }

}

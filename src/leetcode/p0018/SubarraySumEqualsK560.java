package leetcode.p0018;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 560. Subarray Sum Equals K
 * algorithm: Hash Table
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 13 ms, faster than 95.20% of Java online submissions for Subarray Sum Equals K.
 * Memory Usage: 38.2 MB, less than 98.91% of Java online submissions for Subarray Sum Equals K.
 */
public class SubarraySumEqualsK560 {

  public static void main(String[] args) {
    SubarraySumEqualsK560 problem = new SubarraySumEqualsK560();
    problem.test();
  }

  private void test() {
    int[] tc1a = {3, 2, 7, 1, 6, 4, 5, 2, 3};
    int[] tc2a = {0, 0};
    System.out.println(subarraySum(tc1a, 10));
    System.out.println(subarraySum(tc2a, 0));

    FacebookInterview interview = new FacebookInterview();
    System.out.println(interview.subarraySum(tc1a, 333));
    TestUtils.printArray(interview.subarraySum2(tc1a, 10));
  }

  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> counter = new HashMap<>();
    counter.put(0, 1);

    int t = 0;

    int prefix = 0;
    for (int num : nums) {
      prefix += num;

      if (counter.containsKey(prefix - k)) {
        t += counter.get(prefix - k);
      }

      counter.put(prefix, counter.getOrDefault(prefix, 0) + 1);
    }

    return t;
  }

  private static class FacebookInterview {
    public boolean subarraySum(int[] nums, int k) {
      Set<Integer> set = new HashSet<>();
      set.add(0);

      int prefix = 0;
      for (int num : nums) {
        prefix += num;

        if (set.contains(prefix - k)) {
          return true;
        }

        set.add(prefix);
      }

      return false;
    }

    public int[] subarraySum2(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, -1);

      int prefix = 0;
      for (int i = 0; i < nums.length; i++) {
        prefix += nums[i];

        if (map.containsKey(prefix - k)) {
          return new int[] {map.get(prefix - k) + 1, i};
        }

        map.put(prefix, i);
      }

      return null;
    }
  }

}

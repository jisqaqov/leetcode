package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 560. Subarray Sum Equals K
 * algorithm: Array, Hash Table
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 18 ms, faster than 33.08% of Java online submissions for Subarray Sum Equals K.
 * Memory Usage: 38.2 MB, less than 98.91% of Java online submissions for Subarray Sum Equals K.
 */
public class SubarraySumEqualsK560 {

  public static void main(String[] args) {
    SubarraySumEqualsK560 problem = new SubarraySumEqualsK560();
    problem.test();
  }

  private void test() {
    System.out.println(subarraySum(new int[] {1}, 1) == 1);
    System.out.println(subarraySum(new int[] {4,4,4,4}, 4) == 4);
    System.out.println(subarraySum(new int[] {1,1,1}, 2) == 2);
    System.out.println(subarraySum(new int[] {-1,-1,1}, 1) == 1);
    System.out.println(subarraySum(new int[] {-1,-1,1}, 0) == 1);
    System.out.println(subarraySum(new int[] {-791,145,97,-13,577,-515,-953,-813,-451,522,669,635,709,311,-15,-981,-837,512,-349,325,561,-763,-718,281,895,711,507,-708,999,-162,-230,-786,-178,829,-761,402,-865,-621,157,690,537,955,-769,-244,369,-664,331,652,-432,789,50,885,-838,-955,602,721,-239,-265,-459,416,-618,959,740,-644}, 129) == 8);
  }

  public int subarraySum(int[] nums, int k) {
    if (nums.length == 0) {
      return 0;
    }

    Map<Integer, Integer> counter = new HashMap<>();

    int prefix = nums[0];

    for (int i = 1; i < nums.length; i++) {
      prefix += nums[i];

      counter.put(prefix, counter.getOrDefault(prefix, 0) + 1);
    }

    prefix = 0;
    int t = 0;

    for (int i = 0; i < nums.length; i++) {
      int g = k + prefix;

      t += counter.getOrDefault(g, 0);
      prefix += nums[i];

      if (i > 0) {
        counter.put(prefix, counter.get(prefix) - 1);
      }
    }

    if (nums[0] == k) {
      t++;
    }

    return t;
  }

  private static class Bruteforce {
    public int subarraySum(int[] nums, int k) {
      int counter = 0;

      for (int i = 0; i < nums.length; i++) {
        int s = 0;
        for (int j = i; j < nums.length; j++) {
          s += nums[j];
          if (s == k) {
            counter++;
          }
        }
      }

      return counter;
    }
  }

}

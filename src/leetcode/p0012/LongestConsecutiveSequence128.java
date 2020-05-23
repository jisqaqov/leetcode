package leetcode.p0012;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 128. Longest Consecutive Sequence
 * algorithm: Set
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 3 ms, faster than 91.50% of Java online submissions
 * Memory Usage: 39.5 MB, less than 20.69% of Java online submissions
 */
public class LongestConsecutiveSequence128 {

  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    Set<Integer> used = new HashSet<>();

    int len = 0;

    for (int num : nums) {
      if (!set.contains(num - 1) && !used.contains(num)) {
        used.add(num);

        int low = num;
        while (set.contains(low + 1)) {
          low++;
        }

        len = Math.max(len, low - num + 1);
      }
    }

    return len;
  }

  private class V2 {

    public int longestConsecutive(int[] nums) {
      Set<Integer> set = new HashSet<>();

      for (int num : nums) {
        set.add(num);
      }

      int len = 0;

      for (int num : nums) {
        if (!set.contains(num)) {
          continue;
        }

        int count = 1;

        int low = num - 1;
        while (set.contains(low)) {
          set.remove(low);

          count++;
          --low;
        }

        int high = num + 1;
        while (set.contains(high)) {
          set.remove(high);

          count++;
          high++;
        }

        len = Math.max(len, count);
      }

      return len;
    }
  }

}
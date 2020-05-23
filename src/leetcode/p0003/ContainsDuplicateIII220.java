package leetcode.p0003;

import java.util.TreeSet;

/**
 * @author Jandos Iskakov
 * problem: 220. Contains Duplicate III
 * algorithm: Ordered Map, Sliding Window
 * time complexity: O(nlog(k))
 * space complexity: O(K)
 * Runtime: 14 ms, faster than 72.47% of Java online submissions for Contains Duplicate III.
 * Memory Usage: 36.4 MB, less than 97.73% of Java online submissions for Contains Duplicate III.
 */
public class ContainsDuplicateIII220 {

  public static void main(String[] args) {
    ContainsDuplicateIII220 problem = new ContainsDuplicateIII220();
    problem.test();
  }

  private void test() {
    int[] tc1a = {-1, 2147483647};
    System.out.println(containsNearbyAlmostDuplicate(tc1a, 1, 2147483647));
  }

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (t < 0) {
      return false;
    }

    TreeSet<Integer> set = new TreeSet<>();

    for (int i = 0; i < nums.length; i++) {
      if (i > k) {
        set.remove(nums[i - k - 1]);
      }

      if (set.contains(nums[i])) {
        return true;
      }

      if (t > 0) {
        Integer lowerKey = set.lower(nums[i]);
        Integer higherKey = set.higher(nums[i]);

        if ((lowerKey != null && Math.abs((long) lowerKey - nums[i]) <= t) ||
            (higherKey != null && Math.abs((long) higherKey - nums[i]) <= t)) {
          return true;
        }
      }

      set.add(nums[i]);
    }

    return false;
  }


}

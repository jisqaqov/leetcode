package leetcode;

import java.util.Random;

/**
 * @author Jandos Iskakov
 * problem: 398. Random Pick Index
 * algorithm: Reservoir Sampling
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 60 ms, faster than 73.15% of Java online submissions
 * Memory Usage: 56.8 MB, less than 5.88% of Java online submissions
 */
public class RandomPickIndex398 {

  public static void main(String[] args) {
    RandomPickIndex398 problem = new RandomPickIndex398();
    problem.test();
  }

  private void test() {
    Solution solution = new Solution(new int[]{1, 2, 3, 3, 3});
    System.out.println(solution.pick(3));
    System.out.println(solution.pick(1));
  }

  private class Solution {

    private Random random = new Random();
    private int[] nums;

    public Solution(int[] nums) {
      this.nums = nums;
    }

    public int pick(int target) {
      int index = -1;
      int count = 0;

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != target) {
          continue;
        }

        count++;

        if (random.nextInt(count) == 0) {
          index = i;
        }
      }

      return index;
    }
  }

}

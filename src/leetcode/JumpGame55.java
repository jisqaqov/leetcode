package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 55. Jump Game
 * algorithm: Greedy
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 98.45% of Java online submissions
 * Memory Usage: 41.1 MB, less than 49.57% of Java online submissions
 */
public class JumpGame55 {

  public static void main(String[] args) {
    JumpGame55 problem = new JumpGame55();
    problem.test();
  }

  private void test() {
    System.out.println(canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));//true
    System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));//false
    System.out.println(canJump(new int[]{2, 0}));//true
  }

  public boolean canJump(int[] nums) {
    int start = 0, end = 0;

    while (end < nums.length - 1) {
      int maxIndex = 0;
      for (int i = start; i <= end; i++) {
        maxIndex = Math.max(maxIndex, i + nums[i]);
      }

      if (maxIndex == end) {
        return false;
      }

      start = end + 1;
      end = maxIndex;
    }

    return true;
  }

}
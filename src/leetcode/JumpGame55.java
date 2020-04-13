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
    System.out.println(canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
    System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    System.out.println(canJump(new int[]{2, 0}));
  }

  public boolean canJump(int[] nums) {
    int reachIndex = 0;
    int maxIndex = 0;

    while (reachIndex < nums.length - 1) {
      if (nums[maxIndex] == 0) {
        return false;
      }

      int jumpIndex = maxIndex + nums[maxIndex];
      for (int i = reachIndex + 1; i <= jumpIndex && i < nums.length; i++) {
        if (i + nums[i] >= maxIndex + nums[maxIndex]) {
          maxIndex = i;
        }
      }

      reachIndex = jumpIndex;
    }

    return true;
  }

}
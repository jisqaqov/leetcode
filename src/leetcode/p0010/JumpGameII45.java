package leetcode.p0010;

/**
 * @author Jandos Iskakov
 * problem: 45. Jump Game II
 * algorithm: Greedy
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 41.1 MB, less than 38.46% of Java online submissions
 */
public class JumpGameII45 {

  public static void main(String[] args) {
    JumpGameII45 problem = new JumpGameII45();
    problem.test();
  }

  private void test() {
    System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
  }

  public int jump(int[] nums) {
    int n = nums.length;
    if (n <= 1) {
      return 0;
    }

    int jumps = 0;

    int maxIndex = 0;

    for (int i = 0; i < n; ) {
      int endIndex = nums[maxIndex] + maxIndex;
      if (endIndex >= n) {
        return jumps + 1;
      }

      int maxDis = 0;
      while (i <= endIndex) {
        int dis = nums[i] - (endIndex - i);
        if (dis > maxDis) {
          maxDis = dis;
          maxIndex = i;
        }

        i++;
      }

      jumps++;
    }

    return jumps;
  }

}
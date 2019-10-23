package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 42. Trapping Rain Water
 * algorithm: Two Pointers, DP
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 98.47% of Java online submissions for Trapping Rain Water.
 * Memory Usage: 37.2 MB, less than 98.63% of Java online submissions for Trapping Rain Water.
 */
public class TrappingRainWater42 {

  public static void main(String[] args) {
    TrappingRainWater42 problem = new TrappingRainWater42();
    problem.test();
  }

  private void test() {
    System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
  }

  public int trap(int[] height) {
    int n = height.length;
    if (n == 0) {
      return 0;
    }

    int[] maxLeft = new int[n];
    maxLeft[0] = height[0];
    for (int i = 1; i < n; i++) {
      maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
    }

    int[] maxRight = new int[n];
    maxRight[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      maxRight[i] = Math.max(height[i], maxRight[i + 1]);
    }

    int water = 0;
    for (int i = 0; i < n; i++) {
      water += Math.min(maxLeft[i], maxRight[i]) - height[i];
    }

    return water;
  }

}

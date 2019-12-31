package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 11. Container With Most Water
 * algorithm: Two Pointers
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 3 ms, faster than 42.45% of Java online submissions
 * Memory Usage: 39.8 MB, less than 94.87% of Java online submissions
 */
public class ContainerWithMostWater11 {

  public static void main(String[] args) {
    ContainerWithMostWater11 problem = new ContainerWithMostWater11();
    problem.test();
  }

  private void test() {
    int[] tc1a = {3, 9, 3, 4, 7, 2, 12, 6};
    System.out.println(maxArea(tc1a));
  }

  public int maxArea(int[] height) {
    int max = 0;

    int i = 0, j = height.length - 1;

    while (i < j) {
      int a = Math.min(height[i], height[j]) * (j - i);

      max = Math.max(a, max);

      if (height[i] < height[j]) {
        i++;
      } else if (height[i] > height[j]) {
        j--;
      } else {
        i++;
        j--;
      }
    }

    return max;
  }

}

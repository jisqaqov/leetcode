package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 1004. Max Consecutive Ones III
 * algorithm: Sliding Window
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 4 ms, faster than 78.66% of Java online submissions for Max Consecutive Ones III.
 * Memory Usage: 41.8 MB, less than 100.00% of Java online submissions for Max Consecutive Ones III.
 */
public class MaxConsecutiveOnesIII {

  public static void main(String[] args) {
    MaxConsecutiveOnesIII problem = new MaxConsecutiveOnesIII();
    problem.test();
  }

  private void test() {
    int[] tc1a = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
    System.out.println(longestOnes(tc1a, 2));

    int[] tc2a = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
    System.out.println(longestOnes(tc2a, 3));
  }

  public int longestOnes(int[] a, int k) {
    int len = 0;

    int start = 0;
    int end = 0;

    int t = 0;

    while (end < a.length) {
      while (end < a.length && t <= k) {
        if (a[end] == 0) {
          t++;
        }

        if (t <= k) {
          len = Math.max(len, end - start + 1);
        }

        end++;
      }

      if (a[start] == 0) {
        t--;
      }

      start++;
    }

    return len;
  }

}

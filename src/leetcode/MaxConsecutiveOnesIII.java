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
    problem.facebookInterview();
  }

  private void test() {
    V2 v2 = new V2();

    int[] tc1a = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
    System.out.println(longestOnes(tc1a, 2));

    int[] tc2a = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
    System.out.println(longestOnes(tc2a, 3));

    System.out.println("v2:");
    System.out.println(v2.longestOnes(tc1a, 2));
    System.out.println(v2.longestOnes(tc2a, 3));
  }

  private void facebookInterview() {
    System.out.println("facebook interview:");
    FacebookInterview interview = new FacebookInterview();

    boolean[] tc1a = {false, true, false, true, false, true, false};
    System.out.println(interview.findMaxVacationLength(tc1a, 2));
  }

  public int longestOnes(int[] a, int k) {
    int start = 0;
    int zeroes = 0;
    int len = 0;

    for (int end = 0; end < a.length; end++) {
      if (a[end] == 0) {
        zeroes++;
      }

      while (zeroes > k) {
        if (a[start] == 0) {
          zeroes--;
        }

        start++;
      }

      len = Math.max(len, end - start + 1);
    }

    return len;
  }

  /**
   * variation of the problem
   * Given boolean array of days at work, [T, F, T, T, F, F, F, T] and
   * pto (number of PTOs one can take) - where boolean T means paid holiday and F means you can take a PTO. Find the maximum length of vacation an employee can take.
   * int findMaxVacationLength(year = [F, T, F, T, F, T, F, ], pto = 2) should return 5 because if we take PTO on indices year[2] and year[4], then we can get the maximum length vacation (consecutive T's).
   *
   */
  private static class FacebookInterview {

    public int findMaxVacationLength(boolean[] a, int pto) {
      int counter = 0;
      int start = 0;
      int len = 0;

      for (int end = 0; end < a.length; end++) {
        if (!a[end]) {
          counter++;
        }

        while (counter > pto) {
          if (!a[start]) {
            counter--;
          }

          start++;
        }

        len = Math.max(len, end - start + 1);
      }

      return len;
    }
  }

  private static class V2 {
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

}

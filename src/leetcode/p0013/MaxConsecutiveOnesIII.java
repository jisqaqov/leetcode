package leetcode.p0013;

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

    boolean[] tc1a = {false, false, true, true, false, true, false};
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
   * Given a boolean array and a number, the number of paid-time off days (PTO),
   * return the maximum number of vacation days you can take. Here, vacation means anything like holidays, weekends, etc.
   * So, "True" means work days, and "False" means days off (weekends, holidays, etc.),
   * and you can take any work days as paid-time off days (PTO).
   * E.g.
   * Input: [ F F T T F T F ] , PTO = 2
   * Output: maximum number of vacation days = 5, because you could make index 2 and index 3 your
   * two PTO days, and you would get 5 consecutive vacation days/days off (p0009.e. F F F F F).
   *
   * links:
   * https://leetcode.com/discuss/interview-question/412764/Facebook-or-Maximum-Number-of-Vacation-Days
   * https://leetcode.com/discuss/interview-question/433502/facebook-phone-number-of-islands-maximum-vacation-length/
   */
  private static class FacebookInterview {

    public int findMaxVacationLength(boolean[] days, int k) {
      int counter = 0;
      int start = 0;
      int len = 0;

      for (int end = 0; end < days.length; end++) {
        if (days[end]) {
          counter++;
        }

        while (counter > k) {
          if (days[start]) {
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

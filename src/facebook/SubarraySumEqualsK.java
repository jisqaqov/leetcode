package facebook;

/**
 * @author Jandos Iskakov
 * algorithm: Two Pointers
 * time complexity: O(N)
 * space complexity: O(1)
 * problem:  Given a sequence of positive integers A and an integer T,
 * return whether there is a continuous sequence of A that sums up to exactly T
 * example:
 * [23, 5, 4, 7, 2, 11], 20. Return True because 7 + 2 + 11 = 20
 * [1, 3, 5, 23, 2], 8. Return True  because 3 + 5 = 8
 * [1, 3, 5, 23, 2], 7 Return False because no sequence in this array adds up to 7
 */
public class SubarraySumEqualsK {

  public static void main(String[] args) {
    SubarraySumEqualsK problem = new SubarraySumEqualsK();
    problem.test();
  }

  public void test() {
    System.out.println(maxSubArrayExists(new int[] {23, 5, 4, 7, 2, 11}, 20));//true
    System.out.println(maxSubArrayExists(new int[] {1, 3, 5, 23, 2}, 8));//true
    System.out.println(maxSubArrayExists(new int[] {1, 3, 5, 23, 2}, 7));//false
  }

  public boolean maxSubArrayExists(int[] nums, int s) {
    int k = 0;

    int start = 0;
    for (int num : nums) {
      k += num;

      while (k > s) {
        k -= nums[start];
        start++;
      }

      if (k == s) {
        return true;
      }
    }

    return false;
  }

}

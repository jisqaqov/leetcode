package leetcode;

public class SubarraySumEqualsK560 {

  public static void main(String[] args) {
    SubarraySumEqualsK560 problem = new SubarraySumEqualsK560();
    problem.test();
  }

  private void test() {
    int[] tc1a = {1, 1, 1};
    System.out.println(subarraySum(tc1a, 2));

    int[] tc2a = {1};
    System.out.println(subarraySum(tc2a, 0));

    int[] tc3a = {-1, -1, 1};
    System.out.println(subarraySum(tc3a, 0));
  }

  public int subarraySum(int[] nums, int k) {
    if (nums.length == 0) {
      return 0;
    }

    int start = 0;
    int numbers = 0;
    int s = 0;
    int i = 0;
    int counter = 0;

    while (i < nums.length) {
      while (i < nums.length && (s < k || numbers == 0)) {
        s += nums[i];
        numbers++;
        i++;
      }

      while (start <= i && (s > k || i == nums.length)) {
        s -= nums[start];
        numbers--;
        start++;

        if (s == k) {
          break;
        }
      }

      if (numbers == 0) {
        i++;
      } else if (s == k) {
        s -= nums[start];
        numbers--;
        start++;

        counter++;
      }
    }


    return counter;
  }

}

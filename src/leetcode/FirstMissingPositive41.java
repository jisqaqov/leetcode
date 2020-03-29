package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 41. First Missing Positive
 * algorithm: Array
 * time complexity: O(n)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 37.8 MB, less than 6.85% of Java online submissions
 */
public class FirstMissingPositive41 {

  public static void main(String[] args) {
    FirstMissingPositive41 problem = new FirstMissingPositive41();
    problem.test();
  }

  private void test() {
    System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
  }

  public int firstMissingPositive(int[] nums) {
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      while (nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i]) {
        swap(nums, i, nums[i] - 1);
      }
    }

    for (int i = 0; i < n; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }

    return n + 1;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }

}
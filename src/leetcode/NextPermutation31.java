package leetcode;

import java.util.ArrayList;
import java.util.List;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 31. Next Permutation
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 89.95% of Java online submissions for Next Permutation.
 * Memory Usage: 40.1 MB, less than 47.00% of Java online submissions for Next Permutation.
 */
public class NextPermutation31 {

  public static void main(String[] args) {
    NextPermutation31 problem = new NextPermutation31();
    problem.test();
    problem.testV2();
    problem.interview();
  }

  private void test() {
    int[] tc1a = {6, 2, 1, 5, 4, 3, 0};
    nextPermutation(tc1a);
    TestUtils.printArray(tc1a);

    int[] tc2a = {1, 2, 3};
    nextPermutation(tc2a);
    TestUtils.printArray(tc2a);

    int[] tc3a = {1, 1, 5};
    nextPermutation(tc3a);
    TestUtils.printArray(tc3a);

    int[] tc4a = {3, 2, 1};
    nextPermutation(tc4a);
    TestUtils.printArray(tc4a);

    int[] tc5a = {2, 3, 1, 3, 3};
    nextPermutation(tc5a);
    TestUtils.printArray(tc5a);
  }

  private void testV2() {
    System.out.println("v2:");

    V2 v2 = new V2();

    int[] tc1a = {6, 2, 1, 5, 4, 3, 0};
    v2.nextPermutation(tc1a);
    TestUtils.printArray(tc1a);

    int[] tc2a = {1, 2, 3};
    v2.nextPermutation(tc2a);
    TestUtils.printArray(tc2a);

    int[] tc3a = {1, 1, 5};
    v2.nextPermutation(tc3a);
    TestUtils.printArray(tc3a);

    int[] tc4a = {3, 2, 1};
    v2.nextPermutation(tc4a);
    TestUtils.printArray(tc4a);

    int[] tc5a = {2, 3, 1, 3, 3};
    v2.nextPermutation(tc5a);
    TestUtils.printArray(tc5a);
  }

  private void interview() {
    System.out.println("facebook interview:");

    FacebookInterview interview = new FacebookInterview();
    System.out.println(interview.nextPermutationOfNumber(6215430));
    System.out.println(interview.nextPermutationOfNumber(123));
    System.out.println(interview.nextPermutationOfNumber(115));
    System.out.println(interview.nextPermutationOfNumber(321));
    System.out.println(interview.nextPermutationOfNumber(23133));
  }

  public void nextPermutation(int[] nums) {
    if (nums.length < 2) {
      return;
    }

    int index = nums.length - 2;
    while (index >= 0 && nums[index] >= nums[index + 1]) {
      index--;
    }

    if (index == -1) {
      reverse(nums, 0);
    } else {
      int j = nums.length - 1;

      for (; j > index; j--) {
        if (nums[j] > nums[index]) {
          break;
        }
      }

      swap(nums, index, j);

      reverse(nums, index + 1);
    }
  }

  private class V2 {
    public void nextPermutation(int[] nums) {
      if (nums.length < 2) {
        return;
      }

      int index = -1;

      for (int i = nums.length - 1; i > 0; i--) {
        if (nums[i - 1] < nums[i]) {
          index = i - 1;
          break;
        }
      }

      if (index == -1) {
        reverse(nums, 0);
      } else {
        int j = nums.length - 1;

        for (; j > index; j--) {
          if (nums[j] > nums[index]) {
            break;
          }
        }

        swap(nums, index, j);

        reverse(nums, index + 1);
      }
    }
  }

  private void reverse(int[] nums, int start) {
    int end = nums.length - 1;
    while (start < end) {
      swap(nums, start, end);

      start++;
      end--;
    }
  }

  private void swap(int[] a, int i, int j) {
    int temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }

  private class FacebookInterview {
    public int nextPermutationOfNumber(int number) {
      int[] nums = getNumbers(number);

      nextPermutation(nums);

      return convertToNumber(nums);
    }

    private int[] getNumbers(int number) {
      List<Integer> list = new ArrayList<>();

      while (number > 0) {
        list.add(number % 10);
        number = number / 10;
      }

      int j = list.size() - 1;
      int[] nums = new int[list.size()];
      for (int i = 0; i < nums.length; i++) {
        nums[i] = list.get(j);
        j--;
      }

      return nums;
    }

    private int convertToNumber(int[] nums) {
      int n = 0;
      for (int num : nums) {
        n = n * 10 + num;
      }
      return n;
    }

  }

}

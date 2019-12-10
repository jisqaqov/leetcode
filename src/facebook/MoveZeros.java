package facebook;

import utils.TestUtils;

/**
 *
 * Write an algorithm that brings all nonzero elements to the left of the array, and
 * returns the number of nonzero elements.
 * Example input:  [ 1, 0, 2, 0, 0, 3, 4 ]
 * Example output: 4
 * [1, 4, 2, 3, 0, 0, 0]
 * The algorithm should operate in place, i.e. shouldn't create a new array.
 * The order of nonzero elements does not matter
 */
public class MoveZeros {

  public static void main(String[] args) {
    MoveZeros problem = new MoveZeros();
    problem.test();
  }

  private void test() {
    int[] tc1a = {1, 0, 2, 0, 0, 3, 4};
    System.out.println(moveZeroes(tc1a));

    TestUtils.printArray(tc1a);
  }

  public int moveZeroes(int[] nums) {
    int zeros = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeros++;
      } else if (zeros > 0) {
        nums[i - zeros] = nums[i];
        nums[i] = 0;
      }
    }

    return nums.length - zeros;
  }

}

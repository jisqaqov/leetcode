package facebook;

import utils.TestUtils;

public class MoveZeros {

  public static void main(String[] args) {
    MoveZeros problem = new MoveZeros();
    problem.test2();
  }

  private void test2() {
    int[] tc1a = {0, 1, 0, 3, 12};
    moveZeroes(tc1a);

    TestUtils.printArray(tc1a);
  }

  public void moveZeroes(int[] nums) {
    int j = nums.length - 1;

    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] != 0) {
        if (i != j) {
          int temp = nums[j];
          nums[j] = nums[i];
          nums[i] = temp;
        }

        j--;
      }
    }
  }

}

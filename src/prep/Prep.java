package prep;

import utils.TestUtils;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    int[] tc1a = {0, 1, 0, 3, 12};
    moveZeroes(tc1a);
    TestUtils.printArray(tc1a);
  }

  public void moveZeroes(int[] nums) {
    int p = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[p] = nums[i];
        p++;
      }
    }

    for (; p < nums.length; p++) {
      nums[p] = 0;
    }
  }

}
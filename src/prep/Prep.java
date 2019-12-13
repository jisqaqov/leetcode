package prep;

import java.util.Random;
import utils.TestUtils;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    TestUtils.printArray(maxValueRandom(new int[]{11, 30, 2, 30, 30, 30, 6, 2, 62, 62}));
  }

  public int[] maxValueRandom(int[] nums) {
    Random random = new Random();
    int maxIndex = 0;

    int count = 1;
    int[] output = new int[nums.length];
    output[0] = 0;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[maxIndex]) {
        maxIndex = i;
        count = 1;
      } else if (nums[i] == nums[maxIndex]) {
        count++;

        //Math.random() < 1.0 / count
        if (random.nextInt(count) == 0) {
          maxIndex = i;
        }
      }

      output[i] = maxIndex;
    }

    return output;
  }


}
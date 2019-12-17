package facebook;

import java.util.Random;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * algorithm: Reservouir Sampling
 * time complexity: O(N)
 * space complexity: O(1)
 * problem:
 * Generate random max index
 * Given an array of integers, randomly return an index of the maximum value seen by far.
 * e.g.
 * Given [11,30,2,30,30,30,6,2,62, 62]
 * Having iterated up to the at element index 5 (where the last 30 is),
 * randomly give an index among [1, 3, 4, 5] which are indices of 30 - the
 * max value by far. Each index should have a ¼ chance to get picked.
 * Having iterated through the entire array, randomly give an
 * index between 8 and 9 which are indices of the max value 62.
 *
 */
public class MaxRandomIndex {

  public static void main(String[] args) {
    MaxRandomIndex problem = new MaxRandomIndex();
    problem.test();
  }

  private void test() {
    maxRandomIndex(new int[]{11, 30, 2, 30, 30, 30, 6, 2, 62, 62});
  }

  public void maxRandomIndex(int[] nums) {
    Random random = new Random();

    int max = Integer.MIN_VALUE;
    int maxIndex = -1;

    int count = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        max = nums[i];
        maxIndex = i;
        count = 1;
      } else if (nums[i] == max) {
        count++;

        // probability of 1/count
        if (random.nextInt(count) == 0) {
          maxIndex = i;
        }
      }

      System.out.print(maxIndex + " ");
    }
  }

}

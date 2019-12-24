package prep;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    //TODO:

  }

  private class Solution {
    private Random random = new Random();
    private int[] nums;

    public Solution(int[] nums) {
      this.nums = nums;
    }

    public int pick(int target) {
      int index = -1;
      int count = 0;

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != target) {
          continue;
        }

        count++;

        if (random.nextInt(count) == 0) {
          index = i;
        }
      }

      return index;
    }
  }



}
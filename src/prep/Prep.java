package prep;

import java.util.Random;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {

  }

  class Solution {
    private Random random;
    private int[] w;
    private int totalWeight;

    public Solution(int[] w) {
      this.w = w;
      random = new Random();

      totalWeight = 0;
      for (int weight : w) {
        totalWeight += weight;
      }
    }

    public int pickIndex() {
      int randomWeight = random.nextInt(totalWeight);

      int index = 0;
      for (int i = 0; i < w.length; i++) {
        randomWeight -= w[i];
        if (randomWeight <= 0) {
          index = i;
          break;
        }
      }

      return index;
    }
  }

}
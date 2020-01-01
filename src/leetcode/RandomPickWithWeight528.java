package leetcode;

import java.util.Random;

/**
 * @author Jandos Iskakov
 * problem: 528. Random Pick with Weight
 * algorithm: Random,
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 47 ms, faster than 52.70% of Java online submissions
 * Memory Usage: 50.5 MB, less than 34.33% of Java online submissions
 */
public class RandomPickWithWeight528 {

  public static void main(String[] args) {
    RandomPickWithWeight528 problem = new RandomPickWithWeight528();
    problem.test();
  }

  private void test() {
    Solution sol = new Solution(new int[] {3, 14, 1, 7});
    for (int i = 0; i < 100; i++) {
      System.out.println(sol.pickIndex());
    }
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

package leetcode;

import java.util.Random;

/**
 * @author Jandos Iskakov
 * problem: 528. Random Pick with Weight
 * algorithm: Random,
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 21 ms, faster than 99.96% of Java online submissions
 * Memory Usage: 43.9 MB, less than 95.52% of Java online submissions
 * */
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
    private int[] prefix;
    private int totalWeight = 0;

    public Solution(int[] w) {
      random = new Random();
      prefix = new int[w.length];

      for (int i = 0; i < w.length; i++) {
        totalWeight += w[i];
        prefix[i] = totalWeight;
      }
    }

    public int pickIndex() {
      int target = random.nextInt(totalWeight);

      int l = 0;
      int r = prefix.length - 1;

      while (l < r) {
        int m = l + (r - l) / 2;

        if (prefix[m] <= target) {
          l = m + 1;
        } else {
          r = m;
        }
      }

      return l;
    }

  }

  class SolutionV2 {
    private Random random;
    private int[] w;
    private int totalWeight;

    public SolutionV2(int[] w) {
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
        if (randomWeight < 0) {
          index = i;
          break;
        }
      }

      return index;
    }
  }

}

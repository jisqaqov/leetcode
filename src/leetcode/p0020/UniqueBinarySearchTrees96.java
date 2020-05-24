package leetcode.p0020;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 96. Unique Binary Search Trees
 * algorithm: DP
 */
public class UniqueBinarySearchTrees96 {

  private final Map<Integer, Integer> memo = new HashMap<>();

  public static void main(String[] args) {
    UniqueBinarySearchTrees96 solution = new UniqueBinarySearchTrees96();
    solution.test();
  }

  public void test() {
    System.out.println(numTrees(2));
    System.out.println(numTrees(3));
    System.out.println(numTrees(4));
    System.out.println(numTrees(5));

    System.out.println(numTreesTopDown(2));
    System.out.println(numTreesTopDown(3));
    System.out.println(numTreesTopDown(4));
    System.out.println(numTreesTopDown(5));
  }

  public int numTrees(int n) {
    int[] memo = new int[n + 1];
    memo[1] = 1;

    for (int k = 2; k <= n; k++) {
      int trees = 0;
      for (int root = 1; root <= k; root++) {
        int left = root - 1;
        int right = k - root;

        if (left > 0 && right > 0) {
          trees += memo[left] * memo[right];
        } else {
          trees += memo[left] + memo[right];
        }
      }

      memo[k] = trees;
    }

    return memo[n];
  }

  public int numTreesTopDown(int n) {
    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    if (memo.containsKey(n)) {
      return memo.get(n);
    }

    int trees = 0;
    for (int root = 1; root <= n; root++) {
      int left = numTreesTopDown(root - 1);
      int right = numTreesTopDown(n - root);

      if (left > 0 && right > 0) {
        trees += left * right;
      } else {
        trees += left + right;
      }
    }

    memo.put(n, trees);

    return memo.get(n);
  }

}

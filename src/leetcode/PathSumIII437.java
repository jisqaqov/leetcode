package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 437. Path Sum III
 * algorithm: Tree
 * time complexity: O(N^2)
 * space complexity: O(N)
 * Runtime: 21 ms, faster than 51.96% of Java online submissions
 * Memory Usage: 39.5 MB, less than 81.82% of Java online submissions
 */
public class PathSumIII437 {

  public int pathSum(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }

    return helper(root, sum) +
      pathSum(root.left, sum) +
      pathSum(root.right, sum);
  }

  private int helper(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }

    int k = root.val == sum ? 1 : 0;
    k += helper(root.left, sum - root.val) +
      helper(root.right, sum - root.val);

    return k;
  }

  private static class V2 {

    public int pathSum(TreeNode root, int sum) {
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);

      return helper(root, 0, sum, map);
    }

    private int helper(TreeNode root, int prefix, int k, Map<Integer, Integer> map) {
      if (root == null) {
        return 0;
      }

      prefix += root.val;

      int count = map.getOrDefault(prefix - k, 0);

      map.put(prefix, map.getOrDefault(prefix, 0) + 1);

      count += helper(root.left, prefix, k, map) +
        helper(root.right, prefix, k, map);

      map.put(prefix, map.get(prefix) - 1);

      return count;
    }

  }

  /**
   * Definition for a binary tree node.
   */
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


}

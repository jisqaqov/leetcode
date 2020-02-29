package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 337. House Robber III
 * algorithm: Tree, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 39.6 MB, less than 58.33% of Java online submissions
 */
public class HouseRobberIII337 {

  private static final int[] ZERO_ARR = {0, 0};

  public int rob(TreeNode root) {
    return helper(root)[0];
  }

  private int[] helper(TreeNode root) {
    if (root == null) {
      return ZERO_ARR;
    }

    int[] left = helper(root.left);
    int[] right = helper(root.right);

    int[] max = new int[2];

    max[0] = Math.max(root.val + left[1] + right[1],
      left[0] + right[0]);

    max[1] = left[0] + right[0];

    return max;
  }


  private static class V2 {

    public int rob(TreeNode root) {
      Map<TreeNode, Integer> dp = new HashMap<>();
      return helper(root, dp);
    }

    private int helper(TreeNode root, Map<TreeNode, Integer> map) {
      if (root == null) {
        return 0;
      }

      if (map.containsKey(root)) {
        return map.get(root);
      }

      int max1 = helper(root.left, map) + helper(root.right, map);

      int max2 = root.val;
      if (root.left != null) {
        max2 += helper(root.left.left, map) + helper(root.left.right, map);
      }

      if (root.right != null) {
        max2 += helper(root.right.left, map) + helper(root.right.right, map);
      }

      int max = Math.max(max1, max2);

      map.put(root, max);

      return max;
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

    @Override
    public String toString() {
      return "TreeNode{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
    }
  }

}

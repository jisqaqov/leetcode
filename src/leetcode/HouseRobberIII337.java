package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 337. House Robber III
 * algorithm: Tree, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 2 ms, faster than 57.61% of Java online submissions
 * Memory Usage: 41.7 MB, less than 11.11% of Java online submissions
 */
public class HouseRobberIII337 {

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

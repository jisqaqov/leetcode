package leetcode.p0013;

/**
 * @author Jandos Iskakov
 * problem: 1026. Maximum Difference Between Node and Ancestor
 * algorithm: Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 40.1 MB, less than 5.55% of Java online submissions
 */
public class MaximumDifferenceBetweenNodeAndAncestor1026 {

  public int maxAncestorDiff(TreeNode root) {
    return helper(root, root.val, root.val);
  }

  private int helper(TreeNode root, int min, int max) {
    if (root == null) {
      return 0;
    }

    max = Math.max(root.val, max);
    min = Math.min(root.val, min);

    int l = helper(root.left, min, max);
    int r = helper(root.right, min, max);

    return Math.max(max - min, Math.max(l, r));
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
package leetcode;

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

  private int diff = Integer.MIN_VALUE;

  public int maxAncestorDiff(TreeNode root) {
    minMaxValue(root);
    return diff;
  }

  private int[] minMaxValue(TreeNode root) {
    if (root == null) {
      return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
    }

    if (root.left == null && root.right == null) {
      return new int[]{root.val, root.val};
    }

    int[] left = minMaxValue(root.left);
    int[] right = minMaxValue(root.right);

    int min = Math.abs(root.val - Math.min(left[0], right[0]));
    int max = Math.abs(root.val - Math.max(left[1], right[1]));

    diff = Math.max(diff, Math.max(min, max));

    int[] output = new int[2];
    output[0] = Math.min(Math.min(left[0], right[0]), root.val);
    output[1] = Math.max(Math.max(left[1], right[1]), root.val);

    return output;
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
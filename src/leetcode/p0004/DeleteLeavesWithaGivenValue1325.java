package leetcode.p0004;

/**
 * @author Jandos Iskakov
 * problem: 1325. Delete Leaves With a Given Value
 * algorithm: Recursion, Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 39.6 MB, less than 100.00%
 */
public class DeleteLeavesWithaGivenValue1325 {

  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root == null) {
      return null;
    }

    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);

    if (root.left == null && root.right == null && root.val == target) {
      return null;
    }

    return root;
  }

  /**
   * Definition for a binary tree node
   */
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }


}
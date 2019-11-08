package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 270. Closest Binary Search Tree Value
 * algorithm: Tree
 * time complexity: O(log(N))
 * space complexity: O(log(N))
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Closest Binary Search Tree Value.
 * Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Closest Binary Search Tree Value.
 */
public class ClosestBinarySearchTreeValue270 {

  public int closestValue(TreeNode root, double target) {
    int val = -1;
    if (root.val < target && root.right != null) {
      val = closestValue(root.right, target);
    } else if (root.val > target && root.left != null) {
      val = closestValue(root.left, target);
    }

    if (val != -1 && Math.abs(root.val - target) > Math.abs(val - target)) {
      return val;
    }

    return root.val;
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

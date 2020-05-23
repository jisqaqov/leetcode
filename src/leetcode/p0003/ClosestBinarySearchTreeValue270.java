package leetcode.p0003;

/**
 * @author Jandos Iskakov
 * problem: 270. Closest Binary Search Tree Value
 * algorithm: Tree
 * time complexity: O(H)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Closest Binary Search Tree Value.
 * Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Closest Binary Search Tree Value.
 */
public class ClosestBinarySearchTreeValue270 {

  public int closestValue(TreeNode root, double target) {
    int val = -1;

    if (root.val < target && root.right != null) {
      val = closestValue(root.right, target);
    } else if (root.val > target && root.left != null) {
      val = closestValue(root.left, target);
    }

    int k = root.val;
    if (val != -1 && Math.abs(root.val - target) > Math.abs(val - target)) {
      k = val;
    }

    return k;
  }

  private static class V2 {
    public int closestValue(TreeNode root, double target) {
      int val = root.val;

      TreeNode node = root;
      while (node != null) {
        if (Math.abs(node.val - target) < Math.abs(val - target)) {
          val = node.val;
        }

        if (root.val > target) {
          node = node.left;
        } else {
          node = node.right;
        }
      }

      return val;
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

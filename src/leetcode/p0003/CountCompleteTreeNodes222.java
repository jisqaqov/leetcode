package leetcode.p0003;

/**
 * @author Jandos Iskakov
 * problem: 222. Count Complete Tree Nodes
 * algorithm: Tree
 * time complexity: O(n)
 * space complexity: O(log(n))
 */
public class CountCompleteTreeNodes222 {

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int l = countNodes(root.left);
    int r = countNodes(root.right);

    return l + r + 1;
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

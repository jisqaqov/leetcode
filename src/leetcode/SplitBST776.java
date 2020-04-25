package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 776. Split BST
 * algorithm: Tree, Recursion
 * time complexity: O(N)
 * space complexity: O(H)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 37.8 MB, less than 16.67% of Java online submissions
 */
public class SplitBST776 {

  public TreeNode[] splitBST(TreeNode root, int v) {
    if (root == null) {
      return new TreeNode[2];
    }

    TreeNode[] subtrees = new TreeNode[2];

    if (root.val <= v) {
      TreeNode[] temp = splitBST(root.right, v);
      root.right = temp[0];

      subtrees[0] = root;
      subtrees[1] = temp[1];
    } else if (root.val > v) {
      TreeNode[] temp = splitBST(root.left, v);
      root.left = temp[1];

      subtrees[0] = temp[0];
      subtrees[1] = root;
    }

    return subtrees;
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
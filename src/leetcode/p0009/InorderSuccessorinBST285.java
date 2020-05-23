package leetcode.p0009;

/**
 * @author Jandos Iskakov
 * problem: 285. Inorder Successor in BST
 * algorithm: Tree
 * time complexity: O(H)
 * space complexity: O(1)
 * Runtime: 4 ms, faster than 12.03% of Java online submissions
 * Memory Usage: 46.6 MB, less than 5.26% of Java online submissions
 */
public class InorderSuccessorinBST285 {

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode output = null;

    if (p.right != null) {
      output = p.right;
      TreeNode node = p.right;

      while (node != null) {
        output = node;
        node = node.left;
      }
    } else {
      TreeNode node = root;

      while (node != null) {
        if (node.val > p.val) {
          output = node;
          node = node.left;
        } else {
          node = node.right;
        }
      }
    }

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
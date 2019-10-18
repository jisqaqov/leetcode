package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 110. Balanced Binary Tree
 * algorithm: DFS, Binary Tree
 * time complexity: O(n)
 * space complexity: O(log(n))
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Balanced Binary Tree.
 * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Balanced Binary Tree.
 */
public class BalancedBinaryTree110 {

  public static void main(String[] args) {
    BalancedBinaryTree110 problem = new BalancedBinaryTree110();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(3);
    TreeNode node9 = new TreeNode(9);
    TreeNode node20 = new TreeNode(20);
    TreeNode node15 = new TreeNode(15);
    TreeNode node7 = new TreeNode(7);

    root.left = node9;
    root.right = node20;
    node20.left = node15;
    node20.right = node7;

    System.out.println(isBalanced(root));
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    int d1 = maxDepth(root.left);
    int d2 = maxDepth(root.right);

    if (Math.abs(d1 - d2) > 1) {
      return false;
    }

    return isBalanced(root.left) && isBalanced(root.right);
  }

  private int maxDepth(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int d1 = maxDepth(node.left) + 1;
    int d2 = maxDepth(node.right) + 1;

    return Math.max(d1, d2);
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

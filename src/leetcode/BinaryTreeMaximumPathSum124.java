package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 124. Binary Tree Maximum Path Sum
 * algorithm: DP, Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Maximum Path Sum.
 * Memory Usage: 40.6 MB, less than 91.67% of Java online submissions for Binary Tree Maximum Path Sum.
 */
public class BinaryTreeMaximumPathSum124 {

  private int maxGlobal = Integer.MIN_VALUE;

  public static void main(String[] args) {
    BinaryTreeMaximumPathSum124 problem = new BinaryTreeMaximumPathSum124();
    problem.test();
  }

  private void test() {
    TreeNode tc1root = new TreeNode(1);
    TreeNode tc1left = new TreeNode(-2);
    TreeNode tc1right = new TreeNode(3);

    tc1root.left = tc1left;
    tc1root.right = tc1right;

    System.out.println(maxPathSum(tc1root));
  }

  public int maxPathSum(TreeNode root) {
    maxGlobal = Integer.MIN_VALUE;

    helper(root);

    return maxGlobal;
  }

  public int helper(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int maxLeft = helper(root.left);
    int maxRight = helper(root.right);

    int maxLocal = Math.max(root.val, Math.max(root.val + maxLeft, root.val + maxRight));

    maxGlobal = Math.max(Math.max(maxGlobal, maxLocal), root.val + maxLeft + maxRight);

    return maxLocal;
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

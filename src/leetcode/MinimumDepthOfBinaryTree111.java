package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 111. Minimum Depth of Binary Tree
 * algorithm: Tree, Recursion
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 38.8 MB, less than 98.44% of Java online submissions
 */
public class MinimumDepthOfBinaryTree111 {

  public static void main(String[] args) {
    MinimumDepthOfBinaryTree111 problem = new MinimumDepthOfBinaryTree111();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);

    System.out.println(minDepth(root));
  }

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int hl = minDepth(root.left);
    int hr = minDepth(root.right);

    if (hl == 0 || hr == 0) {
      return Math.max(hl, hr) + 1;
    }

    return Math.min(hl, hr) + 1;
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

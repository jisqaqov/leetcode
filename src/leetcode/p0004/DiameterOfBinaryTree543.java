package leetcode.p0004;

/**
 * @author Jandos Iskakov
 * problem: 543. Diameter of Binary Tree
 * algorithm: Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
 * Memory Usage: 38.7 MB, less than 20.78% of Java online submissions for Diameter of Binary Tree.
 */
public class DiameterOfBinaryTree543 {

  public static void main(String[] args) {
    DiameterOfBinaryTree543 problem = new DiameterOfBinaryTree543();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);

    root.left = node2;
    root.right = node3;
    node2.left = node4;
    node2.right = node5;

    System.out.println(diameterOfBinaryTree(root));
  }

  private int d = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    this.d = 0;
    height(root);
    return d;
  }

  private int height(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int hl = height(root.left);
    int hr = height(root.right);

    int h = Math.max(hl, hr) + 1;

    d = Math.max(hl + hr, d);

    return h;
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

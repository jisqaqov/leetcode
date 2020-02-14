package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 1038. Binary Search Tree to Greater Sum Tree
 * algorithm: Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 37.2 MB, less than 100.00% of Java online submissions
 */
public class BinarySearchTreeToGreaterSumTree1038 {

  public static void main(String[] args) {
    BinarySearchTreeToGreaterSumTree1038 problem =
      new BinarySearchTreeToGreaterSumTree1038();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(4);
    TreeNode node6 = new TreeNode(6);
    TreeNode node5 = new TreeNode(5);
    TreeNode node7 = new TreeNode(7);
    TreeNode node8 = new TreeNode(8);
    TreeNode node1 = new TreeNode(1);
    TreeNode node0 = new TreeNode(0);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);

    root.left = node1;
    root.right = node6;
    node6.left = node5;
    node6.right = node7;
    node7.right = node8;
    node1.left = node0;
    node1.right = node2;
    node2.right = node3;

    System.out.println(bstToGst(root));
  }

  public TreeNode bstToGst(TreeNode root) {
    this.last = 0;
    return helper(root);
  }

  int last = 0;

  private TreeNode helper(TreeNode root) {
    if (root == null) {
      return null;
    }

    helper(root.right);

    root.val += last;
    last = root.val;

    helper(root.left);

    return root;
  }

  /**
   * Definition for a binary tree node.
   */
  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      return "TreeNode{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
    }
  }


}
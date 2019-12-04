package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 114. Flatten Binary Tree to Linked List
 * algorithm: Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
 * Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
 */
public class FlattenBinaryTreeToLinkedList114 {

  public static void main(String[] args) {
    FlattenBinaryTreeToLinkedList114 problem = new FlattenBinaryTreeToLinkedList114();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);

    root.left = node2;
    root.right = node5;
    node2.left = node3;
    node2.right = node4;
    node5.right = node6;

    flatten(root);
    System.out.println(root);
  }

  public void flatten(TreeNode root) {
    preorder(root);
  }

  public TreeNode preorder(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode left = preorder(root.left);
    TreeNode right = preorder(root.right);

    if (left != null) {
      left.right = root.right;
    }

    if (root.left != null) {
      root.right = root.left;
    }

    root.left = null;

    return right != null ? right : left != null ? left : root;
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

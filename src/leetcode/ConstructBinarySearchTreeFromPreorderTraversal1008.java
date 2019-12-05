package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 1008. Construct Binary Search Tree from Preorder Traversal
 * algorithm: Tree
 * time complexity: O(N)
 * space complexity: O(H)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
 * Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
 */
public class ConstructBinarySearchTreeFromPreorderTraversal1008 {

  private int index = 0;

  public static void main(String[] args) {
    ConstructBinarySearchTreeFromPreorderTraversal1008 problem = new ConstructBinarySearchTreeFromPreorderTraversal1008();
    problem.test();
  }

  private void test() {
    int[] tc1a = {8, 5, 1, 7, 10, 12};

    System.out.println(bstFromPreorder(tc1a));
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    this.index = 0;
    return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private TreeNode bstFromPreorder(int[] preorder, int min, int max) {
    if (index >= preorder.length || preorder[index] < min || preorder[index] > max) {
      return null;
    }

    TreeNode node = new TreeNode(preorder[index]);
    index++;

    node.left = bstFromPreorder(preorder, min, node.val);
    node.right = bstFromPreorder(preorder, node.val, max);

    return node;
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

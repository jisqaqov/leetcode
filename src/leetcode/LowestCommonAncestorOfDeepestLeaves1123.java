package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 1123. Lowest Common Ancestor of Deepest Leaves
 * algorithm: Tree, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions
 */
public class LowestCommonAncestorOfDeepestLeaves1123 {

  public static void main(String[] args) {
    LowestCommonAncestorOfDeepestLeaves1123 problem =
      new LowestCommonAncestorOfDeepestLeaves1123();

    problem.test1();
    problem.test2();
    problem.test3();
    problem.test4();
  }

  private void test1() {
    TreeNode root = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    TreeNode node1 = new TreeNode(1);
    TreeNode node6 = new TreeNode(6);
    TreeNode node2 = new TreeNode(2);
    TreeNode node7 = new TreeNode(7);
    TreeNode node4 = new TreeNode(4);
    TreeNode node0 = new TreeNode(0);
    TreeNode node8 = new TreeNode(8);

    root.left = node5;
    root.right = node1;
    node5.left = node6;
    node5.right = node2;
    node2.left = node7;
    node2.right = node4;
    node1.left = node0;
    node1.right = node8;

    System.out.println(lcaDeepestLeaves(root));//2
  }

  private void test2() {
    TreeNode root = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node3 = new TreeNode(3);
    TreeNode node2 = new TreeNode(2);

    root.left = node1;
    root.right = node3;
    node1.right = node2;

    System.out.println(lcaDeepestLeaves(root));//2
  }

  private void test3() {
    TreeNode root = new TreeNode(0);
    TreeNode node3 = new TreeNode(3);
    TreeNode node1 = new TreeNode(1);
    TreeNode node4 = new TreeNode(4);
    TreeNode node2 = new TreeNode(2);
    TreeNode node6 = new TreeNode(6);
    TreeNode node5 = new TreeNode(5);

    root.left = node3;
    root.right = node1;
    node3.left = node4;
    node1.left = node2;
    node4.right = node6;
    node2.right = node5;

    System.out.println(lcaDeepestLeaves(root));//0
  }

  private void test4() {
    System.out.println(lcaDeepestLeaves(null));//null
  }

  public TreeNode lcaDeepestLeaves(TreeNode root) {
    return (TreeNode) helper(root, 0)[0];
  }

  private Object[] helper(TreeNode root, int depth) {
    if (root == null) {
      return new Object[] {root, depth};
    }

    Object[] left = helper(root.left, depth + 1);
    Object[] right = helper(root.right, depth + 1);

    int lh = (int) left[1];
    int lr = (int) right[1];

    if (lh == lr) {
      return new Object[] {root, lh};
    } else if (lh > lr) {
      return left;
    }

    return right;
  }

  private static class V2 {
    private int maxDepth = -1;
    private TreeNode output = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
      maxDepth = -1;
      output = null;

      helper(root, 0);
      return output;
    }

    private int helper(TreeNode root, int depth) {
      if (root == null) {
        return depth;
      }

      int lh = helper(root.left, depth + 1);
      int lr = helper(root.right, depth + 1);

      int localDepth = Math.max(lh, lr);

      maxDepth = Math.max(maxDepth, localDepth);

      if (lh == maxDepth && lr == maxDepth) {
        output = root;
      }

      return localDepth;
    }

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

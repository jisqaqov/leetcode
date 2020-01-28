package prep;

public class Prep {


  private int maxLen = 0;

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test1();
  }

  private void test1() {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);

    root.right = node3;
    node3.left = node2;
    node3.right = node4;
    node4.left = node5;
    node4.right = node6;

    System.out.println(longestConsecutive(root));
  }

  public int longestConsecutive(TreeNode root) {
    return helper(root, null, 0);
  }

  public int helper(TreeNode root, TreeNode parent, int len) {
    if (root == null) {
      return 0;
    }

    len = parent != null && parent.val + 1 == root.val ? len + 1 : 1;

    return Math.max(len, Math.max(helper(root.left, root, len),
      helper(root.right, root, len)));
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
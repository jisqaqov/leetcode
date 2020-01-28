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
    this.maxLen = -1;

    helper(root);

    return maxLen;
  }

  public int helper(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftLen = helper(root.left);
    int rightLen = helper(root.right);

    if (root.left != null && root.val - root.left.val == -1) {
      leftLen++;
    } else {
      leftLen = 1;
    }

    if (root.right != null && root.val - root.right.val == -1) {
      rightLen++;
    } else {
      rightLen = 1;
    }

    int tempMax = Math.max(leftLen, rightLen);

    maxLen = Math.max(tempMax, maxLen);

    return tempMax;
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
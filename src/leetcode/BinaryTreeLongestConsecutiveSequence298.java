package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 298. Binary Tree Longest Consecutive Sequence
 * algorithm: Graph, Topological Sort
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 98.17% of Java online submissions
 * Memory Usage: 43.6 MB, less than 5.88% of Java online submissions
 */
public class BinaryTreeLongestConsecutiveSequence298 {

  public static void main(String[] args) {
    BinaryTreeLongestConsecutiveSequence298 problem =
      new BinaryTreeLongestConsecutiveSequence298();
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

  private int maxLen = 0;

  public int longestConsecutive(TreeNode root) {
    this.maxLen = 0;

    helper(root);

    return maxLen;
  }

  private int helper(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int l = helper(root.left);
    int r = helper(root.right);

    if (root.left != null && root.val + 1 == root.left.val) {
      l++;
    } else {
      l = 1;
    }

    if (root.right != null && root.val + 1 == root.right.val) {
      r++;
    } else {
      r = 1;
    }

    int tempMax = Math.max(l, r);

    maxLen = Math.max(tempMax, maxLen);

    return tempMax;
  }

  private static class V2 {
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
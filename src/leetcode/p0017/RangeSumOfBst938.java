package leetcode.p0017;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 938. Range Sum of BST
 * algorithm: BST
 * time complexity: O(N)
 * space complexity: O(H)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Range Sum of BST.
 * Memory Usage: 45.6 MB, less than 97.67% of Java online submissions for Range Sum of BST.
 */
public class RangeSumOfBst938 {

  public static void main(String[] args) {
    RangeSumOfBst938 problem = new RangeSumOfBst938();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(10);
    TreeNode node5 = new TreeNode(5);
    TreeNode node3 = new TreeNode(3);
    TreeNode node7 = new TreeNode(7);
    TreeNode node15 = new TreeNode(15);
    TreeNode node18 = new TreeNode(18);

    root.left = node5;
    root.right = node15;
    node5.left = node3;
    node5.right = node7;
    node15.right = node18;

    System.out.println(rangeSumBST(root, 7, 15));
    System.out.println(new V2().rangeSumBST(root, 7, 15));
  }

  public int rangeSumBST(TreeNode root, int l, int r) {
    if (root == null) {
      return 0;
    }

    int s = 0;

    if (root.val > l) {
      s += rangeSumBST(root.left, l, r);
    }

    if (root.val < r) {
      s += rangeSumBST(root.right, l, r);
    }

    if (root.val >= l && root.val <= r) {
      s += root.val;
    }

    return s;
  }

  private static class V2 {
    public int rangeSumBST(TreeNode root, int l, int r) {
      Queue<TreeNode> queue = new ArrayDeque<>();
      if (root != null) {
        queue.add(root);
      }

      int s = 0;
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();

        if (node.val >= l && node.val <= r) {
          s += node.val;
        }

        if (node.val > l && node.left != null) {
          queue.add(node.left);
        }

        if (node.val < r && node.right != null) {
          queue.add(node.right);
        }
      }

      return s;
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



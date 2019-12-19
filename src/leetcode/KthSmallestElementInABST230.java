package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 230. Kth Smallest Element in a BST
 * algorithm: Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 37.2 MB, less than 100.00% of Java online submissions
 */
public class KthSmallestElementInABST230 {

  public static void main(String[] args) {
    KthSmallestElementInABST230 problem = new KthSmallestElementInABST230();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(3);
    TreeNode node1 = new TreeNode(1);
    TreeNode node4 = new TreeNode(4);
    TreeNode node2 = new TreeNode(2);

    root.left = node1;
    root.right = node4;
    node1.right = node2;

    System.out.println(kthSmallest(root, 1));
    System.out.println(kthSmallest(root, 2));
    System.out.println(kthSmallest(root, 3));
    System.out.println(kthSmallest(root, 4));
  }

  public int kthSmallest(TreeNode root, int k) {
    TreeNode output = null;

    TreeNode node = root;
    Deque<TreeNode> stack = new ArrayDeque<>();

    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }

      node = stack.pop();

      if (k == 1) {
        output = node;
        break;
      }

      k--;

      node = node.right;
    }

    return output.val;
  }

  private static class V2 {

    private int idx = 1;
    private TreeNode output;

    public int kthSmallest(TreeNode root, int k) {
      idx = k;
      output = null;

      inorder(root);

      return output.val;
    }

    private void inorder(TreeNode root) {
      if (root == null) {
        return;
      }

      if (output == null) {
        inorder(root.left);
      }

      if (idx == 1) {
        output = root;
      }

      idx--;

      if (output == null) {
        inorder(root.right);
      }
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

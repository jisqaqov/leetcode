package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 98. Validate Binary Search Tree
 * algorithm: Tree, DFS
 * time complexity: O(n)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 45.97% of Java online submissions
 * Memory Usage: 39.2 MB, less than 80.93% of Java online submissions
 */
public class ValidateBinarySearchTree98 {

  public static void main(String[] args) {
    ValidateBinarySearchTree98 solution = new ValidateBinarySearchTree98();
    solution.test();
  }

  public void test() {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);

    System.out.println(isValidBST(root));
    System.out.println(new V2().isValidBST(root));
  }

  public boolean isValidBST(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();

    TreeNode node = root;
    TreeNode prev = null;

    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }

      node = stack.pop();

      if (prev != null && node.val < prev.val) {
        return false;
      }

      prev = node;

      node = node.right;
    }

    return true;
  }

  private static class V2 {

    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
      prev = null;

      return helper(root);
    }

    public boolean helper(TreeNode root) {
      if (root == null) {
        return true;
      }

      if (!helper(root.left)) {
        return false;
      }

      if (prev != null && root.val <= prev.val) {
        return false;
      }

      prev = root;

      if (!helper(root.right)) {
        return false;
      }

      return true;
    }

  }

  private class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

}
package leetcode.p0002;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 94. Binary Tree Inorder Traversal
 * algorithm: Tree, Stack, Hash Table
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
 * Memory Usage: 34.9 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
 */
public class BinaryTreeInorderTraversal94 {

  public static void main(String[] args) {
    BinaryTreeInorderTraversal94 problem = new BinaryTreeInorderTraversal94();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(4);
    TreeNode node2 = new TreeNode(2);
    TreeNode node5 = new TreeNode(5);
    TreeNode node1 = new TreeNode(1);
    TreeNode node3 = new TreeNode(3);

    root.left = node2;
    root.right = node5;
    node2.left = node1;
    node2.right = node3;

    System.out.println(new RecursiveVersion().inorderTraversal(root));
    System.out.println(new IterativeVersion().inorderTraversal(root));
  }

  private static class RecursiveVersion {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> vals = new ArrayList<>();
      inorderTraversal(root, vals);
      return vals;
    }

    private void inorderTraversal(TreeNode root, List<Integer> vals) {
      if (root == null) {
        return;
      }

      inorderTraversal(root.left, vals);
      vals.add(root.val);
      inorderTraversal(root.right, vals);
    }
  }

  private static class IterativeVersion {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> values = new ArrayList<>();

      Deque<TreeNode> deque = new ArrayDeque<>();
      TreeNode node = root;

      while (node != null || !deque.isEmpty()) {
        while (node != null) {
          deque.push(node);
          node = node.left;
        }

        node = deque.pop();
        values.add(node.val);
        node = node.right;
      }

      return values;
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

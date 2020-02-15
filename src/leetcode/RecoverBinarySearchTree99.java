package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 99. Recover Binary Search Tree
 * algorithm: Tree, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 3 ms, faster than 40.42% of Java online submissions
 * Memory Usage: 41.1 MB, less than 73.08% of Java online submissions
 */
public class RecoverBinarySearchTree99 {

  public static void main(String[] args) {
    RecoverBinarySearchTree99 problem = new RecoverBinarySearchTree99();
    problem.test();
    problem.test2();
  }

  private void test() {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);

    root.left = node3;
    node3.right = node2;

    recoverTree(root);

    System.out.println(root);
  }

  private void test2() {
    TreeNode root = new TreeNode(3);
    TreeNode node1 = new TreeNode(1);
    TreeNode node4 = new TreeNode(4);
    TreeNode node2 = new TreeNode(2);

    root.left = node1;
    root.right = node4;
    node4.left = node2;

    recoverTree(root);

    System.out.println(root);
  }

  public void recoverTree(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;
    TreeNode pre = null;
    TreeNode a = null, b = null;

    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }

      node = stack.pop();
      if (pre != null && pre.val > node.val) {
        b = node;

        if (a == null) {
          a = pre;
        } else {
          break;
        }
      }

      pre = node;

      node = node.right;
    }

    swap(a, b);
  }

  private void swap(TreeNode a, TreeNode b) {
    int temp = a.val;
    a.val = b.val;
    b.val = temp;
  }

  private class V2 {
    private TreeNode pre = null;
    private TreeNode a, b;

    public void recoverTree(TreeNode root) {
      pre = a = b = null;

      inorder(root);

      swap(a, b);
    }

    private void inorder(TreeNode root) {
      if (root == null) {
        return;
      }

      inorder(root.left);

      if (pre != null && pre.val > root.val) {
        b = root;
        if (a == null) {
          a = pre;
        } else {
          return;
        }
      }

      pre = root;

      inorder(root.right);
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
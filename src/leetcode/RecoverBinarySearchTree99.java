package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 99. Recover Binary Search Tree
 * algorithm: Tree, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 2 ms, faster than 96.06% of Java online submissions
 * Memory Usage: 41.5 MB, less than 69.23% of Java online submissions
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
    TreeNode[] swap = new TreeNode[2];

    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }

      node = stack.pop();
      if (swap[0] != null && swap[0].val > node.val) {
        swap[1] = node;
      } else if (pre != null && pre.val > node.val) {
        swap[0] = pre;
        swap[1] = node;
      }

      pre = node;

      node = node.right;
    }

    int temp = swap[0].val;
    swap[0].val = swap[1].val;
    swap[1].val = temp;
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
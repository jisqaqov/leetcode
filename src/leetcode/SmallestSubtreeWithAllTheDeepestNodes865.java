package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 865. Smallest Subtree with all the Deepest Nodes
 * algorithm: Tree, BFS, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class SmallestSubtreeWithAllTheDeepestNodes865 {

  public static void main(String[] args) {
    SmallestSubtreeWithAllTheDeepestNodes865 problem =
      new SmallestSubtreeWithAllTheDeepestNodes865();
    problem.test();
  }

  private void test() {
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

    System.out.println(subtreeWithAllDeepest(root));
  }

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode[] lastNode = null;

    Queue<TreeNode[]> queue = new LinkedList<>();
    queue.add(new TreeNode[] {root, null});

    while (!queue.isEmpty()) {
      lastNode = queue.poll();
      TreeNode node = lastNode[0];

      if (node.left != null) {
        queue.add(new TreeNode[] {node.left, node});
      }

      if (node.right != null) {
        queue.add(new TreeNode[] {node.right, node});
      }
    }

    if (lastNode[1] == null) {
      return lastNode[0];
    }

    return lastNode[1];
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
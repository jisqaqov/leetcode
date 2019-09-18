package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 863. All Nodes Distance K in Binary Tree time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for All Nodes Distance K in Binary Tree.
 * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for All Nodes Distance K in Binary Tree.
 */
public class AllNodesDistanceKInBinaryTree863 {

  public static void main(String[] args) {
    AllNodesDistanceKInBinaryTree863 solution = new AllNodesDistanceKInBinaryTree863();
    solution.test();
  }

  public void test() {
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

    System.out.println(distanceK(root, node5, 3));
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> values = new ArrayList<>();

    traverse(root, target, k, values);
    find(target, k, 0, values);

    return values;
  }

  private int traverse(TreeNode node, TreeNode target, int k, List<Integer> values) {
    if (node == null) {
      return -1;
    }

    if (node == target) {
      return 0;
    }

    int disLeft = traverse(node.left, target, k, values);
    if (disLeft >= 0) {
      disLeft++;
    }

    if (disLeft >= 0 && disLeft <= k) {
      if (disLeft == k) {
        values.add(node.val);
      } else {
        find(node.right, k, disLeft + 1, values);
      }

      return disLeft;
    }

    int disRight = traverse(node.right, target, k, values);
    if (disRight >= 0) {
      disRight++;
    }

    if (disRight >= 0 && disRight <= k) {
      if (disRight == k) {
        values.add(node.val);
      } else {
        find(node.left, k, disRight + 1, values);
      }

      return disRight;
    }

    return -2;
  }

  private void find(TreeNode node, int k, int path, List<Integer> values) {
    if (node == null) {
      return;
    }

    if (path == k) {
      values.add(node.val);
      return;
    }

    if (node.left != null) {
      find(node.left, k, path + 1, values);
    }

    if (node.right != null) {
      find(node.right, k, path + 1, values);
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

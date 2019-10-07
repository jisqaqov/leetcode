package leetcode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @author Jandos Iskakov
 * problem: 545. Boundary of Binary Tree
 * algorithm: DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Boundary of Binary Tree.
 * Memory Usage: 39.4 MB, less than 26.32% of Java online submissions for Boundary of Binary Tree.
 */
public class BoundaryOfBinaryTree545 {

  public static void main(String[] args) {
    BoundaryOfBinaryTree545 solution = new BoundaryOfBinaryTree545();
    solution.test();
  }

  public void test() {
    TreeNode tc1root = new TreeNode(1);
    TreeNode tc1node2 = new TreeNode(2);
    TreeNode tc1node4 = new TreeNode(4);
    TreeNode tc1node5 = new TreeNode(5);
    TreeNode tc1node7 = new TreeNode(7);
    TreeNode tc1node8 = new TreeNode(8);
    TreeNode tc1node3 = new TreeNode(3);
    TreeNode tc1node6 = new TreeNode(6);
    TreeNode tc1node9 = new TreeNode(9);
    TreeNode tc1node10 = new TreeNode(10);

    tc1root.left = tc1node2;
    tc1root.right = tc1node3;
    tc1node2.left = tc1node4;
    tc1node2.right = tc1node5;
    tc1node5.left = tc1node7;
    tc1node5.right = tc1node8;
    tc1node3.left = tc1node6;
    tc1node6.left = tc1node9;
    tc1node6.right = tc1node10;

    System.out.println(boundaryOfBinaryTree(tc1root));
  }

  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> list = new ArrayList<>();
    list.add(root.val);

    if (root.left != null) {
      leftBoundary(root.left, list);
    }

    if (root.left != null || root.right != null) {
      leaves(root, list);
    }

    if (root.right != null) {
      rightBoundary(root.right, list);
    }

    return list;
  }

  private void leftBoundary(TreeNode node, List<Integer> list) {
    if (node == null) {
      return;
    }

    if (node.left != null || node.right != null) {
      list.add(node.val);
    }

    if (node.left != null) {
      leftBoundary(node.left, list);
    } else if (node.right != null) {
      leftBoundary(node.right, list);
    }
  }

  private void rightBoundary(TreeNode node, List<Integer> list) {
    if (node == null) {
      return;
    }

    if (node.right != null) {
      rightBoundary(node.right, list);
    } else if (node.left != null) {
      rightBoundary(node.left, list);
    }

    if (node.left != null || node.right != null) {
      list.add(node.val);
    }
  }

  private void leaves(TreeNode node, List<Integer> list) {
    if (node == null) {
      return;
    }

    if (node.left == null && node.right == null) {
      list.add(node.val);
    }

    if (node.left != null) {
      leaves(node.left, list);
    }

    if (node.right != null) {
      leaves(node.right, list);
    }
  }

  /**
   * Definition for a binary tree node.
   */
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

}

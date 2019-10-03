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

    System.out.println(new NaiveApproach().boundaryOfBinaryTree(tc1root));
  }
  
  private static class NaiveApproach {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
      if (root == null) {
        return new ArrayList<>();
      }

      Set<TreeNode> set = new LinkedHashSet<>();

      set.add(root);

      if (root.left != null) {
        leftBoundary(root.left, set);
      }

      leafs(root, set);
      rightBoundary(root.right, set);

      return set
        .stream()
        .map(treeNode -> treeNode.val)
        .collect(Collectors.toList());
    }

    private void leftBoundary(TreeNode node, Set<TreeNode> set) {
      if (node == null) {
        return;
      }

      set.add(node);

      if (node.left != null) {
        leftBoundary(node.left, set);
      } else if (node.right != null) {
        leftBoundary(node.right, set);
      }
    }

    private void rightBoundary(TreeNode node, Set<TreeNode> set) {
      if (node == null) {
        return;
      }

      if (node.right != null) {
        rightBoundary(node.right, set);
      } else if (node.left != null) {
        rightBoundary(node.left, set);
      }

      set.add(node);
    }

    private void leafs(TreeNode node, Set<TreeNode> set) {
      if (node == null) {
        return;
      }

      if (node.left == null && node.right == null) {
        set.add(node);
      }

      if (node.left != null) {
        leafs(node.left, set);
      }

      if (node.right != null) {
        leafs(node.right, set);
      }
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

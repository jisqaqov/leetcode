package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 863. All Nodes Distance K in Binary Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions
 */
public class AllNodesDistanceKInBinaryTree863 {

  public static void main(String[] args) {
    AllNodesDistanceKInBinaryTree863 solution = new AllNodesDistanceKInBinaryTree863();
    solution.test();
  }

  private void test() {
    TreeNode root = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node2 = new TreeNode(2);
    TreeNode node4 = new TreeNode(4);
    TreeNode node7 = new TreeNode(7);
    TreeNode node1 = new TreeNode(1);
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

    System.out.println(distanceK(root, node5, 2));
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> list = new ArrayList<>();

    search(root, target, k, list);

    return list;
  }

  private int search(TreeNode root, TreeNode target, int k, List<Integer> list) {
    if (root == null) {
      return -1;
    }

    int d = -1;

    if (root == target) {
      d = 0;
      collect(root, 0, list, k);
    } else {
      int dl = search(root.left, target, k, list);
      int dr = search(root.right, target, k, list);

      if (dl >= 0 || dr >= 0) {
        d = Math.max(dl, dr) + 1;
      }

      if (d == k) {
        list.add(root.val);
      } else if (dl >= 0) {
        collect(root.right, d + 1, list, k);
      } else if (dr >= 0) {
        collect(root.left, d + 1, list, k);
      }
    }

    return d;
  }

  private void collect(TreeNode root, int d, List<Integer> list, int k) {
    if (root == null || d > k) {
      return;
    }

    if (d == k) {
      list.add(root.val);
      return;
    }

    collect(root.left, d + 1, list, k);
    collect(root.right, d + 1, list, k);
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

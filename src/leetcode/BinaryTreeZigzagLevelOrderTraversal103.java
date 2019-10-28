package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 103. Binary Tree Zigzag Level Order Traversal
 * algorithm: BFS,Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 98.93% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 * Memory Usage: 36.3 MB, less than 99.04% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 */
public class BinaryTreeZigzagLevelOrderTraversal103 {

  public static void main(String[] args) {
    BinaryTreeZigzagLevelOrderTraversal103 problem = new BinaryTreeZigzagLevelOrderTraversal103();
    problem.test();
  }

  public void test() {
    TreeNode root = new TreeNode(3);
    TreeNode node9 = new TreeNode(9);
    TreeNode node20 = new TreeNode(20);
    TreeNode node15 = new TreeNode(15);
    TreeNode node7 = new TreeNode(7);

    root.left = node9;
    root.right = node20;
    node20.left = node15;
    node20.right = node7;

    System.out.println(zigzagLevelOrder(root));
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> solution = new ArrayList<>();

    if (root == null) {
      return solution;
    }

    boolean zigzag = true;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      LinkedList<Integer> vals = new LinkedList<>();

      int len = queue.size();

      for (int i = 0; i < len; i++) {
        TreeNode node = queue.poll();

        if (zigzag) {
          vals.add(node.val);
        } else {
          vals.addFirst(node.val);
        }

        if (node.left != null) {
          queue.add(node.left);
        }

        if (node.right != null) {
          queue.add(node.right);
        }
      }

      zigzag = !zigzag;

      solution.add(vals);
    }

    return solution;
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

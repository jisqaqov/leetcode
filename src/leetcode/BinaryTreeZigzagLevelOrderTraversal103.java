package leetcode;

import java.util.ArrayList;
import java.util.List;
import leetcode.AddTwoNumbers2.ListNode;

/**
 * @author Jandos Iskakov
 * problem: 103. Binary Tree Zigzag Level Order Traversal
 * algorithm: BFS, Tree
 * time complexity: O(N)
 * space complexity: O(N)
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
    if (root == null) {
      return new ArrayList<>();
    }

    byte dir = -1;

    List<List<Integer>> solution = new ArrayList<>();

    List<TreeNode> queue = new ArrayList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      List<Integer> vals = new ArrayList<>();

      if (dir == -1) {
        for (int i = 0; i < queue.size(); i++) {
          vals.add(queue.get(i).val);
        }
      } else {
        for (int i = queue.size() - 1; i >= 0; i--) {
          vals.add(queue.get(i).val);
        }
      }

      dir *= -1;
      solution.add(vals);

      List<TreeNode> newQueue = new ArrayList<>();
      for (TreeNode node : queue) {
        if (node.left != null) {
          newQueue.add(node.left);
        }

        if (node.right != null) {
          newQueue.add(node.right);
        }
      }

      queue= newQueue;
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

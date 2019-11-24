package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 199. Binary Tree Right Side View
 * algorithm: Tree, BFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 98.04% of Java online submissions for Binary Tree Right Side View.
 * Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Binary Tree Right Side View.
 */
public class BinaryTreeRightSideView199 {

  public static void main(String[] args) {
    BinaryTreeRightSideView199 problem = new BinaryTreeRightSideView199();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    TreeNode node4 = new TreeNode(4);

    root.left = node2;
    root.right = node3;
    node2.right = node5;
    node3.right = node4;

    System.out.println(rightSideView(root));
  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      TreeNode node = null;
      for (int i = 0; i < size; i++) {
        node = queue.poll();

        if (node.left != null) {
          queue.add(node.left);
        }

        if (node.right != null) {
          queue.add(node.right);
        }
      }

      list.add(node.val);
    }

    return list;
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

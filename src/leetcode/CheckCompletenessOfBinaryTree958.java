package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: Alien Dictionary 269
 * algorithm: Tree, BFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 91.52% of Java online submissions for Check Completeness of a Binary Tree.
 * Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Check Completeness of a Binary Tree.
 */
public class CheckCompletenessOfBinaryTree958 {

  public static void main(String[] args) {
    CheckCompletenessOfBinaryTree958 problem = new CheckCompletenessOfBinaryTree958();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node7 = new TreeNode(7);

    root.left = node2;
    root.right = node3;
    node2.left = node4;
    node2.right = node5;
    node3.left = node7;

    System.out.println(isCompleteTree(root));
  }

  public boolean isCompleteTree(TreeNode root) {
    if (root == null) {
      return true;
    }

    int height = 1;
    int maxHeight = maxHeight(root);

    boolean emptyNode = false;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      height++;

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();

        if (height < maxHeight) {
          if (node.left == null || node.right == null) {
            return false;
          }

          queue.add(node.left);
          queue.add(node.right);
        } else {
          if (node.left == null && node.right != null) {
            return false;
          }

          if (emptyNode && (node.left != null || node.right != null)) {
            return false;
          }

          if (!emptyNode && (node.left == null || node.right == null)) {
            emptyNode = true;
          }
        }
      }
    }

    return true;
  }

  private int maxHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
  }

  /*
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

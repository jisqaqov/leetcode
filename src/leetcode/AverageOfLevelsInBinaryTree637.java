package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 637. Average of Levels in Binary Tree
 * algorithm: Tree
 * time complexity: O(N)
 * space complexity: O(h)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Average of Levels in Binary Tree.
 * Memory Usage: 39.5 MB, less than 100.00% of Java online submissions for Average of Levels in Binary Tree.
 */
public class AverageOfLevelsInBinaryTree637 {

  public static void main(String[] args) {
    AverageOfLevelsInBinaryTree637 problem = new AverageOfLevelsInBinaryTree637();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(3);
    TreeNode node9 = new TreeNode(9);
    TreeNode node20 = new TreeNode(20);
    TreeNode node15 = new TreeNode(15);
    TreeNode node7 = new TreeNode(7);

    root.left = node9;
    root.right = node20;
    node20.left = node15;
    node20.right = node7;

    System.out.println(averageOfLevels(root));
    System.out.println(new V2().averageOfLevels(root));
  }

  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> output = new ArrayList<>();

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      double sum = 0;

      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        sum += node.val;

        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }

      output.add(sum / size);
    }

    return output;
  }

  private static class V2 {

    public List<Double> averageOfLevels(TreeNode root) {
      List<Double> sums = new ArrayList<>();
      List<Integer> counts = new ArrayList<>();

      preorder(root, sums, counts, 0);

      List<Double> output = new ArrayList<>();
      for (int i = 0; i < sums.size(); i++) {
        output.add(sums.get(i) / counts.get(i));
      }

      return output;
    }

    private void preorder(TreeNode root, List<Double> sums, List<Integer> counts, int depth) {
      if (root == null) {
        return;
      }

      if (sums.size() <= depth) {
        sums.add(0.0);
        counts.add(0);
      }

      sums.set(depth, sums.get(depth) + root.val);
      counts.set(depth, counts.get(depth) + 1);

      preorder(root.left, sums, counts, depth + 1);
      preorder(root.right, sums, counts, depth + 1);
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

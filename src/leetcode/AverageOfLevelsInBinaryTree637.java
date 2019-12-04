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
 * space complexity: O(N)
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
      List<double[]> list = new ArrayList<>();
      preorder(root, list, 0);

      List<Double> output = new ArrayList<>();
      for (int i = 0; i < list.size(); i++) {
        output.add(list.get(i)[0] / list.get(i)[1]);
      }

      return output;
    }

    private void preorder(TreeNode root, List<double[]> list, int depth) {
      if (root == null) {
        return;
      }

      if (list.size() <= depth) {
        list.add(new double[] {0, 0});
      }

      list.get(depth)[0] += root.val;
      list.get(depth)[1] += 1;

      preorder(root.left, list, depth + 1);
      preorder(root.right, list, depth + 1);
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

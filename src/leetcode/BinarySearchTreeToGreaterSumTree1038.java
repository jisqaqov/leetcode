package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 1038. Binary Search Tree to Greater Sum Tree
 * algorithm: Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 37.3 MB, less than 100.00% of Java online submissions
 */
public class BinarySearchTreeToGreaterSumTree1038 {

  public static void main(String[] args) {
    BinarySearchTreeToGreaterSumTree1038 problem =
      new BinarySearchTreeToGreaterSumTree1038();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(4);
    TreeNode node6 = new TreeNode(6);
    TreeNode node5 = new TreeNode(5);
    TreeNode node7 = new TreeNode(7);
    TreeNode node8 = new TreeNode(8);
    TreeNode node1 = new TreeNode(1);
    TreeNode node0 = new TreeNode(0);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);

    root.left = node1;
    root.right = node6;
    node6.left = node5;
    node6.right = node7;
    node7.right = node8;
    node1.left = node0;
    node1.right = node2;
    node2.right = node3;

    System.out.println(bstToGst(root));
  }

  public TreeNode bstToGst(TreeNode root) {
    this.last = new TreeNode(0);
    return helper(root);
  }

  TreeNode last = new TreeNode(0);

  private TreeNode helper(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode clone = new TreeNode(0);

    clone.right = helper(root.right);

    clone.val = root.val + last.val;
    last = clone;

    clone.left = helper(root.left);

    return clone;
  }

  private static class V2 {

    public TreeNode bstToGst(TreeNode root) {
      Map<Integer, Integer> map = new HashMap<>();

      sumTree(root, map);

      return helper(root, map, 0);
    }

    private TreeNode helper(TreeNode root, Map<Integer, Integer> map, int p) {
      if (root == null) {
        return null;
      }

      int sum = root.val + p;

      if (root.right != null) {
        sum += map.get(root.right.val);
      }

      TreeNode clone = new TreeNode(sum);

      TreeNode left = helper(root.left, map, sum);
      TreeNode right = helper(root.right, map, p);

      clone.left = left;
      clone.right = right;

      return clone;
    }

    private int sumTree(TreeNode root, Map<Integer, Integer> map) {
      if (root == null) {
        return 0;
      }

      int ls = sumTree(root.left, map);
      int rs = sumTree(root.right, map);

      int sum = root.val + ls + rs;

      map.put(root.val, sum);

      return sum;
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

    @Override
    public String toString() {
      return "TreeNode{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
    }
  }


}
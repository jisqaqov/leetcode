package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 1110. Delete Nodes And Return Forest
 * algorithm: Tree, DFS
 * time complexity: O(N)
 * space complexity: O(K)
 * Runtime: 1 ms, faster than 98.83% of Java online submissions
 * Memory Usage: 41.6 MB, less than 100.00% of Java online submissions
 */
public class DeleteNodesAndReturnForest1110 {

  public static void main(String[] args) {
    DeleteNodesAndReturnForest1110 problem = new DeleteNodesAndReturnForest1110();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);

    root.left = node2;
    root.right = node3;
    node2.left = node4;
    node4.right = node5;
    node3.left = node6;
    node3.right = node7;

    System.out.println(delNodes(root, new int[]{3, 5}));
  }

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    List<TreeNode> output = new ArrayList<>();

    Set<Integer> deletable = new HashSet<>();
    for (int val : to_delete) {
      deletable.add(val);
    }

    if (!deletable.contains(root.val)) {
      output.add(root);
    }

    postorder(root, null, deletable, output);

    return output;
  }

  private void postorder(TreeNode root, TreeNode parent, Set<Integer> deletable,
    List<TreeNode> output) {
    if (root == null) {
      return;
    }

    postorder(root.left, root, deletable, output);
    postorder(root.right, root, deletable, output);

    if (!deletable.contains(root.val)) {
      return;
    }

    if (root.left != null && !deletable.contains(root.left.val)) {
      output.add(root.left);
    }

    if (root.right != null && !deletable.contains(root.right.val)) {
      output.add(root.right);
    }

    if (parent != null && parent.left != null && parent.left.val == root.val) {
      parent.left = null;
    } else if (parent != null && parent.right != null && parent.right.val == root.val) {
      parent.right = null;
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
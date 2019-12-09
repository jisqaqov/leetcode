package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 105. Construct Binary Tree from Preorder and Inorder Traversal
 * algorithm: Tree, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 2 ms, faster than 97.34% of Java online submissions
 * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {

  private int preorderIdx = 0;

  public static void main(String[] args) {
    ConstructBinaryTreeFromPreorderAndInorderTraversal105 problem =
      new ConstructBinaryTreeFromPreorderAndInorderTraversal105();
    problem.test();
    problem.test2();
  }

  private void test() {
    int[] preorder = {3, 9, 20, 15, 7};
    int[] inorder = {9, 3, 15, 20, 7};

    System.out.println(buildTree(preorder, inorder));
  }

  private void test2() {
    int[] preorder = {1, 2};
    int[] inorder = {1, 2};

    System.out.println(buildTree(preorder, inorder));
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) {
      return null;
    }

    this.preorderIdx = 0;

    Map<Integer, Integer> idxMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      idxMap.put(inorder[i], i);
    }

    return helper(preorder, 0, preorder.length - 1, idxMap);
  }

  private TreeNode helper(int[] preorder, int left, int right, Map<Integer, Integer> idxMap) {
    if (preorderIdx >= preorder.length) {
      return null;
    }

    int value = preorder[preorderIdx];
    int valueIdx = idxMap.get(value);

    if (valueIdx < left || valueIdx > right) {
      return null;
    }

    TreeNode node = new TreeNode(value);
    preorderIdx++;

    node.left = helper(preorder, left, valueIdx - 1, idxMap);
    node.right = helper(preorder, valueIdx + 1, right, idxMap);

    return node;
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

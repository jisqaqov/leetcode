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

  private int index = 0;

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

    this.index = 0;

    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      indexMap.put(inorder[i], i);
    }

    TreeNode root = new TreeNode(preorder[index++]);
    root.left = helper(preorder, root, -1, indexMap, -1);
    root.right = helper(preorder, root, -1, indexMap, 1);

    return root;
  }

  private TreeNode helper(int[] preorder, TreeNode parent, int leftBound,
    Map<Integer, Integer> idxMap, int type) {
    if (index >= preorder.length) {
      return null;
    }

    int value = preorder[index];
    int valIndex = idxMap.get(value);
    if ((type == -1 && valIndex > idxMap.get(parent.val)) ||
        (type == 1 && leftBound != -1 && valIndex > leftBound)) {
      return null;
    }

    index++;

    if (type == -1) {
      leftBound = idxMap.get(parent.val);
    }

    TreeNode node = new TreeNode(value);
    node.left = helper(preorder, node, leftBound, idxMap, -1);
    node.right = helper(preorder, node, leftBound, idxMap, 1);

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

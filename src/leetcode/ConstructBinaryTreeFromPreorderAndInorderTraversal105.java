package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 105. Construct Binary Tree from Preorder and Inorder Traversal
 * algorithm: Tree, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 2 ms, faster than 97.34% of Java online submissions for Construct
 * Binary Tree from Preorder and Inorder Traversal.
 * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for
 * Construct Binary Tree from Preorder and Inorder Traversal.
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
    this.index = 0;

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return buildTree(preorder, null, null, map);
  }

  private TreeNode buildTree(int[] preorder, TreeNode parent, TreeNode root,
    Map<Integer, Integer> map) {
    if (index >= preorder.length ||
      (root != null && map.get(preorder[index]) > map.get(root.val))) {
      return null;
    }

    TreeNode left = root;
    int value = preorder[index];

    TreeNode node = new TreeNode(value);
    if (parent != null) {
      if (map.get(value) < map.get(parent.val)) {
        left = parent;
        parent.left = node;
      } else {
        parent.right = node;
      }
    }

    index++;

    buildTree(preorder, node, left, map);
    buildTree(preorder, node, left, map);

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

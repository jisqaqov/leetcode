package leetcode.p0002;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 257. Binary Tree Paths
 * algorithm: Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Paths.
 * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Binary Tree Paths.
 */
public class BinaryTreePaths257 {

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> list = new ArrayList<>();
    helper(root, "", list);
    return list;
  }

  private void helper(TreeNode root, String s, List<String> list) {
    if (root == null) {
      return;
    }

    if (s.isEmpty()) {
      s = "" + root.val;
    } else {
      s += "->" + root.val;
    }

    if (root.left == null && root.right == null) {
      list.add(s);
    }

    helper(root.left, s, list);
    helper(root.right, s, list);
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

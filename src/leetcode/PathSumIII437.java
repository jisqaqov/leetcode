package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 437. Path Sum III
 * algorithm: Tree
 * time complexity: O(N^2)
 * space complexity: O(N)
 * Runtime: 21 ms, faster than 51.96% of Java online submissions
 * Memory Usage: 39.5 MB, less than 81.82% of Java online submissions
 */
public class PathSumIII437 {

  public int pathSum(TreeNode root, int sum) {
    int[] output = new int[1];

    preorder(root, sum, output);

    return output[0];
  }

  private int helper(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }

    int k = root.val == sum ? 1 : 0;
    k += helper(root.left, sum - root.val) +
      helper(root.right, sum - root.val);

    return k;
  }

  private void preorder(TreeNode root, int sum, int[] output) {
    if (root == null) {
      return;
    }

    output[0] += helper(root, sum);

    preorder(root.left, sum, output);
    preorder(root.right, sum, output);
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

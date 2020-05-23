package leetcode.p0012;

/**
 * @author Jandos Iskakov
 * problem: 333. Largest BST Subtree
 * algorithm: Tree, Recursion
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 39.6 MB, less than 25.00% of Java online submissions
 */
public class LargestBSTSubtree333 {

  public int largestBSTSubtree(TreeNode root) {
    return postorder(root)[1];
  }

  private int[] postorder(TreeNode root) {
    if (root == null) {
      return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
    }

    int[] left = postorder(root.left);
    int[] right = postorder(root.right);

    int[] state = {-1, 0, 0, 0};
    state[1] = Math.max(left[1], right[1]);

    if (left[0] < 0 || right[0] < 0 || left[3] >= root.val || right[2] <= root.val) {
      return state;
    }

    state[0] = 1;
    state[1] = 1 + left[1] + right[1];
    state[2] = left[1] == 0 ? root.val : left[2];
    state[3] = right[1] == 0 ? root.val : right[3];

    return state;
  }

  /**
   * Definition for a binary tree node.
   */
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }


}
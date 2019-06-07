package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 112. Path Sum
 * algorithm: DFS
 * time complexity: O(N)
 * space complexity: O(1)
 */
public class PathSum112 {

    /**
     * Definition for a binary tree node.
     * */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) ||
               hasPathSum(root.right, sum - root.val);
    }

}

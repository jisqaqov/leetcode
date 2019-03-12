package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 965. Univalued Binary Tree
 * time complexity: O(n)
 * algorithm: Trees
 */
public class UnivaluedBinaryTree965 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;

        boolean left = root.left == null || (root.left.val == root.val && isUnivalTree(root.left));
        boolean right = root.right == null || (root.right.val == root.val && isUnivalTree(root.right));

        return left && right;
    }



}

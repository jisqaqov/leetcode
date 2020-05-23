package leetcode.p0013;

/**
 * @author Jandos Iskakov
 * problem: 530. Minimum Absolute Difference in BST
 */
public class MinimumAbsDifferenceBST530 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int getMinimumDifference(TreeNode root) {
        int diff = Integer.MAX_VALUE;

        // find the right most node from left subtree
        Integer left = null;
        TreeNode node = root.left;
        while (node != null) {
            left = left != null? Math.max(left, node.val): node.val;
            node = node.right;
        }

        // find the left most node from right subtree
        Integer right = null;
        node = root.right;
        while (node != null) {
            right = right != null? Math.min(right, node.val): node.val;
            node = node.left;
        }

        if (left != null)
            diff = Math.min(diff, Math.abs(root.val - left));

        if (right != null)
            diff = Math.min(diff, Math.abs(root.val - right));

        // check in left subtree
        if (root.left != null)
            diff = Math.min(diff, getMinimumDifference(root.left));

        // check in right subtree
        if (root.right != null)
            diff = Math.min(diff, getMinimumDifference(root.right));

        return diff;
    }

}

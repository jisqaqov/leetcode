package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 98. Validate Binary Search Tree
 * time complexity: O(n)
 * notes: faster than 100.00% of Java online submissions
 */
public class ValidateBst98 {

    public static void main(String[] args) {
        ValidateBst98 solution = new ValidateBst98();
        solution.test();
    }

    public void test() {
        TreeNode t1root = new TreeNode(2);
        t1root.left = new TreeNode(1);
        t1root.right = new TreeNode(3);

        System.out.println(isValidBST(t1root));
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        // null values stand for infinity
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if ((min != null && node.val <= min) || (max != null && node.val >= max))
            return false;

        boolean isValidRightBst = node.right == null || isValidBST(node.right, node.val, max);
        boolean isValidLeftBst = node.left == null || isValidBST(node.left, min, node.val);

        return isValidLeftBst && isValidRightBst;
    }

}
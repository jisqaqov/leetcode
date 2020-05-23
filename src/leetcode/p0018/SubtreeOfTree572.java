package leetcode.p0018;

/**
 * @author Jandos Iskakov
 * problem: 572. Subtree of Another Tree
 * time complexity: O(n^2)
 * algorithm: check every node if values equal then check subtrees for equality
 * else check if tree2 is subtree of left subtree of root1 or
 * check if tree2 is subtree of right subtree of root1
 * notes: faster than 97.46% of Java online submissions
 */
public class SubtreeOfTree572 {

    public static void main(String[] args) {
        SubtreeOfTree572 solution = new SubtreeOfTree572();

        solution.test();
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void test() {
        TreeNode root1 = new TreeNode(3);
        TreeNode t1node4 = new TreeNode(4);
        TreeNode t1node5 = new TreeNode(5);
        TreeNode t1node1 = new TreeNode(1);
        TreeNode t1node2 = new TreeNode(2);

        TreeNode root2 = new TreeNode(4);
        TreeNode t2node1 = new TreeNode(1);
        TreeNode t2node2 = new TreeNode(2);

        root1.left = t1node4;
        root1.right = t1node5;
        t1node4.left = t1node1;
        t1node4.right = t1node2;

        root2.left = t2node1;
        root2.right = t2node2;

        System.out.println(isSubtree(root1, root2));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        else if (s == null || t == null)
            return false;
        else if (s.left == null && s.right == null &&
                 t.left == null && t.right == null)
            return s.val == t.val;

        if (s.val == t.val) {
            // if values equal lets check if subtrees are equals
            if (isEqual(s.left, t.left) && isEqual(s.right, t.right))
                return true;
        }

        // check if tree2 is subtree of left subtree of tree1
        boolean isLeft = false;
        if (s.left != null)
            isLeft = isSubtree(s.left, t);

        // check if tree2 is subtree of right subtree of tree1
        boolean isRight = false;
        if (s.right != null)
            isRight = isSubtree(s.right, t);

        return isLeft || isRight;
    }

    private boolean isEqual(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        else if (s == null || t == null)
            return false;

        if (s.val != t.val)
            return false;

        return isEqual(s.left, t.left) &&
               isEqual(s.right, t.right);
    }

}


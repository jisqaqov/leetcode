package leetcode.p0018;


/**
 * @author Jandos Iskakov
 * problem: 129. Sum Root to Leaf Numbers
 * time complexity: O(n)
 * algorithm: based on DFS
 * pass next iteration val = 10val + node.val to left and right subtree
 * and then summurize
 */
public class SumRootToLeafNumbers129 {

    public static void main(String[] args) {
        SumRootToLeafNumbers129 solution = new SumRootToLeafNumbers129();

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
        TreeNode t1root = new TreeNode(4);
        TreeNode t1node9 = new TreeNode(9);
        TreeNode t1node0 = new TreeNode(0);
        TreeNode t1node5 = new TreeNode(5);
        TreeNode t1node1 = new TreeNode(1);

        t1root.left = t1node9;
        t1root.right = t1node0;
        t1node9.left = t1node5;
        t1node9.right = t1node1;

        System.out.println(sumNumbers(t1root));
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int val) {
        if (root == null)
            return 0;

        val = 10 * val + root.val;
        if (root.left == null && root.right == null)
            return val;

        return sumNumbers(root.left, val) + sumNumbers(root.right, val);
    }

}


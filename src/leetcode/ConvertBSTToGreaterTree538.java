package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 538. Convert BST to Greater Tree
 * algorithm: DFS, Tree
 * time complexity: O(n)
 * space complexity: O(1)
 */
public class ConvertBSTToGreaterTree538 {

    /**
     * Definition for a binary tree node.
     * */
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        ConvertBSTToGreaterTree538 problem = new ConvertBSTToGreaterTree538();
        problem.test();
    }

    private void test() {
        TreeNode root = new TreeNode(5);

        TreeNode node2 = new TreeNode(2);
        TreeNode node13 = new TreeNode(13);

        root.left = node2;
        root.right = node13;

        System.out.println(convertBST(root));
    }

    public TreeNode convertBST(TreeNode root) {
        convertBST(root, 0);
        return root;
    }

    public TreeNode convertBST(TreeNode root, int rp) {
        if (root == null) {
            return null;
        }

        root.val += rp;

        if (root.right != null) {
            root.val += sumRightSubTree(root.right);

            convertBST(root.right, rp);
        }

        if (root.left != null) {
            convertBST(root.left, root.val);
        }

        return root;
    }

    private int sumRightSubTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + sumRightSubTree(root.left) + sumRightSubTree(root.right);
    }

}

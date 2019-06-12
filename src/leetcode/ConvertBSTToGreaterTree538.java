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
        if (root == null) {
            return null;
        }

        Pair pair = convertBST(root, 0);
        return pair.node;
    }

    private Pair convertBST(TreeNode root, int rp) {
        Pair pair = new Pair();
        pair.node = new TreeNode(root.val);
        pair.node.val += rp;
        pair.sum = root.val;

        if (root.right != null) {
            Pair right = convertBST(root.right, rp);
            pair.node.right = right.node;
            pair.node.val += right.sum;
            pair.sum += right.sum;
        }

        if (root.left != null) {
            Pair left = convertBST(root.left, pair.node.val);
            pair.node.left = left.node;
            pair.sum += left.sum;
        }

        return pair;
    }

    private static class Pair {
        TreeNode node;
        int sum = 0;
    }

}
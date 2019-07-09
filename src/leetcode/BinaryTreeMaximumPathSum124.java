package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 124. Binary Tree Maximum Path Sum
 * algorithm: DP
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class BinaryTreeMaximumPathSum124 {

    int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum124 problem = new BinaryTreeMaximumPathSum124();
        problem.test();
    }

    private void test() {
        TreeNode tc1root = new TreeNode(1);
        TreeNode tc1left = new TreeNode(-2);
        TreeNode tc1right = new TreeNode(3);

        tc1root.left = tc1left;
        tc1root.right = tc1right;

        System.out.println(maxPathSum(tc1root));
    }

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;

        dfs(root);

        return max;
    }

    private Info dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        Info lt = dfs(root.left);
        Info rt = dfs(root.right);

        Integer maxLeft = lt != null ? max(lt.maxLeft, lt.maxRight) : null;
        Integer maxRight = rt != null ? max(rt.maxLeft, rt.maxRight) : null;

        Info info = new Info();

        info.maxLeft = maxLeft != null ? Math.max(root.val, maxLeft + root.val) : root.val;
        info.maxRight = maxRight != null ? Math.max(root.val, maxRight + root.val) : root.val;

        info.maxLocal = Math.max(Math.max(Math.max(root.val, info.maxLeft), info.maxRight),
                root.val + (maxLeft != null ? maxLeft : 0) + (maxRight != null ? maxRight : 0));

        max = Math.max(max, info.maxLocal);

        return info;
    }

    private Integer max(Integer a, Integer b) {
        if (a == null && b == null) {
            return null;
        }

        if (a != null && b != null) {
            return Math.max(a, b);
        }

        if (a != null) {
            return a;
        }

        return b;
    }

    private static class Info {
        Integer maxLeft;
        Integer maxRight;
        Integer maxLocal;
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

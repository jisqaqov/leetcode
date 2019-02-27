package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetcodeProblem {

    public static void main(String[] args) {
        LeetcodeProblem solution = new LeetcodeProblem();
        solution.test();
    }

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

    public void test() {
        int[] tc1a = {3,9,20,15,7};
        int[] tc1b = {9,3,15,20,7};

        int[] tc2a = {1, 2};
        int[] tc2b = {1, 2};
//
        int[] tc3a = {1, 2, 4, 3};
        int[] tc3b = {1, 2, 3, 4};

        System.out.println(buildTree(tc1a, tc1b));
        System.out.println(buildTree(tc2a, tc2b));
        System.out.println(buildTree(tc3a, tc3b));
    }

    private int i = 0;
    private Set<Integer> path = new HashSet<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        i = 0;
        path = new HashSet<>();

        if (preorder.length == 0)
            return null;

        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            indexes.put(inorder[i], i);

        return buildTree(preorder, inorder, null, null, indexes);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, TreeNode grandParent, TreeNode parent, Map<Integer, Integer> indexes) {
        if (i >= preorder.length)
            return null;

        TreeNode node = new TreeNode(preorder[i]);

        if (parent != null) {
            if (indexes.get(node.val) < indexes.get(parent.val)) {
                parent.left = node;
            } else {
                boolean isRight = false;
                for (int k = indexes.get(node.val) - 1; k >= 0; k--) {
                    if (path.contains(inorder[k]) && inorder[k] != parent.val) {
                        isRight = false;
                        break;
                    } else if (path.contains(inorder[k]) && inorder[k] == parent.val) {
                        isRight = true;
                        break;
                    }
                }

                if (isRight)
                    parent.right = node;
                else
                    return null;
            }
        }

        path.add(node.val);

        i++;

        buildTree(preorder, inorder, parent, node, indexes);
        buildTree(preorder, inorder, parent, node, indexes);

        return node;
    }

}

package leetcode.p0003;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: 993. Cousins in Binary Tree
 * algorithm: Tree, BFS
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class CousinsInBinaryTree993 {

    public static void main(String[] args) {
        CousinsInBinaryTree993 solution = new CousinsInBinaryTree993();
        solution.test();
    }

    public void test() {
        TreeNode tc1root = new TreeNode(1);
        TreeNode tc1node2 = new TreeNode(2);
        TreeNode tc1node3 = new TreeNode(3);
        TreeNode tc1node4 = new TreeNode(4);
        TreeNode tc1node5 = new TreeNode(5);

        tc1root.left = tc1node2;
        tc1root.right = tc1node3;
        tc1node2.right = tc1node4;
        tc1node3.right = tc1node5;

        System.out.println(isCousins(tc1root, 2, 3));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Map<Integer, Integer> parent = new HashMap<>();

        Map<Integer, Integer> depth = new HashMap<>();
        depth.put(root.val, 0);

        TreeNode nodeX = null, nodeY = null;

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (currNode.val == x) {
                nodeX = currNode;
            } else if (currNode.val == y) {
                nodeY = currNode;
            }

            if (nodeX != null && nodeY != null) {
                break;
            }

            if (currNode.left != null) {
                queue.add(currNode.left);
                parent.put(currNode.left.val, currNode.val);
                depth.put(currNode.left.val, depth.get(currNode.val) + 1);
            }

            if (currNode.right != null) {
                queue.add(currNode.right);
                parent.put(currNode.right.val, currNode.val);
                depth.put(currNode.right.val, depth.get(currNode.val) + 1);
            }
        }

        return !Objects.equals(parent.get(x), parent.get(y)) &&
               depth.get(x).equals(depth.get(y));
    }


}

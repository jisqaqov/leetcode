package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Jandos Iskakov
 * problem: 314. Binary Tree Vertical Order Traversal
 * algorithm: Hash Table
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class BinaryTreeVerticalOrderTraversal314 {

    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversal314 solution = new BinaryTreeVerticalOrderTraversal314();
        solution.test();
    }

    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node4 = new TreeNode(4);
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node7 = new TreeNode(7);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);

        root.left = node9;
        root.right = node8;
        node9.left = node4;
        node9.right = node0;
        node0.right = node2;
        node8.left = node1;
        node8.right = node7;
        node1.left = node5;

        System.out.println(verticalOrder(root));
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, List<Integer>> nodes = new HashMap<>();

        bfs(root, nodes);

        int min = nodes.keySet().stream().mapToInt(v -> v).min().getAsInt();
        int max = nodes.keySet().stream().mapToInt(v -> v).max().getAsInt();

        return IntStream.rangeClosed(min, max)
                .mapToObj(nodes::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private void bfs(TreeNode root, Map<Integer, List<Integer>> nodes) {
        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{root, 0});

        while (!queue.isEmpty()) {
            Object[] obj = queue.poll();

            TreeNode node = (TreeNode) obj[0];
            int x = (int) obj[1];

            nodes.putIfAbsent(x, new ArrayList<>());
            nodes.get(x).add(node.val);

            if (node.left != null) {
                queue.add(new Object[]{node.left, x - 1});
            }

            if (node.right != null) {
                queue.add(new Object[]{node.right, x + 1});
            }
        }
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

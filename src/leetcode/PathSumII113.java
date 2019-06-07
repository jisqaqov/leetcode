package leetcode;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: 113. Path Sum II
 * algorithm: DFS
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class PathSumII113 {

    /**
     * Definition for a binary tree node.
     * */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        PathSumII113 solution = new PathSumII113();
        solution.test();
    }

    public void test() {
        TreeNode root = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node13_2 = new TreeNode(13);
        TreeNode node4_2 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        root.left = node4;
        root.right = node8;
        node4.left = node11;
        node4.right = node13;
        node11.left = node7;
        node11.right = node2;
        node8.left = node13_2;
        node8.right = node4_2;
        node4_2.left = node5;
        node4_2.right = node1;

        SolutionV1 solutionV1 = new SolutionV1();
        System.out.println(solutionV1.pathSum(root, 22));

        SolutionV2 solutionV2 = new SolutionV2();
        System.out.println(solutionV2.pathSum(root, 22));
    }

    private static class SolutionV1 {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> solution = new ArrayList<>();
            if (root == null) {
                return solution;
            }

            pathSum(root, sum, 0, new ArrayDeque<>(), solution);

            return solution;
        }

        private void pathSum(TreeNode node, int sum, int pathSum, Deque<Integer> path, List<List<Integer>> list) {
            path.addLast(node.val);

            if (node.left == null && node.right == null && node.val + pathSum == sum) {
                list.add(new ArrayList<>(path));
            }

            if (node.left != null) {
                pathSum(node.left, sum, pathSum + node.val, path, list);
            }

            if (node.right != null) {
                pathSum(node.right, sum, pathSum + node.val, path, list);
            }

            path.removeLast();
        }
    }

    private static class SolutionV2 {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> solution = new ArrayList<>();
            if (root == null) {
                return solution;
            }

            if (root.left == null && root.right == null && root.val == sum) {
                return new ArrayList<>(Collections.singletonList(Collections.singletonList(root.val)));
            }

            if (root.left != null) {
                merge(root, root.left, sum, solution);
            }

            if (root.right != null) {
                merge(root, root.right, sum, solution);
            }

            return solution;
        }

        private void merge(TreeNode node, TreeNode subTree, int sum, List<List<Integer>> solution) {
            List<List<Integer>> treeList = pathSum(subTree, sum - node.val);
            if (treeList.isEmpty()) {
                return;
            }

            for (List<Integer> list : treeList) {
                List<Integer> newList = new ArrayList<>();
                newList.add(node.val);
                newList.addAll(list);

                solution.add(newList);
            }
        }

    }



}

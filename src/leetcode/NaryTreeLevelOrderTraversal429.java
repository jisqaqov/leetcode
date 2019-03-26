package leetcode;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: 429. N-ary Tree Level Order Traversal
 * algorithm: BFS
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class NaryTreeLevelOrderTraversal429 {

    public static void main(String[] args) {
        NaryTreeLevelOrderTraversal429 solution = new NaryTreeLevelOrderTraversal429();
        solution.test();
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public void test() {
        //TODO:
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> levels = new ArrayList<>();

        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[] {root, 1});

        levels.add(new ArrayList<>(Collections.singletonList(root.val)));

        while (!queue.isEmpty()) {
            Object[] item = queue.poll();

            Node currNode = (Node)item[0];
            int currDepth = (int)item[1];

            int nextDepth = currDepth + 1;

            currNode.children.forEach(node -> {
                if (levels.size() < nextDepth) {
                    levels.add(new ArrayList<>());
                }

                queue.add(new Object[]{node, nextDepth});

                levels.get(nextDepth - 1).add(node.val);
            });
        }

        return levels;
    }

}

package leetcode.p0014;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: 429. N-ary Tree Level Order Traversal
 * algorithm: BFS
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class  NaryTreeLevelOrderTraversal429 {

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
        Node root = new Node(1, new LinkedList<>());
        Node node3 = new Node(3, new LinkedList<>());
        Node node2 = new Node(2, new LinkedList<>());
        Node node4 = new Node(4, new LinkedList<>());
        Node node5 = new Node(5, new LinkedList<>());
        Node node6 = new Node(6, new LinkedList<>());

        root.children = Arrays.asList(node3, node2, node4);
        node3.children = Arrays.asList(node5, node6);

        System.out.print(levelOrder2(root));
    }

    public List<List<Integer>> levelOrder2(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> vals = new LinkedList<>();
        vals.add(new LinkedList<>(Collections.singletonList(root.val)));

        while (!queue.isEmpty()) {
            Queue<Node> children = new LinkedList<>();

            int size = vals.size() + 1;

            while (!queue.isEmpty()) {
                Node currNode = queue.poll();

                if (!currNode.children.isEmpty()) {
                    if (vals.size() < size) {
                        vals.add(new LinkedList<>());
                    }
                }

                currNode.children.forEach(child -> {
                    children.add(child);

                    vals.get(size - 1).add(child.val);
                });
            }

            queue = children;
        }

        return vals;
    }

}

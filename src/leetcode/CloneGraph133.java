package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jandos Iskakov
 * problem: 133. Clone Graph
 * algorithm: DFS
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 */
public class CloneGraph133 {

    public static void main(String[] args) {
        CloneGraph133 solution = new CloneGraph133();
        solution.test();
    }

    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", neighbors=" + neighbors
                    .stream()
                    .map(node -> node.val)
                    .collect(Collectors.toList()) +
                    '}';
        }
    }

    public void test() {
        Node node1 = new Node(1, new LinkedList<>());
        Node node2 = new Node(2, new LinkedList<>());
        Node node3 = new Node(3, new LinkedList<>());
        Node node4 = new Node(4, new LinkedList<>());

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);

        System.out.println(cloneGraph(node1));
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> memo = new HashMap<>();
        return cloneGraph(node, memo);
    }

    private Node cloneGraph(Node src, Map<Node, Node> memo) {
        if (memo.containsKey(src)) {
            return memo.get(src);
        }

        Node clone = new Node();
        clone.val = src.val;
        clone.neighbors = new LinkedList<>();

        memo.put(src, clone);

        for (Node child : src.neighbors) {
            clone.neighbors.add(cloneGraph(child, memo));
        }

        return clone;
    }

}

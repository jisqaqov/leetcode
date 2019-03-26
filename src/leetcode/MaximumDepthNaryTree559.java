package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 559. Maximum Depth of N-ary Tree
 * algorithm: BFS
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class MaximumDepthNaryTree559 {

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int depth = -1;

        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[] {root, 1});

        while (!queue.isEmpty()) {
            Object[] item = queue.poll();

            Node currNode = (Node)item[0];
            int currDepth = (int)item[1];

            depth = Math.max(depth, currDepth);

            currNode.children.forEach(node -> queue.add(new Object[] {node, currDepth + 1}));
        }

        return depth;
    }


}

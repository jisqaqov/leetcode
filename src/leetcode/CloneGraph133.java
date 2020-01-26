package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 133. Clone Graph
 * algorithm: DFS, BFS
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 * Runtime: 25 ms, faster than 25.00% of Java online submissions
 * Memory Usage: 38.6 MB, less than 5.88% of Java online submissions
 */
public class CloneGraph133 {

  public static void main(String[] args) {
    CloneGraph133 solution = new CloneGraph133();
    solution.test();
  }

  public void test() {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);

    node1.neighbors = Arrays.asList(node2, node4);
    node2.neighbors = Arrays.asList(node1, node3);
    node3.neighbors = Arrays.asList(node2, node4);
    node4.neighbors = Arrays.asList(node1, node3);

    System.out.println(cloneGraph(node1));
  }

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }

    Map<Node, Node> map = new HashMap<>();
    return clone(node, map);
  }

  private Node clone(Node node, Map<Node, Node> map) {
    if (map.containsKey(node)) {
      return map.get(node);
    }

    Node clone = new Node(node.val);

    map.put(node, clone);

    for (Node adj : node.neighbors) {
      clone.neighbors.add(clone(adj, map));
    }

    return clone;
  }

  private static class V2 {

    public Node cloneGraph(Node node) {
      Map<Node, Node> map = new HashMap<>();

      map.put(node, new Node(node.val));

      Queue<Node> queue = new LinkedList<>();
      queue.add(node);

      while (!queue.isEmpty()) {
        Node temp = queue.poll();

        Node clone = map.get(temp);

        for (Node adj : temp.neighbors) {
          Node adjClone = map.get(adj);

          if (adjClone == null) {
            adjClone = new Node(adj.val);

            map.put(adj, adjClone);
            queue.add(adj);
          }

          clone.neighbors.add(adjClone);
        }
      }

      return map.get(node);
    }
  }

  /**
   * Definition for a Node.
   */
  static class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

}

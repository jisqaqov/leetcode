package leetcode.p0003;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 138. Copy List with Random Pointer
 * algorithm: Hash Table, Linked List
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class CopyListWithRandomPointer138 {

  public Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<>();
    Node currentNode = head, prevNode = null;

    Node copyHead = null;
    while (currentNode != null) {
      Node copyNode = new Node(currentNode.val, null, null);
      if (prevNode != null) {
        prevNode.next = copyNode;
      }

      if (copyHead == null) {
        copyHead = copyNode;
      }

      map.put(currentNode, copyNode);

      prevNode = copyNode;
      currentNode = currentNode.next;
    }

    for (Node node : map.keySet()) {
      map.get(node).random = map.get(node.random);
    }

    return copyHead;
  }

  private static class RecursionApproach {
    public Node copyRandomList(Node head) {
      Map<Node, Node> map = new HashMap<>();
      return clone(head, map);
    }

    private Node clone(Node source, Map<Node, Node> map) {
      if (source == null) {
        return null;
      }

      if (map.containsKey(source)) {
        return map.get(source);
      }

      Node clone = new Node(source.val, null, null);
      map.put(source, clone);

      clone.next = clone(source.next, map);
      clone.random = clone(source.random, map);

      return clone;
    }
  }

  /**
   * Definition for a Node.
   */
  private static class Node {

    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int val, Node next, Node random) {
      this.val = val;
      this.next = next;
      this.random = random;
    }

    @Override
    public String toString() {
      return "Node{" +
          "val=" + val +
          ", next=" + (next != null? next.val: null) +
          ", random=" + (random != null? random.val: null) +
          '}';
    }
  }

}

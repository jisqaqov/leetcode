package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 430. Flatten a Multilevel Doubly Linked List
 * algorithm: Linked List, DFS
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 37.7 MB, less than 75.00% of Java online submissions
 */
public class FlattenAMultilevelDoublyLinkedList430 {

  public static void main(String[] args) {
    FlattenAMultilevelDoublyLinkedList430 problem = new FlattenAMultilevelDoublyLinkedList430();
    problem.test();
  }

  private void test() {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    Node node7 = new Node(7);
    Node node8 = new Node(8);
    Node node9 = new Node(9);
    Node node10 = new Node(10);
    Node node11 = new Node(11);
    Node node12 = new Node(12);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;

    node7.next = node8;
    node8.next = node9;
    node9.next = node10;

    node11.next = node12;

    node2.prev = node1;
    node3.prev = node2;
    node4.prev = node3;
    node5.prev = node4;
    node6.prev = node5;

    node8.prev = node7;
    node9.prev = node8;
    node10.prev = node9;

    node12.prev = node11;

    node3.child = node7;
    node8.child = node11;

    System.out.println(flatten(node1));
  }

  public Node flatten(Node head) {
    helper(head);

    return head;
  }

  private Node helper(Node head) {
    Node last = head;
    Node node = head;

    while (node != null) {
      Node next = node.next;

      Node tail = null;
      Node child = node.child;

      if (child != null) {
        node.next = child;
        child.prev = node;

        tail = helper(child);

        if (next != null) {
          next.prev = tail;
        }

        tail.next = next;

        node.child = null;
      }

      if (next == null) {
        if (child != null) {
          last = tail;
        } else {
          last = node;
        }
      }

      node = next;
    }

    return last;
  }

  // Definition for a Node.
  class Node {

    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return "Node{" +
        "val=" + val +
        ", prev=" + (prev != null ? prev.val : null) +
        ", next=" + next +
        ", child=" + "" +
        '}';
    }
  }


}
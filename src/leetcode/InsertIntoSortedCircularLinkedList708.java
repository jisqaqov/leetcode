package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 708. Insert into a Sorted Circular Linked List
 * algorithm: Linked List
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Sorted Circular Linked List.
 * Memory Usage: 36.2 MB, less than 10.00% of Java online submissions for Insert into a Sorted Circular Linked List.
 */
public class InsertIntoSortedCircularLinkedList708 {

  public static void main(String[] args) {
    InsertIntoSortedCircularLinkedList708 problem = new InsertIntoSortedCircularLinkedList708();
    problem.test();
  }

  private void test() {
    Node node3 = new Node(3, null);
    Node node4 = new Node(4, null);
    Node node1 = new Node(1, null);

    node3.next = node4;
    node4.next = node1;
    node1.next = node4;

    System.out.println(insert(node3, 2));
  }

  public Node insert(Node head, int insertVal) {
    Node newNode = new Node();
    newNode.val = insertVal;

    if (head == null) {
      newNode.next = newNode;
      return newNode;
    }

    boolean isFound = false;

    Node currNode = head;
    Node tail = null;

    while (true) {
      if (insertVal >= currNode.val && insertVal <= currNode.next.val) {
        isFound = true;
        break;
      }

      if (currNode.val > currNode.next.val) {
        tail = currNode;
      }

      currNode = currNode.next;

      if (currNode == head) {
        break;
      }
    }

    if (isFound) {
      newNode.next = currNode.next;
      currNode.next = newNode;
    } else if (tail != null) {
      newNode.next = tail.next;
      tail.next = newNode;
    } else {
      newNode.next = head;
      head.next = newNode;
    }

    return head;
  }

  // Definition for a Node.
  class Node {

    public int val;
    public Node next;

    public Node() {
    }

    public Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }
  }

}

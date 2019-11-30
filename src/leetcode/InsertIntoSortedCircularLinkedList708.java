package leetcode;

/**
 * @author https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/discuss/149374/Java-5ms-One-Pass-and-Two-Pass-Traverse-With-Detailed-Comments-and-Edge-cases!/221648
 * problem: 708. Insert into a Sorted Circular Linked List
 * algorithm: Linked List
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Sorted Circular Linked List.
 * Memory Usage: 36.2 MB, less than 10.00% of Java online submissions for Insert into a Sorted Circular Linked List.
 * 3 cases
 * case 1: insertVal is between 2 nodes
 *  e.g. 1->2->4, insert 3
 *  condition: insertVal >= n.val && insertVal <= n.next.val
 *
 * case 2: insertVal is >= largest node value or <= smalles node value
 *  e.g. 1->2->4, insert 0 or 1->2->4, insert 5
 *  condition: n.next.val < n.val && (insertVal >= n.val || insertVal <= n.next.val)
 *
 * case 3: all the nodes in the tree have same value
 *  e.g. 1->1->1, insert 2
 *  condition: n.next == head
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
    Node newNode = new Node(insertVal, null);

    if (head == null) {
      newNode.next = newNode;
      return newNode;
    }

    Node currNode = head;

    while (true) {
      if ((insertVal >= currNode.val && insertVal <= currNode.next.val) ||
          (currNode.val > currNode.next.val && (insertVal >= currNode.val || insertVal <= currNode.next.val)) ||
          (currNode.next == head)) {
        newNode.next = currNode.next;
        currNode.next = newNode;

        break;
      }

      currNode = currNode.next;
    }

    return head;
  }

  // Definition for a Node.
  static class Node {

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

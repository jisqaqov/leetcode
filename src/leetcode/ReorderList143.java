package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 143. Reorder List
 * algorithm: Linked List
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 99.95% of Java online submissions for Reorder List.
 * Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Reorder List.
 */
public class ReorderList143 {

  public static void main(String[] args) {
    ReorderList143 problem = new ReorderList143();
    problem.test();
  }

  private void test() {
    ListNode head = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    ListNode node7 = new ListNode(7);

    head.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;

    reorderList(head);

    System.out.println(head);
  }

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    // find middle node
    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // reverse from middle node
    ListNode curr = slow.next;
    slow.next = null;

    ListNode prev = null;

    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;

      prev = curr;
      curr = next;
    }

    // merge lists
    ListNode p = head;
    ListNode q = prev;

    while (p != null && q != null) {
      ListNode next1 = p.next;
      ListNode next2 = q.next;

      p.next = q;
      q.next = next1;

      p = next1;
      q = next2;
    }
  }


  /**
   * Definition for singly-linked list.
   */
  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      return "ListNode{" +
        "val=" + val +
        ", next=" + next +
        '}';
    }
  }


}

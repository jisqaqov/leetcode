package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 143. Reorder List
 * algorithm: Linked List
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 2 ms, faster than 39.78% of Java online submissions for Reorder List.
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

    head.next = node2;
//    node2.next = node3;
//    node3.next = node4;
//    node4.next = node5;
//    node5.next = node6;

    reorderList(head);

    System.out.println(head);
  }

  public void reorderList(ListNode head) {
    int n = countSize(head);
    if (n <= 2) {
      return;
    }

    ListNode midNode = getMidOfList(head, n);

    ListNode tail = reverseList(midNode);

    ListNode p = head;
    ListNode q = tail;
    ListNode prev = null;

    while (p != null && q != null) {
      ListNode next1 = p.next;
      ListNode next2 = q.next;

      if (prev != null) {
        prev.next = p;
      }

      p.next = q;
      prev = q;

      p = next1;
      q = next2;
    }

    if (prev != null) {
      prev.next = null;
    }
  }

  private int countSize(ListNode head) {
    int n = 0;

    ListNode curr = head;
    while (curr != null) {
      n++;
      curr = curr.next;
    }

    return n;
  }

  private ListNode getMidOfList(ListNode head, int n) {
    ListNode midNode = head;

    int index = 0;
    while (index < n / 2) {
      index++;
      midNode = midNode.next;
    }

    return midNode;
  }

  private ListNode reverseList(ListNode head) {
    ListNode curr = head.next;

    ListNode prev = head;
    head.next = null;

    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;

      prev = curr;
      curr = next;
    }

    return prev;
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

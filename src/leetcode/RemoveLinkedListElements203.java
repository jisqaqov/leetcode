package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 203. Remove Linked List Elements
 * algorithm: Linked List
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 89.01% of Java online submissions
 * Memory Usage: 42.4 MB, less than 6.35% of Java online submissions
 */
public class RemoveLinkedListElements203 {

  public ListNode removeElements(ListNode head, int val) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      ListNode next = curr.next;

      if (head.val == val) {
        head = next;
      } else if (curr.val == val) {
        prev.next = next;
      } else {
        prev = curr;
      }

      curr = next;
    }

    return head;
  }

  private class V2 {

    public ListNode removeElements(ListNode head, int val) {
      ListNode sentinel = new ListNode(0);
      sentinel.next = head;

      ListNode prev = sentinel;
      ListNode curr = head;

      while (curr != null) {
        ListNode next = curr.next;

        if (curr.val == val) {
          prev.next = next;
        } else {
          prev = curr;
        }

        curr = next;
      }

      return sentinel.next;
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

  }


}

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
    ListNode temp = head;

    while (temp != null) {
      ListNode next = temp.next;

      if (head.val == val) {
        head = next;
      } else if (temp.val == val) {
        prev.next = next;
      } else {
        prev = temp;
      }

      temp = next;
    }

    return head;
  }

  private class V2 {

    public ListNode removeElements(ListNode head, int val) {
      ListNode sentinel = new ListNode(0);
      sentinel.next = head;

      ListNode prev = sentinel;

      while (head != null) {
        ListNode next = head.next;

        if (head.val == val) {
          prev.next = next;
        } else {
          prev = head;
        }

        head = next;
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

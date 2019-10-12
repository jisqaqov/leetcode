package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 19. Remove Nth Node From End of List
 * algorithm: Linked List, Two Pointer
 * time complexity: O(n)
 * space complexity: O(1)
 */
public class RemoveNthNodeFromEndOfList19 {

  public static void main(String[] args) {
    RemoveNthNodeFromEndOfList19 problem = new RemoveNthNodeFromEndOfList19();
    problem.test();
    problem.test2();
    problem.test3();
  }

  private void test() {
    ListNode head = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);

    head.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    System.out.println(removeNthFromEnd(head, 2));
  }

  private void test2() {
    ListNode head = new ListNode(1);

    head.next = new ListNode(2);

    System.out.println(removeNthFromEnd(head, 1));
  }

  private void test3() {
    ListNode head = new ListNode(1);

    System.out.println(removeNthFromEnd(head, 1));
  }

  public ListNode removeNthFromEnd(ListNode head, int k) {
    ListNode q = head;

    while (q.next != null && k > 0) {
      q = q.next;
      k--;
    }

    if (k == 1) {
      return head.next;
    }

    ListNode p = head;

    while (q.next != null) {
      p = p.next;
      q = q.next;
    }

    if (p.next != null) {
      p.next = p.next.next;
    }

    return head;
  }

  private static class NaiveSolution {

    public ListNode removeNthFromEnd(ListNode head, int k) {
      int n = 0;
      ListNode node = head;

      while (node != null) {
        n++;
        node = node.next;
      }

      if (k > n) {
        return head;
      } else if (k == n) {
        return head.next;
      }

      int i = 0, p = n - k - 1;

      node = head;
      while (i < p) {
        node = node.next;
        i++;
      }

      node.next = node.next.next;

      return head;
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

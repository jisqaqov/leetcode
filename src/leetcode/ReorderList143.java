package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 143. Reorder List
 * algorithm: Linked List
 * time complexity: O(N)
 * space complexity: O(N)
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

//    head.next = node2;
//    node2.next = node3;
    //node3.next = node4;
    //node4.next = node5;
    //node5.next = node6;

    reorderList(head);

    System.out.println(head);
  }

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
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

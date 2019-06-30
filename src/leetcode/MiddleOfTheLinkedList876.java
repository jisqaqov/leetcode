package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 876. Middle of the Linked List
 * algorithm: Two Pointers, Linked List
 * time complexity: O(N)
 * space complexity: O(1)
 */
public class MiddleOfTheLinkedList876 {

    public static void main(String[] args) {
        MiddleOfTheLinkedList876 solution = new MiddleOfTheLinkedList876();
        solution.test();
    }

    public void test() {
        ListNode t1head = new ListNode(1);
        ListNode t1node2 = new ListNode(2);
        ListNode t1node3 = new ListNode(3);
        ListNode t1node4 = new ListNode(4);
        ListNode t1node5 = new ListNode(5);
        ListNode t1node6 = new ListNode(6);

        t1head.next = t1node2;
        t1node2.next = t1node3;
        t1node3.next = t1node4;
        t1node4.next = t1node5;
        t1node5.next = t1node6;

        System.out.println(middleNode(t1head));
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = head;

        while (p != null && q != null) {
            p = p.next;
            q = q.next != null? q.next.next: null;

            if (q != null && q.next == null) {
                return p;
            }
        }

        return p;
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

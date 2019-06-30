package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 142. Linked List Cycle II
 * solution based on https://www.youtube.com/watch?v=LUm2ABqAs1w&t=905s
 * algorithm: Two Pointers, Linked List
 * time complexity: O(N)
 * space complexity: O(1)
 */
public class LinkedListCycleII {

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        LinkedListCycleII solution = new LinkedListCycleII();
        solution.test();
    }

    public void test() {
        ListNode tc1head = new ListNode(3);
        ListNode tc1node2 = new ListNode(2);
        ListNode tc1node0 = new ListNode(0);
        ListNode tc1nodeM4 = new ListNode(-4);

        tc1head.next = tc1node2;
        tc1node2.next = tc1node0;
        tc1node0.next = tc1nodeM4;
        tc1nodeM4.next = tc1node2;

        System.out.println(detectCycle(tc1head));
    }

    public ListNode detectCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;

        ListNode t = null;

        while (p != null && q != null) {
            p = p.next;
            q = q.next != null? q.next.next: null;

            if (p == q) {
                t = p;
                break;
            }
        }

        if (t == null) {
            return null;
        }

        p = head;
        q = t;

        while (p != q) {
            p = p.next;
            q = q.next;
        }

        return p;
    }



}

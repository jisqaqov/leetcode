package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 206. Reverse Linked List
 * algorithm: Recursion, Linked List
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class ReverseLinkedList206 {

    /**
     * Definition for singly-linked list.
     * */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        new ReverseLinkedList206().test();
    }

    private void test() {
        ListNode tc1head = new ListNode(1);
        ListNode tc1node2 = new ListNode(2);
        ListNode tc1node3 = new ListNode(3);
        ListNode tc1node4 = new ListNode(4);
        ListNode tc1node5 = new ListNode(5);

        tc1head.next = tc1node2;
        tc1node2.next = tc1node3;
        tc1node3.next = tc1node4;
        tc1node4.next = tc1node5;

        System.out.println(reverseList(tc1head));
    }


    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode tail = head;

        while (node != null) {
            tail = node;
            node = node.next;
        }

        reverseListRecursively(head);

        return tail;
    }

    public ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseListRecursively(head.next);
        node.next = head;

        head.next = null;

        return head;
    }

}

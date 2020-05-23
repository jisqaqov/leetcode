package leetcode.p0018;

/**
 * @author Jandos Iskakov
 * problem: 24. Swap Nodes in Pairs
 * time complexity: O(n)
 * algorithm: based on two pointer technique
 */
public class SwapNodesInPairs24 {

    public static void main(String[] args) {
        SwapNodesInPairs24 solution = new SwapNodesInPairs24();

        solution.test();
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public void test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;

        ListNode newHead = null;
        ListNode prev = null;

        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            if (prev != null) {
                // link prev node to current or next
                prev.next = next == null? node: next;
            }

            ListNode nextNext = null;
            if (next != null) {
                if (newHead == null)
                    newHead = next;

                nextNext = next.next;
                next.next = node;
            }

            node.next = null;
            prev = node;

            // jump to node next of next
            node = nextNext;
        }

        if (newHead == null)
            newHead = head;

        return newHead;
    }

}


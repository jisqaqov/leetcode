package leetcode.p0016;

/**
 * @author Jandos Iskakov
 * problem: 86. Partition List
 * time complexity: O(n)
 * algorithm: Linked List, Two Pointers
 * place items less than x before first item that is greater or equal to x
 * and change next pointers
 */
public class PartitionList86 {

    public static void main(String[] args) {
        PartitionList86 solution = new PartitionList86();
        solution.test();
    }

    public void test() {
        ListNode l1head = new ListNode(1);
        ListNode l1node4 = new ListNode(4);
        ListNode l1node3 = new ListNode(3);
        ListNode l1node2 = new ListNode(2);
        ListNode l1node5 = new ListNode(5);
        ListNode l1node2_2 = new ListNode(2);

        l1head.next = l1node4;
        l1node4.next = l1node3;
        l1node3.next = l1node2;
        l1node2.next = l1node5;
        l1node5.next = l1node2_2;

        System.out.println(partition(l1head, 3));

        ListNode l2head = new ListNode(2);
        l2head.next = new ListNode(1);

        System.out.println(partition(l2head, 2));
    }

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

    public ListNode partition(ListNode head, int x) {
        ListNode gtPrev = null, gt = null;
        ListNode lt = head;
        ListNode prev = null;

        for (; lt != null;) {
            if (lt.val >= x) {
                if (gt == null) {
                    gt = lt;
                    gtPrev = prev;
                }
            }

            if (lt.val < x) {
                if (gt != null) {
                    if (gt == head)
                        head = lt;

                    ListNode oldLtNext = lt.next;
                    lt.next = gt;

                    if (gtPrev != null) {
                        gtPrev.next = lt;
                    }

                    gtPrev = lt;

                    if (prev != null) {
                        prev.next = oldLtNext;
                    }

                    lt = oldLtNext;
                } else {
                    prev = lt;
                    lt = lt.next;
                }
            } else {
                prev = lt;
                lt = lt.next;
            }
        }

        return head;
    }


}

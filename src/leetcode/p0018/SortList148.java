package leetcode.p0018;

/**
 * @author Jandos Iskakov
 * problem: 148. Sort List
 * algorithm: Merge Sort, Linked List
 * time complexity: O(nlogn)
 * space complexity: O(1)
 */
public class SortList148 {

    public static void main(String[] args) {
        SortList148 solution = new SortList148();
        solution.test();
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

    public void test() {
        ListNode t1head = new ListNode(-1);
        ListNode t1node5 = new ListNode(5);
        ListNode t1node3 = new ListNode(3);
        ListNode t1node4 = new ListNode(4);
        ListNode t1node0 = new ListNode(0);

        t1head.next = t1node5;
        t1node5.next = t1node3;
        t1node3.next = t1node4;
        t1node4.next = t1node0;

        //t1head = sortList(t1head);

        ListNode l2head = new ListNode(4);
        ListNode l2node19 = new ListNode(19);
        ListNode l2node14 = new ListNode(14);
        ListNode l2node5 = new ListNode(5);
        ListNode l2node_3 = new ListNode(-3);
        ListNode l2node1 = new ListNode(1);
        ListNode l2node8 = new ListNode(8);
        ListNode l2node5_2 = new ListNode(5);
        ListNode l2node11 = new ListNode(11);
        ListNode l2node15 = new ListNode(15);

        l2head.next = l2node19;
        l2node19.next = l2node14;
        l2node14.next = l2node5;
        l2node5.next = l2node_3;
        l2node_3.next = l2node1;
        l2node1.next = l2node8;
        l2node8.next = l2node5_2;
        l2node5_2.next = l2node11;
        l2node11.next = l2node15;

        l2head = sortList(l2head);
        System.out.println(l2head);
    }

    public ListNode sortList(ListNode head) {
        ListNode newHead = head;
        int n = getSize(head, -1);

        for (int i = 1; i < n; i *= 2) {
            ListNode prev = null;
            boolean setHead = true;
            for (ListNode l1 = newHead; l1 != null;) {
                int size = getSize(l1, 2*i);

                ListNode subNext = null;
                ListNode subHead = null;

                if (size > 1) {
                    ListNode tail = getAtIndex(l1, size - 1);
                    subNext = tail.next;
                    tail.next = null;

                    ListNode l2 = null;
                    if (i < size) {
                        l2 = getAtIndex(l1, i);

                        ListNode l1Tail = getAtIndex(l1, i - 1);
                        l1Tail.next = null;
                    }

                    subHead = merge(l1, l2);
                } else {
                    subHead = l1;
                    subNext = l1.next;
                }

                if (setHead) {
                    newHead = subHead;
                    setHead = false;
                }

                if (prev != null) {
                    prev.next = subHead;
                }

                prev = getAtIndex(subHead, size - 1);

                l1 = subNext;
            }
        }

        return newHead;
    }

    private int getSize(ListNode list, int max) {
        int size = 0;

        ListNode node = list;
        while (node != null && (size < max || max == -1)) {
            size++;
            node = node.next;
        }

        return size;
    }

    private ListNode getAtIndex(ListNode list, int index) {
        ListNode node = list;

        for (int i = 0; ; i++) {
            if (i == index)
                break;

            node = node.next;
        }

        return node;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = null, prev = null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (head == null) {
                    head = l1;
                }

                if (prev != null) {
                    prev.next = l1;
                }

                prev = l1;

                l1 = l1.next;
            } else {
                if (head == null)
                    head = l2;

                if (prev != null) {
                    prev.next = l2;
                }

                prev = l2;

                l2 = l2.next;
            }
        }

        while (l1 != null) {
            if (head == null) {
                head = l1;
            }

            if (prev != null) {
                prev.next = l1;
            }

            prev = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            if (head == null) {
                head = l2;
            }

            if (prev != null) {
                prev.next = l2;
            }

            prev = l2;
            l2 = l2.next;
        }

        return head;
    }



}

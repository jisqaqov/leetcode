package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 21. Merge Two Sorted Lists
 * algorithm: Two Pointer, Linked List
 * time complexity: O(n)
 * space complexity: O(1)
 */
public class MergeTwoSortedLists21 {

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

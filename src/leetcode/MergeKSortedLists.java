package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 23. Merge k Sorted Lists
 * algorithm: Heap, Devide And Conquer, Linked List
 * time complexity: O(n*k*log(k))
 */
public class MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        ListNode head = null, prev = null;

        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists)
            if (list != null)
                heap.add(list);

        while (!heap.isEmpty()) {
            ListNode node = heap.peek();
            ListNode newNode = new ListNode(node.val);

            if (head == null) {
                head = newNode;
            } else {
                prev.next = newNode;
            }

            prev = newNode;

            heap.poll();

            ListNode next = node.next;
            if (next != null)
                heap.add(next);
        }

        return head;
    }

}

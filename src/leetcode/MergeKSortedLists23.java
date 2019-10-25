package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 23. Merge k Sorted Lists
 * algorithm: Heap, Devide And Conquer, Linked List
 * time complexity: O(n*log(k))
 * space complexity: O(n)
 * Runtime: 38 ms, faster than 22.60% of Java online submissions for Merge k Sorted Lists.
 * Memory Usage: 41 MB, less than 44.81% of Java online submissions for Merge k Sorted Lists.
 */
public class MergeKSortedLists23 {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }

    ListNode head = null, prev = null;

    PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
    for (ListNode list : lists) {
      if (list != null) {
        heap.add(list);
      }
    }

    while (!heap.isEmpty()) {
      ListNode node = heap.poll();
      ListNode newNode = new ListNode(node.val);

      if (head == null) {
        head = newNode;
      } else {
        prev.next = newNode;
      }

      prev = newNode;

      if (node.next != null) {
        heap.add(node.next);
      }
    }

    return head;
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
  }

}

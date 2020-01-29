package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 109. Convert Sorted List to Binary Search Tree
 * algorithm: Tree, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 41.5 MB, less than 5.26% of Java online submissions
 */
public class ConvertSortedListToBinarySearchTree109 {

  public static void main(String[] args) {
    ConvertSortedListToBinarySearchTree109 problem =
      new ConvertSortedListToBinarySearchTree109();
    problem.test();
  }

  private void test() {
    ListNode head = new ListNode(-10);
    ListNode node_3 = new ListNode(-3);
    ListNode node0 = new ListNode(0);
    ListNode node5 = new ListNode(5);
    ListNode node9 = new ListNode(9);

    head.next = node_3;
    node_3.next = node0;
    node0.next = node5;
    node5.next = node9;

    System.out.println(sortedListToBST(head));
  }

  public TreeNode sortedListToBST(ListNode head) {
    return helper(head, null);
  }

  private TreeNode helper(ListNode head, ListNode tail) {
    if (head == tail) {
      return null;
    }

    ListNode p = head;
    ListNode q = head;

    while (q != tail && q.next != tail) {
      p = p.next;
      q = q.next.next;
    }

    TreeNode node = new TreeNode(p.val);
    node.left = helper(head, p);
    node.right = helper(p.next, tail);

    return node;
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

  /**
   * Definition for a binary tree node.
   */
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      return "TreeNode{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
    }
  }


}
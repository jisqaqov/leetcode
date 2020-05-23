package leetcode.p0001;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 445. Add Two Numbers II
 * algorithm: Math, solved by reversing linked lists
 * time complexity: O(n)
 * space complexity: O(1)
 */
public class AddTwoNumbers445 {

    public static void main(String[] args) {
        AddTwoNumbers445 problem = new AddTwoNumbers445();
        problem.test();
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
        ListNode l1 = new ListNode(7);
        ListNode l1node2 = new ListNode(2);
        ListNode l1node4 = new ListNode(4);
        ListNode l1node3 = new ListNode(3);

        l1.next = l1node2;
        l1node2.next = l1node4;
        l1node4.next = l1node3;

        ListNode l2 = new ListNode(5);
        ListNode l2node2 = new ListNode(6);
        ListNode l2node4 = new ListNode(4);

        l2.next = l2node2;
        l2node2.next = l2node4;

        /*ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(9);
        ListNode l2node9 = new ListNode(9);

        l2.next = l2node9;*/

        System.out.println(addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode node1 = l1;
        ListNode node2 = l2;

        List<Integer> nums = new ArrayList<>();

        int carry = 0;
        while (node1 != null && node2 != null) {
            int s = node1.val + node2.val + carry;

            if (s > 9) {
                carry = 1;
                s = s % 10;
            } else {
                carry = 0;
            }

            node1 = node1.next;
            node2 = node2.next;

            nums.add(s);
        }

        if (node1 != null)
            carry = addRest(node1, carry, nums);

        if (node2 != null)
            carry = addRest(node2, carry, nums);

        if (carry > 0) {
            while (carry > 0) {
                nums.add(carry % 10);
                carry /= 10;
            }
        }

        ListNode l3 = null, prev = null;
        for (int i = nums.size() - 1; i >= 0; i--) {
            ListNode node3 = new ListNode(nums.get(i));
            if (i == nums.size() - 1) {
                l3 = node3;
            }

            if (prev != null)
                prev.next = node3;

            prev = node3;
        }

        return l3;
    }

    private int addRest(ListNode node, int carry, List<Integer> list) {
        while (node != null) {
            int s = node.val + carry;

            if (s > 9) {
                carry = 1;
                s = s % 10;
            } else {
                carry = 0;
            }

            list.add(s);

            node = node.next;
        }

        return carry;
    }

    private ListNode reverse(ListNode head) {
        ListNode node = head;
        ListNode prev = null;

        while (node != null) {
            ListNode next = node.next;

            node.next = prev;

            prev = node;
            node = next;

            if (node != null)
                head = node;
        }

        return head;
    }



}

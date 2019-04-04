package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 2. Add Two Numbers
 * algorithm: Math, Linked List
 * time complexity: O(n)
 * space complexity: O(n)
 * Runtime: 2 ms, faster than 98.47% of Java online submissions for Add Two Numbers.
 * Memory Usage: 46.9 MB, less than 51.52% of Java online submissions for Add Two Numbers.
 */
public class AddTwoNumbers2 {

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
        AddTwoNumbers2 solution = new AddTwoNumbers2();
        solution.test();
    }

    public void test() {
        ListNode l1head = new ListNode(2);
        ListNode l1node4 = new ListNode(4);
        ListNode l1node3 = new ListNode(3);

        l1head.next = l1node4;
        l1node4.next = l1node3;

        ListNode l2head = new ListNode(5);
        ListNode l2node6 = new ListNode(6);
        ListNode l2node4 = new ListNode(4);

        l2head.next = l2node6;
        l2node6.next = l2node4;

        System.out.println(addTwoNumbers(l1head, l2head));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode prev = null;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = 0;

            sum += l1 != null? l1.val: 0;
            sum += l2 != null? l2.val: 0;

            if (carry != 0) {
                sum += carry;
            }

            if (sum >= 10) {
                carry = 1;
                sum %= 10;
            } else {
                carry = 0;
            }

            ListNode newNode = new ListNode(sum);
            if (prev != null) {
                prev.next = newNode;
            }

            if (head == null) {
                head = newNode;
            }

            prev = newNode;

            l1 = l1 != null? l1.next: null;
            l2 = l2 != null? l2.next: null;
        }

        if (carry != 0) {
            prev.next = new ListNode(carry);
        }

        return head;
    }



}

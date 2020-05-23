package leetcode.p0016;

/**
 * @author Jandos Iskakov
 * problem: 234. Palindrome Linked List
 * algorithm: Linked List
 */
public class PalindromeLinkedList234 {

    public static void main(String[] args) {
        PalindromeLinkedList234 solution = new PalindromeLinkedList234();
        solution.test();
    }

    /**
     * Definition for singly-linked list.
     **/
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void test() {
        //1->2->2->1;
        ListNode tc1head = new ListNode(1);
        ListNode tc1node2_1 = new ListNode(2);
        ListNode tc1node2_2 = new ListNode(2);
        ListNode tc1node1 = new ListNode(1);

        tc1head.next = tc1node2_1;
        tc1node2_1.next = tc1node1;
        tc1node2_2.next = tc1node1;

        SolutionRecursive solutionRecursive = new SolutionRecursive();
        System.out.println(solutionRecursive.isPalindrome(tc1head));

        SolutionUsingReverse solutionUsingReverse = new SolutionUsingReverse();
        System.out.println(solutionUsingReverse.isPalindrome(tc1head));
    }

    /**
     * algorithm: recursion
     * time complexity: O(N)
     * space complexity: O(N)
     */
    private static class SolutionRecursive {
        private ListNode head = null;

        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            this.head = head;

            ListNode node = head;
            int n = 0;
            while (node != null) {
                n++;
                node = node.next;
            }

            return isPalindrome(head, 1, n);
        }

        public boolean isPalindrome(ListNode node, int i, int n) {
            if (i < n) {
                if (!isPalindrome(node.next, i + 1, n)) {
                    return false;
                }
            }

            if (i <= n / 2) {
                return true;
            }

            if (node.val != head.val) {
                return false;
            }

            head = head.next;

            return true;
        }
    }

    /**
     * time complexity: O(N)
     * space complexity: O(1)
     */
    private static class SolutionUsingReverse {
        public boolean isPalindrome(ListNode head) {
            int n = 0;

            ListNode curr = head;
            while (curr != null) {
                curr = curr.next;
                n++;
            }

            int i = 0, middle = n/2;
            curr = head;

            ListNode middleNode = head;
            while (curr != null) {
                if (i >= middle) {
                    middleNode = curr;
                    break;
                }

                curr = curr.next;
                i++;
            }

            middleNode = reverseList(middleNode);

            ListNode listNode1 = head;
            ListNode listNode2 = middleNode;

            for (int t = 0; t < middle; t++) {
                if (listNode1.val != listNode2.val)
                    return false;

                listNode1 = listNode1.next;
                listNode2 = listNode2.next;
            }

            return true;
        }

        public ListNode reverseList(ListNode head) {
            if (head == null)
                return null;
            else if (head.next == null)
                return head;

            ListNode currNode = head;
            ListNode nextNode = head.next;

            while (nextNode != null) {
                ListNode tempNextNode = nextNode.next;

                nextNode.next = currNode;

                currNode = nextNode;
                nextNode = tempNextNode;
            }

            head = currNode;

            return head;
        }
    }


}

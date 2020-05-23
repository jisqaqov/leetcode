package leetcode.p0004;


/**
 * @author Jandos Iskakov
 * problem: 707. Design Linked List
 * time complexity: get: O(n), addAtHead: O(1), addAtTail: O(1), addAtIndex: O(n), deleteAtIndex: O(n)
 * space complexity: O(n)
 * algorithm: Linked List
 */
public class DesignLinkedList707 {

    public static void main(String[] args) {
        DesignLinkedList707 solution = new DesignLinkedList707();
        solution.test();
    }

    public void test() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        System.out.println(linkedList.get(1) == 2);            // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        System.out.println(linkedList.get(1) == 3);            // returns 3

        MyLinkedList linkedList2 = new MyLinkedList();
        linkedList2.addAtHead(5);
        linkedList2.addAtHead(2);
        linkedList2.deleteAtIndex(1);
        linkedList2.addAtIndex(1, 9);
        linkedList2.addAtHead(4);
        linkedList2.addAtHead(9);
        linkedList2.addAtHead(8);
        linkedList2.get(3);
        linkedList2.addAtTail(1);
        linkedList2.addAtIndex(3, 6);
        linkedList2.addAtHead(3);

        MyLinkedList linkedList3 = new MyLinkedList();
        linkedList3.addAtIndex(-1, 0);
        linkedList3.get(0);
        linkedList3.deleteAtIndex(-1);
    }

    private static class MyLinkedList {
        int size = 0;
        private Node head, tail;

        private static class Node {
            private int val;
            private Node next, prev;

            public Node(int val) {
                this.val = val;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "val=" + val +
                        '}';
            }
        }

        /** Initialize your data structure here. */
        public MyLinkedList() {
            //
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (head == null) {
                return -1;
            }

            Node node = getNodeAtIndex(index);
            return node != null? node.val: -1;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node node = new Node(val);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.prev = node;

                head = node;
            }

            ++size;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node node = new Node(val);

            if (tail == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev = tail;

                tail = node;
            }

            ++size;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            Node newNode = new Node(val);

            if (index <= 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {
                ++size;

                Node node = getNodeAtIndex(index);

                node.prev.next = newNode;
                newNode.prev = node.prev;

                newNode.next = node;
                node.prev = newNode;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index < 0 || index > size) {
                return;
            }

            Node node = getNodeAtIndex(index);

            if (node == null) {
                return;
            }

            if (tail == node) {
                tail = tail.prev;
                if (tail == null) {
                    head = null;
                } else {
                    tail.next = null;
                }
            } else if (head == node) {
                head = head.next;
                if (head == null) {
                    tail = null;
                } else {
                    head.prev = null;
                }
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            --size;
        }

        private Node getNodeAtIndex(int index) {
            int i = 0;
            Node node = head;

            while (node != null && i < index) {
                node = node.next;
                i++;
            }

            return i == index? node: null;
        }

    }

}

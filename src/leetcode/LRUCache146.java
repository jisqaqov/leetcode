package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 146. LRU Cache
 * algorithm: HashMap, LinkedList
 * time complexity: O(1)
 * space complexity: O(n)
 */
public class LRUCache146 {

    public static void main(String[] args) {
        LRUCache146 solution = new LRUCache146();
//        solution.test();
//        solution.test2();
//        solution.test3();
//        solution.test4();
        solution.test5();
    }

    public void test() {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

    public void test2() {
        LRUCache cache = new LRUCache( 1 /* capacity */ );

        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

    public void test3() {
        LRUCache cache = new LRUCache( 1 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

        cache.put(1, 9);
    }

    public void test4() {
        LRUCache cache = new LRUCache( 2);

        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        System.out.println(cache.get(2));
    }

    public void test5() {
        LRUCache cache = new LRUCache( 10);

        cache.put(10,13);
        cache.put(3,17);
        cache.put(6,11);
        cache.put(10,5);
        cache.put(9,10);
        System.out.println(cache.get(13));
        cache.put(2,19);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(5,25);
        System.out.println(cache.get(8));
        cache.put(9,22);
        cache.put(5,5);
        cache.put(1,30);
        System.out.println(cache.get(11));
        cache.put(9,12);
        System.out.println(cache.get(7));
        System.out.println(cache.get(5));
        System.out.println(cache.get(8));
        System.out.println(cache.get(9));
        cache.put(4,30);
        cache.put(9,3);
        System.out.println(cache.get(9));
        System.out.println(cache.get(10));
        System.out.println(cache.get(10));
        cache.put(6,14);
        cache.put(3,1);
        System.out.println(cache.get(3));
        cache.put(10,11);
        System.out.println(cache.get(8));
        cache.put(2,14);
        System.out.println(cache.get(1));
        System.out.println(cache.get(5));
        System.out.println(cache.get(4));
        cache.put(11,4);//
        cache.put(12,24);
        cache.put(5,18);
        System.out.println(cache.get(13));
        cache.put(7,23);
        System.out.println(cache.get(8));
        System.out.println(cache.get(12));
        cache.put(3,27);
        cache.put(2,12);
        System.out.println(cache.get(5));
        cache.put(2,9);
        cache.put(13,4);
        cache.put(8,18);
        cache.put(1,7);
        System.out.println(cache.get(6));
        cache.put(9,29);
        cache.put(8,21);
        System.out.println(cache.get(5));
        cache.put(6,30);
        cache.put(1,12);
        System.out.println(cache.get(10));
        cache.put(4,15);
        cache.put(7,22);
        cache.put(11,26);
        cache.put(8,17);
        cache.put(9,29);
        System.out.println(cache.get(5));
        cache.put(3,4);
        cache.put(11,30);
        System.out.println(cache.get(12));
        cache.put(4,29);
        System.out.println(cache.get(3));
        System.out.println(cache.get(9));
        System.out.println(cache.get(6));
        cache.put(3,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(10));
        cache.put(3,29);
        cache.put(10,28);
        cache.put(1,20);
        cache.put(11,13);
        System.out.println(cache.get(3));
        cache.put(3,12);
        cache.put(3,8);
        cache.put(10,9);
        cache.put(3,26);
        System.out.println(cache.get(8));
        System.out.println(cache.get(7));
        System.out.println(cache.get(5));
        cache.put(13,17);
        cache.put(2,27);
        cache.put(11,15);
        System.out.println(cache.get(12));
        cache.put(9,19);
        cache.put(2,15);
        cache.put(3,16);
        System.out.println(cache.get(1));
        cache.put(12,17);
        cache.put(9,1);
        cache.put(6,19);
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
        System.out.println(cache.get(5));
        cache.put(8,1);
        cache.put(11,7);
        cache.put(5,2);
        cache.put(9,28);
        System.out.println(cache.get(1));
        cache.put(2,2);
        cache.put(7,4);
        cache.put(4,22);
        cache.put(7,24);
        cache.put(9,26);
        cache.put(13,28);
        cache.put(11,26);
    }

    class LRUCache {
        Map<Integer, Node> map = new HashMap<>();
        Node head, tail;
        int size = 0, capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);
            updateNodes(node);

            return node.value;
        }

        private void updateNodes(Node node) {
            if (capacity == 1) {
                return;
            }

            if (tail.key == node.key) {
                return;
            }

            if (head.key == node.key) {
                head = head.next;
                head.prev = null;
            }

            if (node.prev != null) {
                node.prev.next = node.next;

                if (node.next != null) {
                    node.next.prev = node.prev;
                }
            }

            tail.next = node;

            node.prev = tail;
            node.next = null;

            tail = node;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;

                updateNodes(node);
                return;
            }

            node = createNode(key, value);
            map.put(key, node);

            if (size == 0) {
                head = tail = node;
                size = 1;
            } else if (size < capacity) {
                node.prev = tail;
                tail.next = node;

                tail = node;

                size++;
            } else {
                map.remove(head.key);

                if (capacity == 1) {
                    head = tail = node;
                } else {
                    head = head.next;
                    head.prev = null;

                    node.prev = tail;
                    tail.next = node;

                    tail = node;
                    tail.next = null;
                }
            }
        }

        private Node createNode(int key, int value) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            return newNode;
        }

        class Node {
            int key, value;
            Node next, prev;

            @Override
            public String toString() {
                return "Node{" +
                        "key=" + key +
                        ", value=" + value +
                        ", next=" + (next != null? next.key: null) +
                        ", prev=" + (prev != null? prev.key: null) +
                        '}';
            }
        }
    }



}

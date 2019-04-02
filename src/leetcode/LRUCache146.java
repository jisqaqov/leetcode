package leetcode;

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
        solution.test();
        solution.test2();
        solution.test3();
        solution.test4();
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
        cache.get(13);
        cache.put(2,19);
        cache.get(2);
        cache.get(3);
        cache.put(5,25);
        cache.get(8);
        cache.put(9,22);
        cache.put(5,5);
        cache.put(1,30);
        cache.get(11);
        cache.put(9,12);
        cache.get(7);
        cache.get(5);
        cache.get(8);
        cache.get(9);
        cache.put(4,30);
        cache.put(9,3);
        cache.get(9);
        cache.get(10);
        cache.get(10);
        cache.put(6,14);
        cache.put(3,1);
        cache.get(3);
        cache.put(10,11);
        cache.get(8);
        cache.put(2,14);
        cache.get(1);
        cache.get(5);
        cache.get(4);
        cache.put(11,4);//
        cache.put(12,24);
        cache.put(5,18);
        cache.get(13);
        cache.put(7,23);
        cache.get(8);
        cache.get(12);
        cache.put(3,27);
        cache.put(2,12);
        cache.get(5);
        cache.put(2,9);
        cache.put(13,4);
        cache.put(8,18);
        cache.put(1,7);
        cache.get(6);
        cache.put(9,29);
        cache.put(8,21);
        cache.get(5);
        cache.put(6,30);
        cache.put(1,12);
        cache.get(10);
        cache.put(4,15);
        cache.put(7,22);
        cache.put(11,26);
        cache.put(8,17);
        cache.put(9,29);
        cache.get(5);
        cache.put(3,4);
        cache.put(11,30);
        cache.get(12);
        cache.put(4,29);
        cache.get(3);
        cache.get(9);
        cache.get(6);
        cache.put(3,4);
        cache.get(1);
        cache.get(10);
        cache.put(3,29);
        cache.put(10,28);
        cache.put(1,20);
        cache.put(11,13);
        cache.get(3);
        cache.put(3,12);
        cache.put(3,8);
        cache.put(10,9);
        cache.put(3,26);
        cache.get(8);
        cache.get(7);
        cache.get(5);
        cache.put(13,17);
        cache.put(2,27);
        cache.put(11,15);
        cache.get(12);
        cache.put(9,19);
        cache.put(2,15);
        cache.put(3,16);
        cache.get(1);
        cache.put(12,17);
        cache.put(9,1);
        cache.put(6,19);
        cache.get(4);
        cache.get(5);
        cache.get(5);
        cache.put(8,1);
        cache.put(11,7);
        cache.put(5,2);
        cache.put(9,28);
        cache.get(1);
        cache.put(2,2);
        cache.put(7,4);
        cache.put(4,22);
        cache.put(7,24);
        cache.put(9,26);
        cache.put(13,28);
        cache.put(11,26);
    }

    class LRUCache {
        Node head, tail;
        Node[] list = new Node[100000];
        int size = 0, capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = list[hashIndex(key)];
            if (node == null) {
                return -1;
            }

            if (tail.key == key) {
                return node.value;
            }

            if (head.key == key) {
                Node oldHead = head;
                head = head.next;
                head.prev = null;
                tail.next = oldHead;
                oldHead.prev = tail;
                tail = oldHead;
                tail.next = null;
            } else {
                node.next.prev = node.prev;
                node.prev.next = node.next;
                tail.next = node;
                node.prev = tail;
                tail = node;
                tail.next = null;
            }

            return node.value;
        }

        public void put(int key, int value) {
            int hash = hashIndex(key);
            if (head == null) {
                head = createNode(key, value);
                list[hash] = head;

                tail = head;
                size = 1;

                return;
            }

            if (list[hash] == null) {
                Node newNode = createNode(key, value);

                if (size == capacity) {
                    list[head.hash] = null;

                    if (size > 1) {
                        head = head.next;
                        head.prev = null;

                        list[hash] = newNode;
                        tail.next = newNode;
                        newNode.prev = tail;
                        tail = newNode;
                    } else {
                        list[hash] = newNode;
                        head = tail = newNode;
                    }
                } else {
                    size++;

                    list[hash] = newNode;
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                }
            } else {
                Node oldHead = head;
                list[hash].value = value;

                if (head.key == key) {
                    if (size > 1) {
                        head = head.next;
                        tail.next = oldHead;
                        oldHead.prev = tail;
                        tail = oldHead;
                        tail.next = null;
                    }
                } else if (tail.key != key) {
                    Node node = list[hash];

                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                    tail.next = null;
                }
            }
        }

        private Node createNode(int key, int value) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            newNode.hash = hashIndex(key);
            return newNode;
        }

        private int hashIndex(int key) {
            return key % list.length;
        }

        class Node {
            int hash;
            int key, value;
            Node next, prev;

            @Override
            public String toString() {
                return "Node{" +
                        "hash=" + hash +
                        ", key=" + key +
                        ", value=" + value +
                        ", next=" + (next != null? next.key: null) +
                        ", prev=" + (prev != null? prev.key: null) +
                        '}';
            }
        }
    }



}

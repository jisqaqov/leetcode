package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 460. LFU Cache
 * algorithm: HashMap, LinkedList
 * time complexity: O(1)
 * space complexity: O(n)
 */
public class LFUCache460 {

    public static void main(String[] args) {
        LFUCache460 solution = new LFUCache460();
        solution.test5();
    }

    private void test5() {
        LFUCache cache = new LFUCache( 10);

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
        cache.put(11,4);
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

    class LFUCache {
        Map<Integer, Node> data = new HashMap<>();
        Map<Integer, Rate> rates = new HashMap<>();
        Node head;
        int capacity;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!data.containsKey(key)) {
                return -1;
            }

            Node node = data.get(key);
            updateNodes(node);

            return node.value;
        }

        private void updateNodes(Node node) {
            node.count++;

            if (head.key == node.key && head.next != null && node.count >= head.next.count) {
                head = head.next;
                head.prev = null;
            }

            Rate oldRate = rates.get(node.count - 1);

            if (rates.containsKey(node.count)) {
                Rate newRate = rates.get(node.count);

                newRate.size++;

                if (node.prev != null) {
                    node.prev.next = node.next;
                }

                if (node.next != null) {
                    node.next.prev = node.prev;
                }

                if (newRate.mru.next != null) {
                    newRate.mru.next.prev = node;
                }

                node.next = newRate.mru.next;

                newRate.mru.next = node;
                node.prev = newRate.mru;

                newRate.mru = node;
            } else {
                if (oldRate.mru.key != node.key) {
                    if (node.prev != null) {
                        node.prev.next = node.next;
                    }

                    if (node.next != null) {
                        node.next.prev = node.prev;
                    }

                    Node lru = oldRate.mru.next;
                    if (lru != null) {
                        node.next = lru;
                        lru.prev = node;
                    }

                    Node mru = oldRate.mru;

                    mru.next = node;
                    node.prev = mru;
                }

                rates.put(node.count, new Rate(node));
            }

            oldRate.size--;

            if (oldRate.size == 0) {
                rates.remove(node.count - 1);
            } else if (oldRate.mru.key == node.key) {
                oldRate.mru = oldRate.mru.prev;
            }
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }

            Node node = data.get(key);

            if (node != null) {
                node.value = value;

                updateNodes(node);
                return;
            }

            node = createNode(key, value);

            if (data.size() == 0) {
                head = node;
                rates.put(1, new Rate(node));
            } else {
                if (data.size() == capacity) {
                    evict();

                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                }

                if (rates.containsKey(1)) {
                    Rate firstRate = rates.get(1);
                    Node mru = firstRate.mru;

                    if (mru.next != null) {
                        mru.next.prev = node;
                    }

                    node.next = mru.next;

                    mru.next = node;
                    node.prev = mru;

                    firstRate.mru = node;
                    firstRate.size++;
                } else {
                    if (head != null) {
                        head.prev = node;
                        node.next = head;
                    }

                    head = node;
                    rates.put(1, new Rate(node));
                }
            }

            data.put(key, node);
        }

        private void evict() {
            data.remove(head.key);

            rates.get(head.count).size--;
            if (rates.get(head.count).size == 0) {
                rates.remove(head.count);
            }
        }

        private Node createNode(int key, int value) {
            Node node = new Node();
            node.key = key;
            node.value = value;
            node.count = 1;
            return node;
        }

        class Node {
            int key, value;
            Node next, prev;
            int count = 0;

            @Override
            public String toString() {
                return "Node{" +
                        "key=" + key +
                        ", value=" + value +
                        ", count=" + count +
                        ", next=" + (next != null? next.key: null) +
                        ", prev=" + (prev != null? prev.key: null) +
                        '}';
            }
        }

        class Rate {
            int size;
            Node mru;

            Rate(Node node) {
                this.size = 1;
                this.mru = node;
            }

            @Override
            public String toString() {
                return "Rate{" +
                        "size=" + size +
                        ", mru=" + (mru != null? mru.key: null) +
                        '}';
            }
        }

    }

}

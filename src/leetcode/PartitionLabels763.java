package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jandos Iskakov
 * problem: 763. Partition Labels
 * algorithm: Two Pointers, Greedy
 * time complexity:
 * space complexity:
 */
public class PartitionLabels763 {

    public static void main(String[] args) {
        PartitionLabels763 solution = new PartitionLabels763();
        solution.test();
    }

    public void test() {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String s) {
        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            ListNode node = head;

            while (node != null) {
                if (node.value.contains(s, ch)) {
                    break;
                }

                node = node.next;
            }

            if (node == null) {
                if (head == null) {
                    head = new ListNode(new Info(i));
                    tail = head;
                } else {
                    ListNode newNode = new ListNode(new Info(i));
                    tail.next = newNode;
                    tail = newNode;
                }
            } else {
                node.value.endIndex = i;
                node.next = null;
                tail = node;
            }
        }

        List<Integer> solution = new ArrayList<>();

        ListNode node = head;

        while (node != null) {
            solution.add(node.value.endIndex - node.value.beginIndex + 1);
            node = node.next;
        }

        return solution;
    }

    private static class ListNode {
        Info value;
        ListNode next;

        public ListNode(Info value) {
            this.value = value;
        }
    }

    private static class Info {
        int beginIndex, endIndex;

        Info(int index) {
            this.beginIndex = index;
            this.endIndex = index;
        }

        public boolean contains(String s, char ch) {
            for (int i = beginIndex; i <= endIndex; i++) {
                if (s.charAt(i) == ch) {
                    return true;
                }
            }

            return false;
        }
    }

}

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
        LinkedList<Info> parts = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int t = 0;

            for (Info info : parts) {
                if (info.set.contains(ch)) {
                    break;
                }

                t++;
            }

            if (t == parts.size()) {
                parts.add(new Info(ch));
            } else {
                Info info = new Info(ch);

                int k = parts.size() - 1;

                while (k >= t) {
                    Info tail = parts.removeLast();

                    info.set.addAll(tail.set);
                    info.len += tail.len;

                    k--;
                }

                parts.add(info);
            }
        }

        return parts.stream()
                .map(info -> info.len)
                .collect(Collectors.toList());
    }

    private static class Info {
        Set<Character> set = new HashSet<>();
        int len = 0;

        Info(char ch) {
            this.set.add(ch);
            this.len = 1;
        }
    }

}

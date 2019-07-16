package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jandos Iskakov
 * problem: 358. Rearrange String k Distance Apart
 * algorithm: Hash Table, Heap, Gready
 * time complexity: O(xxx)
 * space complexity: O(xx)
 */
public class RearrangeStringKDistanceApart358 {

    public static void main(String[] args) {
        RearrangeStringKDistanceApart358 solution = new RearrangeStringKDistanceApart358();

        System.out.println(solution.rearrangeString("aabbccdd", 3));
        System.out.println(solution.rearrangeString("a", 0));
        System.out.println(solution.rearrangeString("aabbcc", 3));
        System.out.println(solution.rearrangeString("aaabc", 3));
        System.out.println(solution.rearrangeString("aaadbbcc", 2));
    }

    public String rearrangeString(String s, int k) {
        if (k == 0) {
            return s;
        }

        Map<Character, Info> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (counter.containsKey(ch)) {
                counter.get(ch).number++;
            } else {
                counter.put(ch, new Info(ch, 1));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (sb.length() < s.length()) {
            PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.number));

            // get top k frequent items
            for (Character ch : counter.keySet()) {
                if (pq.size() < k) {
                    pq.add(counter.get(ch));
                } else if (pq.peek().number < counter.get(ch).number) {
                    pq.poll();
                    pq.add(counter.get(ch));
                }
            }

            // check condition whether we can rearrange string
            // if we have un sufficient items then return empty string
            if (pq.size() < k) {
                boolean canRearrange = counter.values()
                        .stream()
                        .anyMatch(info -> info.number > 1);

                if (canRearrange) {
                    return "";
                }
            }

            // sort by frequency to get most frequent ones first
            List<Info> sortedList = Arrays.stream(pq.toArray())
                    .map(o -> (Info) o)
                    .sorted((info1, info2) -> info1.number == info2.number? info1.index - info2.index:
                            info2.number - info1.number)
                    .collect(Collectors.toList());

            for (Info info : sortedList) {
                sb.append(info.ch);

                info.number--;
                info.index = sb.length() - 1;

                if (info.number == 0) {
                    counter.remove(info.ch);
                }
            }
        }

        return sb.toString();
    }

    private static class Info {
        Character ch;
        int number;
        int index = 0;

        Info(Character ch, int number) {
            this.ch = ch;
            this.number = number;
        }
    }

}

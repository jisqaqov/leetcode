package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author Jandos Iskakov
 * problem: 358. Rearrange String k Distance Apart
 * algorithm: Hash Table, Heap, Gready
 * time complexity: O(nlog(n))
 * space complexity: O(n)
 */
public class RearrangeStringKDistanceApart358 {
  private static final String NO_ANSWER = "";

  public static void main(String[] args) {
    RearrangeStringKDistanceApart358 solution = new RearrangeStringKDistanceApart358();
    solution.test();
  }

  private void test() {
    System.out.println(rearrangeString("aabbccdd", 3));
    System.out.println(rearrangeString("a", 0));
    System.out.println(rearrangeString("aabbcc", 3));
    System.out.println(rearrangeString("aaabc", 3));
    System.out.println(rearrangeString("aaadbbcc", 2));
  }

  public String rearrangeString(String s, int k) {
    PriorityQueue<Stat> pq = new PriorityQueue<>(
        (stat1, stat2) -> stat2.number - stat1.number);

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    for (Character ch : map.keySet()) {
      pq.add(new Stat(ch, -1, map.get(ch)));
    }

    Queue<Stat> queue = new LinkedList<>();

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      while (!queue.isEmpty() && i - queue.peek().index >= k) {
        pq.add(queue.poll());
      }

      if (pq.isEmpty()) {
        return NO_ANSWER;
      }

      Stat stat = pq.poll();

      sb.append(stat.ch);

      stat.number--;
      if (stat.number > 0) {
        stat.index = i;
        queue.add(stat);
      }
    }

    return sb.toString();
  }

  private static class Stat {

    char ch;
    int index;
    int number;

    Stat(char ch, int index, int number) {
      this.ch = ch;
      this.index = index;
      this.number = number;
    }
  }

  private static class OldApproach {

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
            .sorted((info1, info2) -> info1.number == info2.number ? info1.index - info2.index :
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

}

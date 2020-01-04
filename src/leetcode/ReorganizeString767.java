package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 767. Reorganize String
 * algorithm: Heap, Queue, Hash Table
 * time complexity: O(nlogn)
 * space complexity: O(n)
 */
@SuppressWarnings("DuplicatedCode")
public class ReorganizeString767 {

  public static void main(String[] args) {
    ReorganizeString767 problem = new ReorganizeString767();
    problem.test();
  }

  private void test() {
    System.out.println(reorganizeString("aab"));
    System.out.println(reorganizeString("aaab"));
    System.out.println(reorganizeString("vvvlo"));
  }

  public String reorganizeString(String s) {
    PriorityQueue<Stat> pq =
      new PriorityQueue<>((stat1, stat2) -> stat2.number - stat1.number);

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    for (Character ch : map.keySet()) {
      pq.add(new Stat(ch, -1, map.get(ch)));
    }

    Queue<Stat> queue = new LinkedList<>();

    char[] output = new char[s.length()];

    for (int i = 0; i < s.length(); i++) {
      if (!queue.isEmpty() && i - queue.peek().index >= 2) {
        pq.add(queue.poll());
      }

      if (pq.isEmpty()) {
        return "";
      }

      Stat stat = pq.poll();

      output[i] = stat.ch;

      stat.number--;

      if (stat.number > 0) {
        stat.index = i;
        queue.add(stat);
      }
    }

    return new String(output);
  }

  private static class Stat {
    private char ch;
    private int index;
    private int number;

    Stat(char ch, int index, int number) {
      this.ch = ch;
      this.index = index;
      this.number = number;
    }
  }

}

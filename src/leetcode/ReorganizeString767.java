package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString767 {

  public static void main(String[] args) {
    ReorganizeString767 problem = new ReorganizeString767();
    problem.test();
  }

  private void test() {
    System.out.println(reorganizeString("aab"));
    System.out.println(reorganizeString("aaab"));
  }

  public String reorganizeString(String s) {
    final int start = -s.length();
    final int k = 2;

    PriorityQueue<Info> pq = new PriorityQueue<>((info1, info2) -> {
      if (info1.number == info2.number) {
        return info1.index - info2.index;
      }

      if (info1.index == start && info2.index == start) {
        return info2.number - info1.number;
      }

      return info1.index - info2.index;
    });

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    for (Character ch : map.keySet()) {
      pq.add(new Info(ch, start, map.get(ch)));
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      Info currNode = pq.poll();
      if (i - currNode.index < k) {
        return "";
      }

      currNode.number--;

      if (currNode.number > 0) {
        currNode.index = i;
        pq.add(currNode);
      }

      sb.append(currNode.ch);
    }

    return sb.toString();
  }

  private static class Info {
    char ch;
    int index = -1;
    int number = 0;

    public Info(char ch, int index, int number) {
      this.ch = ch;
      this.index = index;
      this.number = number;
    }
  }

}

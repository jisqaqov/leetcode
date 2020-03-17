package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 759. Employee Free Time
 * algorithm: Heap
 * time complexity: O(nlog(n))
 * space complexity: O(nlog(n))
 * Runtime: 11 ms, faster than 49.71% of Java online submissions
 * Memory Usage: 43.1 MB, less than 100.00% of Java online submissions
 */
public class EmployeeFreeTime759 {

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> list = new ArrayList<>();
    for (List<Interval> sch : schedule) {
      list.addAll(sch);
    }

    list.sort(Comparator.comparingInt(i2 -> i2.start));

    Interval last = null;
    PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(i1 -> i1.end));

    List<Interval> output = new ArrayList<>();

    for (int i = 0; i < list.size(); i++) {
      Interval interval = list.get(i);

      while (!pq.isEmpty() && pq.peek().end < interval.start) {
        last = pq.poll();
      }

      if (pq.isEmpty() && last != null) {
        output.add(new Interval(last.end, interval.start));
      }

      pq.add(interval);
    }

    return output;
  }

  /**
   * Definition for an Interval
   */
  private class Interval {

    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

}

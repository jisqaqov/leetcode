package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Jandos Iskakov
 * problem: 759. Employee Free Time
 * algorithm: Heap
 * time complexity: O(nlog(n))
 * space complexity: O(nlog(n))
 * Runtime: 9 ms, faster than 79.83% of Java online submissions
 * Memory Usage: 42 MB, less than 100.00% of Java online submissions
 */
public class EmployeeFreeTime759 {

  public static void main(String[] args) {
    EmployeeFreeTime759 problem = new EmployeeFreeTime759();
    problem.test();
  }

  private void test() {
    System.out.println(employeeFreeTime(
      Arrays.asList(
        Arrays.asList(new Interval(1, 2), new Interval(5, 6)),
        Arrays.asList(new Interval(2, 3), new Interval(4, 10))
      )
    ));
  }

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    if (schedule.isEmpty()) {
      return Collections.emptyList();
    }

    List<Interval> sorted = new ArrayList<>();
    for (List<Interval> sch : schedule) {
      sorted.addAll(sch);
    }

    sorted.sort((i1, i2) -> i1.start - i2.start);

    Interval current = new Interval(sorted.get(0).start, sorted.get(0).end);

    List<Interval> merged = new ArrayList<>();
    merged.add(current);

    for (int i = 1; i < sorted.size(); i++) {
      Interval interval = sorted.get(i);

      if (interval.start < current.end) {
        current.end = Math.max(interval.end, current.end);
      } else {
        current = new Interval(sorted.get(i).start, sorted.get(i).end);
        merged.add(current);
      }
    }

    List<Interval> output = new ArrayList<>();

    for (int i = 1; i < merged.size(); i++) {
      Interval curr = merged.get(i);
      Interval prev = merged.get(i - 1);

      if (curr.end > prev.start && prev.end < curr.start) {
        output.add(new Interval(prev.end, curr.start));
      }
    }

    return output;
  }

  private class V2 {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
      List<Interval> list = new ArrayList<>();
      for (List<Interval> sch : schedule) {
        list.addAll(sch);
      }

      list.sort((i1, i2) -> i1.start - i2.start);

      PriorityQueue<Interval> pq = new PriorityQueue<>((i1, i2) -> i1.end - i2.end);

      List<Interval> output = new ArrayList<>();

      for (int i = 0; i < list.size(); i++) {
        Interval interval = list.get(i);

        int last = -1;
        while (!pq.isEmpty() && pq.peek().end < interval.start) {
          last = pq.poll().end;
        }

        if (pq.isEmpty() && last != -1) {
          output.add(new Interval(last, interval.start));
        }

        pq.add(interval);
      }

      return output;
    }
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

    @Override
    public String toString() {
      return "Interval{" +
        "start=" + start +
        ", end=" + end +
        '}';
    }
  }

}

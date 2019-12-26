package prep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    char[] tasks = {'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'D'};
    //System.out.println(leastInterval(tasks, 6));//29
    System.out.println(leastInterval(tasks, 2));//13
  }

  public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> freq = new HashMap<>();
    for (char task : tasks) {
      freq.put(task, freq.getOrDefault(task, 0) + 1);
    }

    int t = 0;

    Task[] list = new Task[freq.size()];
    for (char task : freq.keySet()) {
      list[t++] = new Task(task, freq.get(task));
    }

    int intervals = 0;

    Arrays.sort(list, (t1, t2) -> t2.count - t1.count);

    int index = 0;
    int start = 0;
    int end = list.length - 1;
    int count = tasks.length;

    while (count > 0) {
      count--;
      intervals++;

      if (list[index].pos > 0 && intervals - list[index].pos - 1 < n) {
        intervals += n - (intervals - list[index].pos - 1);
      }

      list[index].count--;
      list[index].pos = intervals;

      if (list[end].count == 0) {
        end--;
      }

      if (list[start].count == 0) {
        start++;
      }

      if (intervals - list[start].pos >= n || index == end) {
        index = start;
      } else {
        index++;
      }
    }

    return intervals;
  }

  private static class Task {

    private int pos = -1;
    private char id;
    private int count;

    public Task(char id, int count) {
      this.id = id;
      this.count = count;
    }
  }

}
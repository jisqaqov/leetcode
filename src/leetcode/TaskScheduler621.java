package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 621. Task Scheduler
 * algorithm: Heap, Greedy, Queue, Hash Table
 * time complexity: O(klogk)//k - number of tasks
 * space complexity: O(K)
 * Runtime: 50 ms, faster than 28.56% of Java online submissions for Task Scheduler.
 * Memory Usage: 39.1 MB, less than 85.29% of Java online submissions for Task Scheduler.
 */
public class TaskScheduler621 {

  public static void main(String[] args) {
    TaskScheduler621 problem = new TaskScheduler621();
    problem.test();
  }

  private void test() {
    V2 v2 = new V2();

    char[] tc1a = {'A', 'A', 'A', 'B', 'B', 'B'};
    System.out.println(leastInterval(tc1a, 2));
    System.out.println(v2.leastInterval(tc1a, 2));
  }

  public int leastInterval(char[] tasks, int n) {
    Map<Character, Task> mapOfTasks = new HashMap<>();

    for (char taskId : tasks) {
      mapOfTasks.putIfAbsent(taskId, new Task(taskId));
      mapOfTasks.get(taskId).count++;
    }

    PriorityQueue<Task> pq = new PriorityQueue<>(
      (t1, t2) -> t2.count - t1.count);

    pq.addAll(mapOfTasks.values());

    int index = 0;

    Queue<Task> queue = new LinkedList<>();

    while (!pq.isEmpty() || !queue.isEmpty()) {
      index++;

      while (!queue.isEmpty() && index - queue.peek().index > n) {
        pq.add(queue.poll());
      }

      while (pq.isEmpty()) {
        index++;

        while (!queue.isEmpty() && index - queue.peek().index > n) {
          pq.add(queue.poll());
        }
      }

      Task task = pq.poll();
      task.count--;
      task.index = index;

      if (task.count > 0) {
        queue.add(task);
      }
    }

    return index;
  }

  private static class V2 {

    /**
     * time complexity: O(|tasks|)
     * space complexity: O(1)
     * Runtime: 19 ms, faster than 46.91% of Java online submissions for Task Scheduler.
     * Memory Usage: 37.5 MB, less than 94.12% of Java online submissions for Task Scheduler.
     */
    public int leastInterval(char[] tasks, int n) {
      Map<Character, Integer> freqs = new HashMap<>();

      for (char task : tasks) {
        freqs.put(task, freqs.getOrDefault(task, 0) + 1);
      }

      int maxFreq = 0;
      int maxNum = 0;

      for (int freq : freqs.values()) {
        if (freq > maxFreq) {
          maxFreq = freq;
          maxNum = 1;
        } else if (freq == maxFreq) {
          maxNum++;
        }
      }

      int parts = maxFreq - 1;
      int emptySlots = parts * (n - (maxNum - 1));
      int availableTasks = tasks.length - maxFreq * maxNum;
      int idles = Math.max(emptySlots - availableTasks, 0);

      return idles + tasks.length;
    }
  }

  private static class Task {

    char ch;
    int count = 0;
    int index = -1;

    Task(char ch) {
      this.ch = ch;
    }
  }

}

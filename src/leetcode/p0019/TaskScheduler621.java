package leetcode.p0019;

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
    char[] tc1a = {'A', 'A', 'A', 'B', 'B', 'B'};
    char[] tc2a = {'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'D'};

    System.out.println(leastInterval(tc1a, 2));
    System.out.println(leastInterval(tc2a, 2));
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

    int intervals = 0;

    Queue<Task> queue = new LinkedList<>();

    while (!pq.isEmpty() || !queue.isEmpty()) {
      intervals++;

      while (!queue.isEmpty() && intervals - queue.peek().index > n) {
        pq.add(queue.poll());
      }

      while (pq.isEmpty()) {
        intervals++;

        while (!queue.isEmpty() && intervals - queue.peek().index > n) {
          pq.add(queue.poll());
        }
      }

      Task task = pq.poll();
      task.count--;
      task.index = intervals;

      if (task.count > 0) {
        queue.add(task);
      }
    }

    return intervals;
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

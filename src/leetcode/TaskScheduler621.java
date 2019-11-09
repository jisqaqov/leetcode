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
    char[] tc1a = {'A', 'A', 'A', 'B', 'B', 'B'};
    System.out.println(leastInterval(tc1a, 2));
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

    int index = 1;

    Queue<Task> queue = new LinkedList<>();

    while (!pq.isEmpty() || !queue.isEmpty()) {
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

      index++;
    }

    return index - 1;
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

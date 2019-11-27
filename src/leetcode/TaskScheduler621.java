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
    problem.interview();
  }

  private void test() {
    V2 v2 = new V2();

    char[] tc1a = {'A', 'A', 'A', 'B', 'B', 'B'};
    System.out.println(leastInterval(tc1a, 2));
    System.out.println(v2.leastInterval(tc1a, 2));
  }

  private void interview() {
    System.out.println("facebook interview:");

    FacebookInterview interview = new FacebookInterview();

    int[] tc1a = {1, 1, 2, 1};
    System.out.println(interview.totalTime(tc1a, 2));//7

    int[] tc2a = {1, 1, 2, 1, 2, 2, 1, 1};
    System.out.println(interview.totalTime(tc2a, 2));//15

    int[] tc3a = {1,2,1,2};
    System.out.println(interview.totalTime(tc3a, 2));//5
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
      int maxLen = 0;
      int maxNum = 0;

      Map<Character, Integer> map = new HashMap<>();
      for (char task : tasks) {
        map.put(task, map.getOrDefault(task, 0) + 1);

        if (map.get(task) > maxNum) {
          maxNum = map.get(task);
          maxLen = 1;
        } else if (map.get(task) == maxNum) {
          maxLen++;
        }
      }

      int freeTasks = (maxNum - 1) * (n - (maxLen - 1));
      int busyTasks = tasks.length - maxLen * maxNum;
      int idles = Math.max(freeTasks - busyTasks, 0);

      return tasks.length + idles;
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

  /**
   * You're given a list of tasks, with number denoted different type of
   * tasks, and there'll be interval between tasks with tasks of same id.
   * Return total time for executing this task list.
   *
   * Example:
   *
   * Input: tasks = [1, 1, 2, 1], interval = 2
   * Output: 7
   * Explanation:
   * It's executed as 1 . . 1 2 . 1, so the total time is 7.
   */
  private static class FacebookInterview {
    public int totalTime(int[] tasks, int n) {
      int time = 0;

      Map<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < tasks.length; i++) {
        int idle = 0;

        if (map.containsKey(tasks[i])) {
          int len = time - map.get(tasks[i]);
          idle = Math.max(n - len, 0);
        }

        time += (idle + 1);
        map.put(tasks[i], time);
      }

      return time;
    }
  }

}

package facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
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
 *
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class TaskScheduler {

  public static void main(String[] args) {
    TaskScheduler problem = new TaskScheduler();
    problem.test();
  }

  private void test() {
    int[] tc1a = {1, 1, 2, 1};
    System.out.println(totalTime(tc1a, 2));//7

    int[] tc2a = {1, 1, 2, 1, 2, 2, 1, 1};
    System.out.println(totalTime(tc2a, 2));//15

    int[] tc3a = {1,2,1,2};
    System.out.println(totalTime(tc3a, 2));//5
  }

  public int totalTime(int[] tasks, int n) {
    int time = 0;

    Map<Integer, Integer> map = new HashMap<>();

    for (int task : tasks) {
      int idle = 0;

      if (map.containsKey(task)) {
        int len = time - map.get(task);
        idle = Math.max(n - len, 0);
      }

      time += (idle + 1);
      map.put(task, time);
    }

    return time;
  }

}

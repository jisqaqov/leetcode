package prep;

import java.util.HashMap;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    char[] tc1a = {'A','A','A','B','B','B'};
    System.out.println(leastInterval(tc1a, 2));
  }

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
    int intervals = tasks.length + idles;

    return intervals;
  }



}

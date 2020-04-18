package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 752. Open the Lock
 * algorithm: BFS
 * time complexity:
 * space complexity:
 * Runtime: 63 ms, faster than 82.33% of Java online submissions
 * Memory Usage: 42.6 MB, less than 84.21% of Java online submissions
 */
public class OpenTheLock752 {

  public static void main(String[] args) {
    OpenTheLock752 problem = new OpenTheLock752();
    problem.test();
  }

  private void test() {
    System.out.println(openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    System.out.println(openLock(new String[]{"8888"}, "0009"));
    System.out.println(openLock(new String[]{"8887", "8889", "8878", "8898", "8788",
      "8988", "7888", "9888"}, "8888"));
    System.out.println(openLock(new String[]{"0000"}, "8888"));
  }

  public int openLock(String[] deadends, String target) {
    Set<String> setOfDeadends = new HashSet<>(Arrays.asList(deadends));

    final String startLock = "0000";
    if (setOfDeadends.contains(startLock)) {
      return -1;
    }

    Set<String> used = new HashSet<>();
    used.add(startLock);

    Queue<String> queue = new LinkedList<>();
    queue.add(startLock);

    for (int t = 0; !queue.isEmpty(); t++) {
      for (int sz = queue.size(); sz > 0; sz--) {
        String node = queue.poll();

        if (node.equals(target)) {
          return t;
        }

        char[] chars = node.toCharArray();

        for (int i = 0; i < chars.length; i++) {
          int slot = chars[i] - '0';

          int slot1 = slot == 9? 0: slot + 1;
          chars[i] = (char) (slot1 + '0');

          String candidate1 = String.valueOf(chars);
          if (!used.contains(candidate1) && !setOfDeadends.contains(candidate1)) {
            used.add(candidate1);
            queue.add(candidate1);
          }

          int slot2 = slot == 0? 9: slot - 1;
          chars[i] = (char) (slot2 + '0');

          String candidate2 = String.valueOf(chars);
          if (!used.contains(candidate2) && !setOfDeadends.contains(candidate2)) {
            used.add(candidate2);
            queue.add(candidate2);
          }

          chars[i] = node.charAt(i);
        }
      }
    }

    return -1;
  }

}
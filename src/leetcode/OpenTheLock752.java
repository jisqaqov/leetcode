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
 * Runtime: 7 ms, faster than 99.82% of Java online submissions
 * Memory Usage: 39.4 MB, less than 94.74% of Java online submissions
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
    Set<String> used = new HashSet<>();

    Set<String> setOfDeadends = new HashSet<>(Arrays.asList(deadends));

    final String startLock = "0000";

    if (setOfDeadends.contains(startLock)) {
      return -1;
    }

    used.add(startLock);

    Queue<String> queue = new LinkedList<>();
    queue.add(startLock);

    for (int t = 0; !queue.isEmpty(); t++) {

      for (int sz = queue.size(); sz > 0; sz--) {
        String node = queue.poll();

        if (node.equals(target)) {
          return t;
        }

        List<String> candidates = findCandidates(node, target, setOfDeadends, used);
        if (candidates.isEmpty()) {
          char[] chars = node.toCharArray();

          for (int i = 0; i < node.length(); i++) {
            if (node.charAt(i) == target.charAt(i)) {
              int srcSlot = chars[i] - '0';

              int slot1 = srcSlot == 9 ? 0 : srcSlot + 1;
              chars[i] = (char) (slot1 + '0');

              String candidate = String.valueOf(chars);
              if (!setOfDeadends.contains(candidate) && !used.contains(candidate)) {
                queue.add(candidate);
                used.add(candidate);
              }

              int slot2 = srcSlot == 0 ? 9 : srcSlot - 1;
              chars[i] = (char) (slot2 + '0');

              candidate = String.valueOf(chars);
              if (!setOfDeadends.contains(candidate) && !used.contains(candidate)) {
                queue.add(candidate);
                used.add(candidate);
              }

              chars[i] = node.charAt(i);
            }
          }
        } else {
          used.addAll(candidates);
          queue.addAll(candidates);
        }


      }

    }

    return -1;
  }

  private List<String> findCandidates(String node, String target, Set<String> deadends,
    Set<String> used) {
    List<String> list = new ArrayList<>();

    char[] chars = node.toCharArray();

    for (int i = 0; i < node.length(); i++) {
      if (node.charAt(i) != target.charAt(i)) {
        int srcSlot = node.charAt(i) - '0';
        int trgSlot = target.charAt(i) - '0';

        int clockwise = 0, anticlockwise = 0;
        if (srcSlot > trgSlot) {
          clockwise = 10 - srcSlot + trgSlot;
          anticlockwise = srcSlot - trgSlot;
        } else {
          clockwise = trgSlot - srcSlot;
          anticlockwise = 10 - trgSlot + srcSlot;
        }

        int slot = 0;
        if (clockwise < anticlockwise) {
          slot = srcSlot == 9 ? 0 : srcSlot + 1;
        } else {
          slot = srcSlot == 0 ? 9 : srcSlot - 1;
        }

        chars[i] = (char) (slot + '0');

        String candidate = String.valueOf(chars);
        if (!deadends.contains(candidate) && !used.contains(candidate)) {
          list.add(candidate);
        }

        chars[i] = node.charAt(i);
      }
    }

    return list;
  }

}
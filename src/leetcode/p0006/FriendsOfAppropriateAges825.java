package leetcode.p0006;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 825. Friends Of Appropriate Ages
 * algorithm: Array
 * Runtime: 2 ms, faster than 98.27% of Java online submissions
 * Memory Usage: 41.5 MB, less than 20.00% of Java online submissions
 */
public class FriendsOfAppropriateAges825 {

  public static void main(String[] args) {
    FriendsOfAppropriateAges825 problem = new FriendsOfAppropriateAges825();
    problem.test();
  }

  private void test() {
    System.out.println(numFriendRequests(new int[]{16, 16}));//2
    System.out.println(numFriendRequests(new int[]{16, 17, 18}));//2
    System.out.println(numFriendRequests(new int[]{20, 30, 100, 110, 120}));//3
    System.out.println(numFriendRequests(
      new int[]{73, 106, 39, 6, 26, 15, 30, 100, 71, 35, 46, 112, 6, 60, 110}));//29
  }

  /**
   * time complexity: O(120*120 + N)
   * space complexity: O(120)
   */
  public int numFriendRequests(int[] ages) {
    int[] freq = new int[121];
    for (int age : ages) {
      freq[age]++;
    }

    int req = 0;

    for (int a = 1; a <= 120; a++) {
      for (int b = 1; b <= 120; b++) {
        if (b > a || b <= 0.5 * a + 7) {
          continue;
        }

        if (a == b) {
          req += freq[a] * (freq[a] - 1);
        } else {
          req += freq[a] * freq[b];
        }
      }
    }

    return req;
  }

  /**
   * time complexity: O(120 + N)
   * space complexity: O(120)
   */
  private static class V2 {
    public int numFriendRequests(int[] ages) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int age : ages) {
        map.put(age, map.getOrDefault(age, 0) + 1);
      }

      int req = 0;
      for (int a : map.keySet()) {
        for (int b : map.keySet()) {
          if (b > a || b <= 0.5 * a + 7) {
            continue;
          }

          if (a == b) {
            req += map.get(a) * (map.get(a) - 1);
          } else {
            req += map.get(a) * map.get(b);
          }
        }
      }

      return req;
    }
  }

}

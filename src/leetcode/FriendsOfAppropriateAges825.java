package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 825. Friends Of Appropriate Ages
 * algorithm: Array
 * time complexity: O(120)
 * space complexity: O(120)
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

  public int numFriendRequests(int[] ages) {
    int[] freq = new int[121];
    for (int age : ages) {
      freq[age]++;
    }

    int[] prefix = new int[121];

    prefix[120] = 0;
    for (int age = 119; age >= 1; age--) {
      prefix[age] = freq[age + 1] + prefix[age + 1];
    }

    int req = 0;
    for (int age = 120; age >= 1; age--) {
      if (freq[age] == 0) {
        continue;
      }

      int temp = 0;

      int half = age / 2 + 7;
      if (half < age) {
        // requests to people older than > age[a] * 0.5 + 7
        temp += freq[age] * (prefix[half] - prefix[age - 1]);

        // request to each other M * (M - 1)
        temp += freq[age] * (freq[age] - 1);
      }

      req += temp;
    }

    return req;
  }

  private static class V2 {
    public int numFriendRequests(int[] ages) {
      Map<Integer, Integer> freq = new HashMap<>();
      for (int age : ages) {
        freq.put(age, freq.getOrDefault(age, 0) + 1);
      }

      int[] prefix = new int[121];

      prefix[120] = 0;
      for (int age = 119; age >= 1; age--) {
        prefix[age] = freq.getOrDefault(age + 1, 0) + prefix[age + 1];
      }

      int req = 0;
      for (int age : freq.keySet()) {
        int half = age / 2 + 7;
        if (half < age) {
          // requests to people older than > age[a] * 0.5 + 7
          req += freq.get(age) * (prefix[half] - prefix[age - 1]);

          // request to each other M * (M - 1)
          req += freq.get(age) * (freq.get(age) - 1);
        }
      }

      return req;
    }
  }

}

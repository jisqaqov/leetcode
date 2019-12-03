package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 91. Decode Ways
 * algorithm: DP
 * time complexity: O(N^2)
 * space complexity: O(N^2)
 * Runtime: 5 ms, faster than 12.84% of Java online submissions for Decode Ways.
 * Memory Usage: 40.7 MB, less than 5.66% of Java online submissions for Decode Ways.
 */
public class DecodeWays91 {

  public static void main(String[] args) {
    DecodeWays91 problem = new DecodeWays91();
    problem.test();
  }

  private void test() {
    System.out.println(numDecodings("12"));//2
    System.out.println(numDecodings("226"));//3
  }

  public int numDecodings(String s) {
    return numDecodings(s, new HashMap<>());
  }

  public int numDecodings(String s, Map<String, Integer> map) {
    if (map.containsKey(s)) {
      return map.get(s);
    }

    int count = 0;

    for (int i = 0; i < Math.min(s.length(), 2); i++) {
      String prefix = s.substring(0, i + 1);
      int num = Integer.parseInt(prefix);
      if (num < 1 || num > 26) {
        break;
      }

      String suffix = s.substring(i + 1);
      if (suffix.isEmpty()) {
        count += 1;
      } else {
        int k = numDecodings(suffix, map);
        if (k > 0) {
          count += k;
        }
      }
    }

    map.put(s, count);

    return map.get(s);
  }

}

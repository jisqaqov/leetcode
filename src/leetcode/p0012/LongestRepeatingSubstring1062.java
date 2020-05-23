package leetcode.p0012;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 1062. Longest Repeating Substring
 * algorithm: Binary Search, String
 * time complexity: O(n^2log(n))
 * space complexity: O(n^2)
 * Runtime: 8 ms, faster than 62.81% of Java online submissions
 * Memory Usage: 40.2 MB, less than 100.00% of Java online submissions
 */
public class LongestRepeatingSubstring1062 {

  public static void main(String[] args) {
    LongestRepeatingSubstring1062 problem = new LongestRepeatingSubstring1062();
    problem.test();
  }

  private void test() {
    System.out.println(longestRepeatingSubstring("aabcaabdaab"));//3
    System.out.println(longestRepeatingSubstring("aaaaa"));//4
  }

  public int longestRepeatingSubstring(String s) {
    int low = 2;
    int high = s.length() - 1;

    int maxLen = 0;

    while (low <= high) {
      int len = low + (high - low) / 2;

      if (hasDuplicate(s, len)) {
        maxLen = len;
        low = len + 1;
      } else {
        high = len - 1;
      }
    }

    return maxLen;
  }

  private boolean hasDuplicate(String s, int len) {
    Set<String> used = new HashSet<>();

    for (int i = 0; i <= s.length() - len; i++) {
      String substr = s.substring(i, i + len);
      if (used.contains(substr)) {
        return true;
      }

      used.add(substr);
    }

    return false;
  }

}
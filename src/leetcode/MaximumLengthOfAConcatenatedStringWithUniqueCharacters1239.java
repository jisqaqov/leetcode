package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 1239. Maximum Length of a Concatenated String with Unique Characters
 * algorithm: Backtracking
 * time complexity: O(2^N)
 * space complexity: O(N)
 * Runtime: 25 ms, faster than 54.81% of Java online submissions
 * Memory Usage: 41.1 MB, less than 100.00% of Java online submissions
 */
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters1239 {

  public static void main(String[] args) {
    MaximumLengthOfAConcatenatedStringWithUniqueCharacters1239 problem = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters1239();
    problem.test();
  }

  private void test() {
    System.out.println(maxLength(Arrays.asList("un", "iq", "ue")));//4
    System.out.println(maxLength(Arrays.asList("cha", "r", "act", "ers")));//6
    System.out.println(maxLength(Collections.singletonList("abcdefghijklmnopqrstuvwxyz")));//26
    System.out.println(maxLength(Arrays.asList("yy","bkhwmpbiisbldzknpm")));
  }

  private int maxLen = 0;

  public int maxLength(List<String> arr) {
    maxLen = 0;

    Set<Character> set = new HashSet<>();
    helper(set, arr, 0);

    return maxLen;
  }

  private void helper(Set<Character> set, List<String> arr, int index) {
    if (index == arr.size()) {
      return;
    }

    char[] s = arr.get(index).toCharArray();

    boolean unique = true;

    Set<Character> chars = new HashSet<>();
    for (char ch : s) {
      if (chars.contains(ch) || set.contains(ch)) {
        unique = false;
        break;
      }

      chars.add(ch);
    }

    helper(set, arr, index + 1);

    if (unique) {
      maxLen = Math.max(maxLen, set.size() + s.length);

      set.addAll(chars);
      helper(set, arr, index + 1);
      set.removeAll(chars);
    }
  }

}
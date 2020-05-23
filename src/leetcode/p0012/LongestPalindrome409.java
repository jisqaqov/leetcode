package leetcode.p0012;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 409. Longest Palindrome
 * algorithm: Hash Table
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 5 ms, faster than 36.02% of Java online submissions
 * Memory Usage: 38.1 MB, less than 6.67% of Java online submissions
 */
public class LongestPalindrome409 {

  public static void main(String[] args) {
    LongestPalindrome409 problem = new LongestPalindrome409();
    problem.test();
  }

  private void test() {
    System.out.println(longestPalindrome("abccccdd"));
  }

  public int longestPalindrome(String s) {
    Map<Character, Integer> counter = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
    }

    boolean odds = false;
    int len = 0;

    for (char ch : counter.keySet()) {
      int num = counter.get(ch);
      if (num % 2 == 0) {
        len += num;
      } else {
        len += num - 1;
        odds = true;
      }
    }

    if (odds) {
      len++;
    }

    return len;
  }


}
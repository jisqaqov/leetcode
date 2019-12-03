package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 266. Palindrome Permutation
 * algorithm: Hash Table
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 67.52% of Java online submissions for Palindrome Permutation.
 * Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Palindrome Permutation.
 */
public class PalindromePermutation266 {

  public static void main(String[] args) {
    PalindromePermutation266 problem = new PalindromePermutation266();
    problem.test();
  }

  private void test() {
    System.out.println(canPermutePalindrome("code"));//false
    System.out.println(canPermutePalindrome("aab"));//true
    System.out.println(canPermutePalindrome("carerac"));//true
  }

  public boolean canPermutePalindrome(String s) {
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }

    int odds = 0;
    for (char ch : map.keySet()) {
      if (map.get(ch) % 2 > 0) {
        odds++;
      }
    }

    return odds <= 1;
  }

}

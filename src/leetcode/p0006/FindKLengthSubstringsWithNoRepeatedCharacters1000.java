package leetcode.p0006;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 1100. Find K-Length Substrings With No Repeated Characters
 * algorithm: Sliding Window, Hash Table
 * time complexity: O(S)
 * space complexity: O(K)
 * Runtime: 14 ms, faster than 14.00% of Java online submissions
 * Memory Usage: 38.3 MB, less than 50.00% of Java online submissions
 */
public class FindKLengthSubstringsWithNoRepeatedCharacters1000 {

  public static void main(String[] args) {
    FindKLengthSubstringsWithNoRepeatedCharacters1000 problem =
      new FindKLengthSubstringsWithNoRepeatedCharacters1000();
    problem.test();
  }

  private void test() {
    System.out.println(numKLenSubstrNoRepeats("havefunonleetcode", 5));//6
    System.out.println(numKLenSubstrNoRepeats("home", 5));//0
  }

  public int numKLenSubstrNoRepeats(String s, int k) {
    if (s.length() < k) {
      return 0;
    }

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < k; i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }

    int count = map.size() == k ? 1 : 0;

    for (int i = k; i < s.length(); i++) {
      char start = s.charAt(i - k);
      map.put(start, map.get(start) - 1);
      if (map.get(start) == 0) {
        map.remove(start);
      }

      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);

      if (map.size() == k) {
        count++;
      }
    }

    return count;
  }

}
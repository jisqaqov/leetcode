package leetcode.p0009;

/**
 * @author Jandos Iskakov
 * problem: 28. Implement strStr()
 * algorithm: String
 * time complexity: O(N*M)
 * space complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 39.2 MB, less than 6.10% of Java online submissions
 */
public class ImplementStrStr28 {

  public int strStr(String haystack, String needle) {
    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      if (haystack.substring(i, i + needle.length()).equals(needle)) {
        return i;
      }
    }

    return -1;
  }

}

package leetcode.p0018;

/**
 * @author Jandos Iskakov
 * problem: 443. String Compression
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 93.22% of Java online submissions for String Compression.
 * Memory Usage: 39.1 MB, less than 6.82% of Java online submissions for String Compression.
 */
public class StringCompression443 {

  public int compress(char[] chars) {
    int n = chars.length;

    int i = 0, j = 0;

    while (j < n) {
      char chr = chars[j];

      int start = j;
      while (j < n && chars[j] == chr) {
        j++;
      }

      int count = j - start;
      chars[i++] = chr;

      if (count > 1) {
        char[] nums = String.valueOf(count).toCharArray();
        for (char num : nums) {
          chars[i++] = num;
        }
      }
    }

    return i;
  }

}
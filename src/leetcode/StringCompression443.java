package leetcode;

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
    if (chars.length == 0) {
      return 0;
    }

    int count = 1;
    int index = 0;

    int n = chars.length;
    char chr = chars[0];

    for (int i = 0; i < n; i++) {
      if (i < n - 1 && chr == chars[i + 1]) {
        count++;
      }

      if (i == n - 1 || chr != chars[i + 1]) {
        int k = helper(chars, chr, index, count);

        index += k + 1;
        count = 1;

        if (i < n - 1) {
          chr = chars[i + 1];
        }
      }
    }

    return index;
  }

  private int helper(char[] chars, char chr, int index, int count) {
    int n = 0;

    int k = count;
    while (k > 0) {
      n++;
      k /= 10;
    }

    chars[index] = chr;

    if (count == 1) {
      return 0;
    }

    for (int i = index + n; i > index; i--) {
      int num = count % 10;
      chars[i] = (char) (num + '0');

      count /= 10;
    }

    return n;
  }

}
package leetcode.p0017;

/**
 * @author Jandos Iskakov
 * problem: 157. Read N Characters Given Read4157. Read N Characters Given Read4
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(4)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Read N Characters Given Read4.
 * Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Read N Characters Given Read4.
 */
public class ReadNCharactersGivenRead4 {

  public class Solution extends Reader4 {

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
      int k = 0;

      while (k < n) {
        char[] buf4 = new char[4];
        int n4 = read4(buf4);

        for (int i = 0; i < n4 && k < n; i++) {
          buf[k] = buf4[i];
          k++;
        }

        if (n4 == 0) {
          break;
        }
      }

      return k;
    }

  }

  private class Reader4 {
    int read4(char[] buf) {
      return 0;
    }
  }

}

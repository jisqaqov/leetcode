package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 158. Read N Characters Given Read4 II - Call multiple times
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(4)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Read N Characters Given Read4 II - Call multiple times.
 * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Read N Characters Given Read4 II - Call multiple times.
 */
public class ReadNCharactersGivenRead4IICallMultipleTimes158 {

  /**
   * The read4 API is defined in the parent class Reader4.
   *     int read4(char[] buf);
   */
    public class Solution extends Reader4 {
      private boolean isEOF = false;
      private Queue<Character> queue = new LinkedList<>();

      /**
       * @param buf Destination buffer
       * @param n   Number of characters to read
       * @return    The number of actual characters read
       */
      public int read(char[] buf, int n) {
        if (isEOF && queue.isEmpty()) {
          return 0;
        }

        int size = 0;

        while (size < n) {
          if (!queue.isEmpty()) {
            buf[size] = queue.poll();
            size++;
          } else {
            char[] buf4 = new char[4];
            int n4 = read4(buf4);

            for (int i = 0; i < n4; i++) {
              if (size < n) {
                buf[size] = buf4[i];
                size++;
              } else {
                queue.add(buf4[i]);
              }
            }

            if (n4 == 0) {
              isEOF = true;
              break;
            }
          }
        }

        return size;
      }
    }

  private class Reader4 {
    int read4(char[] buf) {
      return 0;
    }
  }

}

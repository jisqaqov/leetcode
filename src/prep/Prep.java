package prep;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    char[] a = new char[2];
    System.out.println(a);
  }

  /**
   * The read4 API is defined in the parent class Reader4.
   *     int read4(char[] buf);
   */
  public class Solution extends Reader4 {
    private boolean isEmpty = false;
    private Queue<Character> queue = new LinkedList<>();

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
      if (isEmpty) {
        if (queue.size() == 0) {
          return 0;
        }

        return fillBuf(buf, n);
      }

      while (queue.size() < n) {
        char[] buf4 = new char[4];
        int n4 = read4(buf4);

        for (int i = 0; i < n4; i++) {
          queue.add(buf[i]);
        }

        if (n4 == 0) {
          isEmpty = true;
          break;
        }
      }

      return fillBuf(buf, n);
    }

    private int fillBuf(char[] buf, int n) {
      int size = Math.min(queue.size(), n);

      for (int i = 0; i < size; i++) {
        buf[i] = queue.poll();
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

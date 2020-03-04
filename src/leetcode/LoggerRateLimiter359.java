package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 359. Logger Rate Limiter
 * algorithm: Hash Table
 * time complexity: O(1)
 * space complexity: O(N)
 * Runtime: 29 ms, faster than 80.56% of Java online submissions
 * Memory Usage: 52.5 MB, less than 100.00% of Java online submissions
 */
public class LoggerRateLimiter359 {


  class Logger {

    private Map<String, Integer> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Logger() {

    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns
     * false. If this method returns false, the message will not be printed. The timestamp is in
     * seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
      if (map.containsKey(message) && timestamp - map.get(message) < 10) {
        return false;
      }

      map.put(message, timestamp);

      return true;
    }
  }

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

}

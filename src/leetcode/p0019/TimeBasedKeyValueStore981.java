package leetcode.p0019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jandos Iskakov problem: 981. Time Based Key-Value Store
 * algorithm: Hash Table, Binary Search
 * time complexity:
 *  for set() - O(1)
 *      get() - O(log(M))
 * space complexity: O(N)
 * Runtime: 216 ms, faster than 68.85% of Java online submissions for Time Based Key-Value Store.
 * Memory Usage: 135.2 MB, less than 94.59% of Java online submissions for Time Based Key-Value Store.
 */
public class TimeBasedKeyValueStore981 {

  public TimeBasedKeyValueStore981() {

  }

  public static void main(String[] args) {
    TimeBasedKeyValueStore981 solution = new TimeBasedKeyValueStore981();
    solution.test1();
    solution.test2();
  }

  private void test1() {
    TimeMap timeMap = new TimeMap();
    timeMap.set("foo","bar",1);
    System.out.println(timeMap.get("foo",1));
    System.out.println(timeMap.get("foo",3));
    timeMap.set("foo","bar2",4);
    System.out.println(timeMap.get("foo", 4));
    System.out.println(timeMap.get("foo", 5));
  }

  private void test2() {
    TimeMap timeMap = new TimeMap();
    timeMap.set("love","high",10);
    timeMap.set("love","low",20);
    System.out.println(timeMap.get("love",5));
    System.out.println(timeMap.get("love",10));
    System.out.println(timeMap.get("love",15));
    System.out.println(timeMap.get("love",20));
    System.out.println(timeMap.get("love",25));
  }

  private static final class TimeMap {

    private Map<String, List<Object[]>> map;

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
      this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
      map.putIfAbsent(key, new ArrayList<>());
      map.get(key).add(new Object[]{value, timestamp});
    }

    public String get(String key, int timestamp) {
      String value = "";

      if (!map.containsKey(key)) {
        return value;
      }

      List<Object[]> list = map.get(key);
      int l = 0, r = map.get(key).size() - 1;

      while (l <= r) {
        int mid = l + (r - l) / 2;

        Object[] values = list.get(mid);
        int t = (int) values[1];

        if (t == timestamp) {
          return (String) list.get(mid)[0];
        } else if (t < timestamp) {
          value = (String) values[0];
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }

      return value;
    }
  }

}
